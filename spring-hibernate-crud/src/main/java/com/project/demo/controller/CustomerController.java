package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.demo.dao.CustomerDao;
import com.project.demo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;
    
//    @RequestMapping("/saveCustomer")
//    public String saveCustomer() {
//    	Customer customer = new Customer();
//		customer.setFirstName("Hari");
//		customer.setEmail("hari@gmail.com");
//		customer.setLastName("singh");
//    	customerDao.saveCustomer(customer);
//        return "redirect:/customer/list";
//    }
    
    @RequestMapping("/")
    public String customerForm(@ModelAttribute("customer") Customer customer) {
    	return "customer-form";
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List < Customer > theCustomers = customerDao.getCustomers();
        model.addAttribute("customers", theCustomers);
        for(Customer customer: theCustomers) {
        	System.out.println(customer);
        }
        return "list-customers";
        //return "redirect:/";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    	customerDao.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        Customer theCustomer = customerDao.getCustomer(id);
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {
    	customerDao.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}