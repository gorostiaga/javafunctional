package com.amigoscode.methodreference;

interface Pepe<T> {
    int funct(T v1, int v2);

}

public class Temperature {

    int sumUp(int v){
        return ++v;
    }

    int reduce(int v){
        return --v;
    }
}
