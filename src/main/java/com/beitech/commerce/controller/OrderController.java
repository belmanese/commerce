package com.beitech.commerce.controller;

import com.beitech.commerce.dto.OrderDto;
import com.beitech.commerce.model.Order;
import com.beitech.commerce.service.CustomerService;
import com.beitech.commerce.service.OrderService;
import com.beitech.commerce.util.Utilitie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Utilitie utilitieService;

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String list(ModelMap model) {

        new UpdatingCurrencyRate().start();

        model.addAttribute(
            "orders",
            utilitieService.removeDuplicate(orderService.findAll())
        );
        return "orders";

    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String createRedirect(ModelMap model) {

        model.addAttribute(
            "orderDto", new OrderDto(
                new Order(), utilitieService.removeDuplicate(customerService.findAll())
            )
        );
        model.addAttribute("edit", false);
        return "create_order";

    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String create(@Valid Order order, BindingResult result, ModelMap model) {

        if (result.hasErrors())
            return "create_order";

        orderService.create(order);

        model.addAttribute("successOrderTransaction", order.getId() + " fue registrada exitosamente");
        return "success_order";

    }

    @RequestMapping(value = { "/edit-{id}-order" }, method = RequestMethod.GET)
    public String updateRedirect(@PathVariable String id, ModelMap model) {

        model.addAttribute(
                "orderDto", new OrderDto(
                        orderService.read(Integer.parseInt(id)),
                        utilitieService.removeDuplicate(customerService.findAll())
                )
        );
        model.addAttribute("edit", true);
        return "create_order";

    }

    @RequestMapping(value = { "/edit-{id}-order" }, method = RequestMethod.PUT)
    public String update(@Valid Order order, BindingResult result,
                                 ModelMap model, @PathVariable String id) {

        if (result.hasErrors())
            return "create_order";

        orderService.update(order);

        model.addAttribute("successOrderTransaction", order.getId() + " fue registrada exitosamente");
        return "success_order";

    }

    @RequestMapping(value = { "/delete-{id}-order" }, method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {

        orderService.delete(id);
        return "redirect:list";

    }

    @RequestMapping(value = { "/find-{customerId}-order" }, method = RequestMethod.GET)
    public String findAllOrdersByCustomerIntoDate(
        @PathVariable String customerId,
        @RequestParam(value = "from", defaultValue = "") String from,
        @RequestParam(value = "to", defaultValue = "") String to,
        Model model) {

        Date fromDate = new Date();
        Date toDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        try {
            fromDate = formatter.parse(from);
            toDate = formatter.parse(to);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute(
            "ordersByCustomer", orderService.OrdersByCustomerIntoDate(customerId, fromDate, toDate)
        );
        return "order_by_customer";

    }

    /*
     *This inner class updating the currency rate from "INVOICE" table
     * every 45 minutes when start application.
     */
    class UpdatingCurrencyRate extends Thread {

        @Override
        public void run() {

            Timer timer = new Timer ( 2700000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    startingScan();
                }
            });

            timer.start();

        }

        private void startingScan() {
            String currencyRate = "";
            try {
                String url = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
                InputStream is = new URL(url).openStream();
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(is);

                NodeList nodeList = doc.getElementsByTagName("Cube");

                for (int i = 0; i < nodeList.getLength(); i ++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if(element.getAttribute("currency").equals("USD"))
                            currencyRate = element.getAttribute("rate");
                    }
                }
            }
            catch (Exception e)        {
                e.printStackTrace();
            }
            orderService.updateCurrencyRate(currencyRate);
        }

    }


}
