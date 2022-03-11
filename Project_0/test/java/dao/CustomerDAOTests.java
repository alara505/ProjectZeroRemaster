package java.dao;

import com.entities.Customer;
import com.data_access_layer.CustomerDAO.CustomerDAO;
import com.data_access_layer.CustomerDAO.CustomerDAOImp;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CustomerDAOTests {

    CustomerDAO customerDAO = new CustomerDAOImp();

    Customer newCustomer = new Customer(10, "Alex", "Lara", "alex101", "password");

    @Test
    void selectCustomerById(){
        Customer customer = customerDAO.getCustomerById(10);
        System.out.println(customer);
        Assert.assertEquals(customer.getCustomerId(), 10);
    }
}
