package com.controllers;

import com.google.gson.Gson;
import com.custom_exceptions.InvalidPassword;
import com.custom_exceptions.InvalidUsername;
import com.custom_exceptions.CustomerNotFound;
import com.entities.Customer;
import io.javalin.http.Handler;
import com.service_layer.CustomerDAO.CustomerServiceImps;

import java.util.List;

public class CustomerController {

    CustomerServiceImps customerServiceImps;

    public CustomerController(CustomerServiceImps customerServiceImps){
        this.customerServiceImps = customerServiceImps;
    }

    public Handler getCustomer = ctx -> {
        int customerId = Integer.parseInt(ctx.pathParam("customerId"));
        try{
            Customer customer = this.customerServiceImps.serviceGetCustomerById(customerId);
            Gson gson = new Gson();
            String userJson = gson.toJson(customer);
            ctx.result(userJson);
            ctx.status(200);
        } catch (CustomerNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getAllCustomers = ctx ->{
        List<Customer> customers = this.customerServiceImps.serviceGetAllCustomers();
        Gson gson = new Gson();
        String userJSONs = gson.toJson(customers);
        ctx.result(userJSONs);
        ctx.status(200);
    };

    public Handler checkCustomerLogin = ctx -> {
        try{
            Gson gson = new Gson();
            Customer jsonInfo = gson.fromJson(ctx.body(), Customer.class);
            String username = jsonInfo.getUsername();
            String passcode = jsonInfo.getPasscode();
            Customer customer = this.customerServiceImps.serviceCheckCustomerLogin(username, passcode);
            String checkedCustomer = gson.toJson(customer);
            ctx.result(checkedCustomer);
            ctx.status(200);
        } catch (InvalidUsername | InvalidPassword e){
            Gson gson = new Gson();
            ctx.result(e.getMessage());
            ctx.status(204);
        }
    };


}
