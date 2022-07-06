package com.customermanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customermanager.entity.Customer;
import com.customermanager.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String showRegisteredCustomers(Model theModel) {
		List<Customer> customers = customerService.findAllCustomers();
		theModel.addAttribute("Customers", customers);
		return "customer_list";
	}

	@RequestMapping("/add")
	public String showCustomerForm(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("Customer", customer);
		return "customer_form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println("Saving Customer");

		Optional<Customer> customer;

		Customer theCustomer = new Customer();

		if (id != 0) {
			theCustomer = customerService.findById(id).get();

			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);

		} else {
			theCustomer = new Customer(firstName, lastName, email);

		}
		customerService.saveCustomer(theCustomer);
		return "redirect:/list";

	}

	@RequestMapping("/edit")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
		// create model attribute to bind form data

		Customer theCustomer = customerService.findById(theId).get();
		theModel.addAttribute("Customer", theCustomer);

		return "customer_form";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int theId) {
		customerService.deleteCustomerById(theId);

		return "redirect:/list";
	}

}
