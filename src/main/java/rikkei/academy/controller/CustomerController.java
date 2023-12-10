package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.model.entity.Customer;
import rikkei.academy.model.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("save")
    public String save(Model model){
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "/save_customer";
    }
    @PostMapping("save")
    public String create(@ModelAttribute("customer") Customer customer){
       Boolean newCustomer=customerService.saveOrUpdate(customer);
        if (newCustomer){
            return "redirect:/";
        }
        return "/save_customer";
    }
}
