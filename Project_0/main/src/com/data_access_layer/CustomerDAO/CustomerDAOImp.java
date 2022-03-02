package com.data_access_layer.CustomerDAO;

import com.entities.customer;
import com.data_access_layer.CustomerDAO.CustomerDAO;
import com.util.DatabaseConnection;
import com.custom_exceptions.CustomerNotFound;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImp implements CustomerDAO {

    static int customer_id_gen = 4;

    @Override
    public customer getCustomerById(int customerId) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from customer_table where customer_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                customer customer = new customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setUsername(resultSet.getString("username"));
                customer.setPasscode(resultSet.getString("passcode"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                return customer;
            }
            else {
                throw new CustomerNotFound("Customer not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public customer createCustomer(customer customer) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into customer_table values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setString(2,customer.getUsername());
            preparedStatement.setString(3, customer.getPasscode());
            preparedStatement.setString(4, customer.getFirstName());
            preparedStatement.setString(5, customer.getLastName());
            preparedStatement.executeUpdate();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<customer> getAllCustomers() {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from user_table";
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            List<customer> customers = new ArrayList<>();
            while(resultset.next()){
                customer customer = new customer();
                customer.setCustomerId(resultset.getInt("customer_id"));
                customer.setUsername(resultset.getString("username"));
                customer.setPasscode(resultset.getString("passcode"));
                customer.setFirstName(resultset.getString("first_name"));
                customer.setLastName(resultset.getString("last_name"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public customer checkCustomerLogin(String username, String passcode) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from customer_table where username = ? and passcode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(1, passcode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                customer customer = new customer(
                        resultSet.getInt("customer_id"),
                        resultSet.getString("username"),
                        resultSet.getString("passcode"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                return customer;
            }
            else{
                throw new CustomerNotFound("Customer not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public customer updateCustomerById(customer customer) {
        return null;
    }

    @Override
    public Boolean deleteCustomer(int customerId) {
        return null;
    }
}
