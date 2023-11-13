package com.amigoscode.optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // show the string or other message in case the fist arg is null
        Object value = Optional.ofNullable(null).orElseGet(() -> "default value");
        System.out.println(value);

        // we can also throw an exception
        //Object value2 = Optional.ofNullable(null).orElseThrow(() -> new IllegalStateException("exception"));

        // do something if we have a value
        Optional.ofNullable("pepe@pepe.com").ifPresent(email -> System.out.println("sending email to "+email));

        // we can give an alternative in case we dont find the value
        // it takes a consumer then a runnable
        Optional.ofNullable(null).ifPresentOrElse(email -> System.out.println("sending email to "+email),
                ()-> System.out.println("cannot send email"));

    }

    // Optional helps u  to deal with null pointer exceptions
}
