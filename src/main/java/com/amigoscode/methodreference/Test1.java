package com.amigoscode.methodreference;

public class Test1 {

    static <T> int tester (Pepe<T> p, int v, T t){
        return p.funct(t, v);
    }

    public static void main(String[] args) {

        Temperature temperature = new Temperature();

        System.out.println("es mayor a cero? " + tester(Temperature::sumUp, 1, temperature));

    }
}
