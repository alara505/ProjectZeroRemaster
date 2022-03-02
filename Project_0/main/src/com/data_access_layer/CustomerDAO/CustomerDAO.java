package com.data_access_layer.CustomerDAO;

import com.entities.customer;

import java.util.List;


public interface CustomerDAO {


    customer getCustomerById(int customerId);

    customer createCustomer(customer customer);

    List<customer> getAllCustomers();

    customer checkCustomerLogin(String username, String passcode);

    customer updateCustomerById(customer customer);

    Boolean deleteCustomer(int customerId);

}
