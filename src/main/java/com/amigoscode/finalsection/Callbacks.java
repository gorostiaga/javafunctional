package com.amigoscode.finalsection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {

        // simulating a callback in JAVA
        hello("Pepe", null, value -> {
            System.out.println("no lastname for "+value);
        });

        hello2("Pepe", null, () -> {
            System.out.println("no lastname");
        });

    }

    // In JS
    //    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName)
//        } else {
//            callback();
//        }getDBConnectionUrlSupplier
//    }

    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }


}
