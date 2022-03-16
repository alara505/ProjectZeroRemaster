package com.service_layer.CustomerDAO;

import com.entities.Customer;

import java.util.List;

public class CustomerServiceImp implements CustomerServiceImps {

    @Override
    public Customer serviceGetCustomerById(int customerId){
        return null;
    }

    @Override
    public Customer serviceCreateCustomer(Customer customer){
        return null;
    }

    @Override
    public List<Customer> serviceGetAllCustomers(){
        return null;
    }

    @Override
    public Customer serviceCheckCustomerLogin(String username, String passcode){
        return null;
    }

    @Override
    public Customer serviceUpdateCustomerById(int customerId, String firstName, String lastName){
        return null;
    }

    @Override
    public Boolean serviceDeleteCustomer(int customerId){
        return null;
    }


}
