package com.data_access_layer.CustomerDAO;

import com.entities.customer;


public interface CustomerDAOImp {


    customer getCustomerById(int customerId);
}
