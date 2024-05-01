package com.project.demo.dao;

import java.util.List;

import com.project.demo.entity.Customer;

public interface CustomerDao {

    public List <Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
