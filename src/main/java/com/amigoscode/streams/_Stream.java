package com.amigoscode.streams;

import com.amigoscode.imperative.Main;

import java.util.List;
import java.util.stream.Collectors;

import static com.amigoscode.streams._Stream.Gender.FEMALE;
import static com.amigoscode.streams._Stream.Gender.MALE;

public class _Stream {

    public static void main(String[] args) {

        // to import quickly press alt+enter
        List<Person> people = List.of(
                new Person("Pepe", MALE),
                new Person("Anal", FEMALE),
                new Person("Marac", FEMALE),
                new Person("Dishendo", MALE),
                new Person("Koki", FEMALE)
        );


        // bear in main  that the methods of the stream API takes predicates, suppliers, consumers and functions.
        people.stream()
                .map(person -> person.gender) // it takes a function, the map function simply does transformations
                .collect(Collectors.toSet())
                .forEach(gender -> System.out.println(gender)); // it  takes a consumer, we can turn this part as a method reference forEach(System.out::println);

        // we can also get only the length of the names.
        // to select a whole name press ctrl+w
        people.stream()
                .map(person -> person.name)
                .mapToInt(name -> name.length())// it also expects a function a ToIntFunction (it gets and argument and returns an Integer)  we also can put .mapToInt(String::length)
                .forEach(System.out::println); // Since we used a ToIntFunction, this forEach expects a IntConsumer (a consumer that expects a Integer as arg)

        // let's know if all the people are female
        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender)); // it takes a predicate
        System.out.println(
                containsOnlyFemales
        );

        // let's know if any of the people are female
        System.out.println(people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender)));

        // we can also use noneMatch that returns true if there is no values
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
