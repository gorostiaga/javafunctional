package com.amigoscode.finalsection;

import java.util.function.Function;

interface Pepe{
    int func(int n);
}

public class Lambdas {

    static String perra;

    public static void main(String[] args) {

        // the lambda is name ->
        Function <String, String> upperCaseName1 = name -> name.toUpperCase();
        //is the same has because is just one line
        Function <String, String> upperCaseName2 = String::toUpperCase;
        int druxxx;
        druxxx = 100;
        Pepe myLambda = n -> {
            int local;
            local = druxxx + 1;
            perra = "mierda";

            return local;
        };


        int result = myLambda.func(druxxx);
        System.out.println(druxxx);




    }
}
