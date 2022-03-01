package com.entities;

public class customer {
        private int customerId;
        private String username;
        private String passcode;
        private String firstName;
        private String lastName;

        public customer(){}

        public customer(int customerId, String firstName, String lastName, String username, String passcode){
            this.setCustomerId(customerId);
            this.setUsername(username);
            this.setPasscode(passcode);
            this.setFirstName(firstName);
            this.setLastName(lastName);
        }

        @Override
        public String toString(){
            return "Customer{" +
                    "customerId=" + getCustomerId() +
                    ", username='" + getUsername() + '\'' +
                    ", passcode='" + getPasscode() + '\'' +
                    ", firstName='" + getFirstName() + '\'' +
                    ", lastName='" + getLastName() + '\'' +
                    '}';
        }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
