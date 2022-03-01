package com.data_access_layer.CustomerDAO;

import com.entities.customer;

import java.util.List;


public interface CustomerDAOImp {


    customer getCustomerById(int customerId);

    customer createCustomer(customer customer);

    List<customer> getAllCustomers();

    customer updateCustomerById(customer customer);

    Boolean deleteCustomer(int customerId);
    
}
