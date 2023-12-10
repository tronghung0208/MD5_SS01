package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rikkei.academy.model.entity.Customer;
import rikkei.academy.model.service.CustomerService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public String demo(Model model){
        List<Customer> list = customerService.findAll();
        model.addAttribute("list",list);
        return "home";
    }
}
