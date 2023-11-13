package com.amigoscode.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.amigoscode.imperative.Main.Gender.*;

//In imperative programming u define every single detail about your implementation
public class Main {
    //a shortcut to write it is psvm
    public static void main(String[] args) {
        //Press alt+enter and Add static import to remove the enum Gender and set it as an import
        List<Person> people = List.of(
                new Person("Pepe", MALE),
                new Person("Anal", FEMALE),
                new Person("Marac", FEMALE),
                new Person("Dishendo", MALE),
                new Person("Koki", FEMALE)
        );

        //Imperative approach to know how many female we have
        List<Person> females = new ArrayList<>();
        for(Person person : people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for(Person female : females){
            //a shortkey is sout
            System.out.println(female);
        }

        //declarative approach
        //the way we use declarative approach by using streams with collection
        //streams allows us to go into an abstract mode where we simply tell it what we want.
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);

        //we can extract an operation to a variable:
        // select all the operation a press ctrl+alt+v
        // delete a complete line ctrl+y
        List<Person> females2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);

        // the package java.util.function contains functional interfaces
        // that provide target times for lambda  expression and method references
        // a functional interface must have only one abstract method
        // in this declarative approach
/*        List<Person> females2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());*/
        // person -> FEMALE.equals(person.gender) is predicate
        // Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        // this predicate accepts a person and returns true or false based on the person.


        // pure functions do not depend on global states, the opposite for impure functions

        // higher function is if
        // the function takes one or more functions as parameters
        // or
        // the function returns another functions as a result
    }


    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE
    }
}
