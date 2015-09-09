package com.beitech.commerce.controller;

import com.beitech.commerce.model.Product;
import com.beitech.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = { "/product", "/product/list" }, method = RequestMethod.GET)
    public String list(ModelMap model) {

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "../product/products";

    }

    @RequestMapping(value = { "/product/new" }, method = RequestMethod.GET)
    public String createRedirect(ModelMap model) {

        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("edit", false);
        return "../product/create_product";

    }

    @RequestMapping(value = { "/product/new" }, method = RequestMethod.POST)
    public String create(@Valid Product product, BindingResult result,
                               ModelMap model) {

        if (result.hasErrors())
            return "../product/create_product";

        productService.create(product);

        model.addAttribute("successProductTransaction", product.getName() + " fue registrado exitosamente");
        return "../product/success_product";

    }

    @RequestMapping(value = { "/product/edit-{id}-product" }, method = RequestMethod.GET)
    public String updateRedirect(@PathVariable String id, ModelMap model) {

        Product product = productService.read(Integer.parseInt(id));
        model.addAttribute("product", product);
        model.addAttribute("edit", true);
        return "../product/create_product";

    }

    @RequestMapping(value = { "/product/edit-{id}-product" }, method = RequestMethod.PUT)
    public String update(@Valid Product product, BindingResult result,
                                 ModelMap model, @PathVariable String id) {

        if (result.hasErrors())
            return "../product/create_product";

        productService.update(product);

        model.addAttribute("successProductTransaction", product.getName() + " fue registrado exitosamente");
        return "../product/success_product";

    }

    @RequestMapping(value = { "/product/delete-{id}-product" }, method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {

        productService.delete(id);
        return "redirect:../product/list";

    }

}
