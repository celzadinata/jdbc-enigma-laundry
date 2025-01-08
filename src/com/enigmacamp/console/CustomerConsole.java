package com.enigmacamp.console;

import com.enigmacamp.entity.Customer;
import com.enigmacamp.service.CustomerService;
import com.enigmacamp.utils.InputHandler;

import java.util.List;

public class CustomerConsole {
    private CustomerService service;
    private InputHandler inputHandler;

    public CustomerConsole(CustomerService service, InputHandler inputHandler) {
        this.service = service;
        this.inputHandler = inputHandler;
    }

    private void showMenu(){
        System.out.println("\n==== Customer Management ====");
        System.out.println("1. Add Customer");
        System.out.println("2. List Customer");
        System.out.println("3. Update Customer");
        System.out.println("4. Back");
    }

    public void run(){
        while (true){
            this.showMenu();
            int choice = inputHandler.getInt("Pilih Menu : ");
            switch (choice){
                case 1:
                    this.createNewCustomer();
                    break;

                case 2:
                    this.getAllCustomers();
                    break;

                case 3:
                    System.out.println("Update Customer");
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    private void createNewCustomer(){
        String customerName = this.inputHandler.getString("Name : ");
        String customerAddress = this.inputHandler.getString("Address : ");
        String customerPhone = this.inputHandler.getString("Phone Number : ");
        String customerBirthDate = this.inputHandler.getString("BirthDate : ");
        Customer result = this.service.create(new Customer(customerName, customerAddress, customerPhone, customerBirthDate));
        System.out.println("Success Create New Customer : " + result);
    }

    private void getAllCustomers(){
        List<Customer> customerList = this.service.getAll();
        if (customerList.isEmpty()) {
            System.out.println("No customer available");
            return;
        }

//        Header
        System.out.printf("_______________________________________________________________________________\n");
        System.out.printf("|%-5s |%-20s |%-20s| |%-15s |$-10s\n", "ID", "Name", "Address", "Phone Number", "Birth Date");
        System.out.printf("_______________________________________________________________________________\n");
        customerList.stream().forEach(customer -> {
            System.out.printf("|%-5s |%-20s |%-20s| |%-15s |$-10s\n",
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getPhone_number(),
                    customer.getBirth_date()
            );
        });
        System.out.printf("_______________________________________________________________________________\n");
    }
}
