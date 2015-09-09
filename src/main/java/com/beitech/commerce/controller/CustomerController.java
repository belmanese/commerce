package com.beitech.commerce.controller;

import com.beitech.commerce.model.Customer;
import com.beitech.commerce.service.CustomerService;
import com.beitech.commerce.util.Utilitie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Utilitie utilitieService;

    @RequestMapping(value = { "/customer", "/customer/list" }, method = RequestMethod.GET)
    public String list(ModelMap model) {

        model.addAttribute("customers", utilitieService.removeDuplicate(customerService.findAll()));
        return "../customer/customers";

    }

    @RequestMapping(value = { "/customer/new" }, method = RequestMethod.GET)
    public String createRedirect(ModelMap model) {

        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("edit", false);
        return "../customer/create_customer";

    }

    @RequestMapping(value = { "/customer/new" }, method = RequestMethod.POST)
    public String create(@Valid Customer customer, BindingResult result,
                               ModelMap model) {

        if (result.hasErrors())
            return "../customer/create_customer";

        customerService.create(customer);

        model.addAttribute("successCustomerTransaction", customer.getName() + " fue registrado exitosamente");
        return "../customer/success_customer";

    }

    @RequestMapping(value = { "/customer/edit-{id}-customer" }, method = RequestMethod.GET)
    public String updateRedirect(@PathVariable String id, ModelMap model) {

        Customer customer = customerService.read(Integer.parseInt(id));
        model.addAttribute("customer", customer);
        model.addAttribute("edit", true);
        return "../customer/create_customer";

    }

    @RequestMapping(value = { "/customer/edit-{id}-customer" }, method = RequestMethod.POST)
    public String update(@Valid Customer customer, BindingResult result,
                                 ModelMap model, @PathVariable String id) {

        if (result.hasErrors())
            return "../customer/create_customer";

        customerService.update(customer);

        model.addAttribute("successCustomerTransaction", customer.getName() + " fue registrado exitosamente");
        return "../customer/success_customer";

    }

    @RequestMapping(value = { "/customer/delete-{id}-customer" }, method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {

        customerService.delete(id);
        return "redirect:../customer/list";

    }

}
