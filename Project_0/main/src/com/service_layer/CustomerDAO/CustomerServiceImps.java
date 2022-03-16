package com.service_layer.CustomerDAO;

import com.entities.Customer;

import java.util.List;

public interface CustomerServiceImps {


    Customer serviceGetCustomerById(int customerId);

    Customer serviceCreateCustomer(Customer customer);

    List<Customer> serviceGetAllCustomers();

    Customer serviceCheckCustomerLogin(String username, String passcode);

    Customer serviceUpdateCustomerById(int customerId, String firstName, String lastName);

    Boolean serviceDeleteCustomer(int customerId);
}
