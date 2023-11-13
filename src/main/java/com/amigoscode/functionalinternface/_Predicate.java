package com.amigoscode.functionalinternface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println(isPhoneNumberValid("07000000000"));

        //for predicate we need to use test method
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));

        // let's chain predicates with and
        System.out.println("Is valid and contains 3 = " +
        isPhoneNumberValidPredicate.and(contains3).test("09083578412") );

        // we can also chain with or
        System.out.println("Is valid or contains 3 = " +
                isPhoneNumberValidPredicate.or(contains3).test("09083578412") );
    }

    static boolean isPhoneNumberValid (String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() ==11;
    }

    // the functional interface Predicate<T> represents a predicate (boolean-valued function) of one argument
    // the isPhoneNumberValid with predicate
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() ==11;

    static Predicate<String> contains3 = phoneNumber -> phoneNumber.contains("3");

    // we also have BiPredicates
    // BiPredicate<String, String>
}
