package com.amigoscode.combinatorpattern;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Alice", "alice@gmail.com", "+06546555541", LocalDate.of(2000,1,1));

        System.out.println(new CustomerValidatorService().isValid(customer));
        // the problem with this is that whenever we get a false we dont know where the error is, it could be a not valid email or not valid phonenumber or both.

        // the combinator pattern allows us to chain function together, it can takes function as argument and return new funtions.
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator.isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);
        System.out.println(result);

        if(result != CustomerRegistrationValidator.ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name()); // bascally will print the same as System.out.println(result);
        }


    }
}
