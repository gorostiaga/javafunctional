package com.amigoscode.functionalinternface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {

        System.out.println(getDBConnectionUrl());

        // for Supplier we need to use get method
        System.out.println(getDBConnectionUrlSupplier.get());

        System.out.println(getListDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl () {
        return "jdbc://localhost:5432/users";
    }

    // the functional interface Supplier<T> represents a supplier of results
    // it means that returns any kind of value u want
    // we gotta specigy the output type
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";

    static Supplier<List<String>> getListDBConnectionUrlSupplier = () -> List.of("jdbc://localhost:5432/users", "jdbc://localhost:5432/pepes");
}
