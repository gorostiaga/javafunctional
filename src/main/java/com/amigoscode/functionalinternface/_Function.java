package com.amigoscode.functionalinternface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    // a shortkey for create this method is psvm
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        // to use the Function type
        // the apply method takes the argument
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);

        // we can chain funtions
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(1));
        // we coul've used also this: incrementByOneFunction.andThen(multiplyBy10Function).apply(1);
        System.out.println("pepe "+incrementByOneFunction.andThen(multiplyBy10Function).apply(1));

        //using the BiFunction
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4,100));

    }
    static int incrementByOne(int number){
        return number+1;
    }

        // a Function of the package java.util.function accepts one argument and produces a result

    // to convert incrementByOne Functional style, I mean into a Function<T,R> T is the input and R is the output
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function  = number -> number * 10;


    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number+1)*numToMultiplyBy;
    }
    // a BiFunction takes to inputs a produces 1 output
    // lets define incrementByOneAndMultiply with a BiFunction
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne+1)*numberToMultiplyBy;
}
