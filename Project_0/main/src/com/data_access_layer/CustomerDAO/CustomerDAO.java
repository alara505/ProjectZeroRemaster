package com.data_access_layer.CustomerDAO;

import com.entities.Customer;

import java.util.List;


public interface CustomerDAO {


    Customer getCustomerById(int customerId);

    Customer createCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer checkCustomerLogin(String username, String passcode);

    Customer updateCustomerById(int customerId, String firstName, String lastName);

    Boolean deleteCustomer(int customerId);

}
