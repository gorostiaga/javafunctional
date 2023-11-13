package com.amigoscode.functionalinternface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    // The functional interface Consumer<T> from the package java.util.function takes one input and returns no result

    public static void main(String[] args) {

        Customer maria = new Customer("Maria", "9999999");
        greetCustomer(maria);

        //using the Consumer
        // with consumer we use accept instead of apply
        greetCustomerConsumer.accept(maria);

        //using the BiConsumer
        greetCustomerConsumerV2.accept(maria, false);

    }

    static void greetCustomer (Customer customer){
        System.out.println("Hello "+customer.customerName +
                ", thanks for registering phone number "+customer.customerPhoneNumber);
    }
    static void greetCustomerV2 (Customer customer, boolean showPhoneNUmber){
        System.out.println("Hello "+customer.customerName +
                ", thanks for registering phone number "+ (showPhoneNUmber? customer.customerPhoneNumber : "*******"));
    }

    // now with functional interface Consumer<T>
    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello "+customer.customerName +
            ", thanks for registering phone number "+customer.customerPhoneNumber);

    // the same, BiConsumer takes 2 arg and returns no result
    // we will use a boolean to show or not the phone number
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNUmber) -> System.out.println("Hello "+customer.customerName +
            ", thanks for registering phone number "+ (showPhoneNUmber? customer.customerPhoneNumber : "*******"));

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
