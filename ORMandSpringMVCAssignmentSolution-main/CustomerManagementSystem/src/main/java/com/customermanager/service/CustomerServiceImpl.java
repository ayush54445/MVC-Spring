package com.customermanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customermanager.dao.CustomerDao;
import com.customermanager.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Optional<Customer> findById(int id) {
		return customerDao.findById(id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);

	}

	@Override
	public void deleteCustomerById(int id) {
		customerDao.deleteById(id);

	}

}
