package com.example.demofib;
import java.math.BigInteger;
import java.util.List;

public class Fib {

    private int elements;

    private List<BigInteger> fibonacci;

    public int getElements() {
        return elements;
    }

    public List<BigInteger> getFibonacci() {
        return fibonacci;
    }

    public List<BigInteger> getSortedfib() {
        return sortedfib;
    }

    private List<BigInteger> sortedfib;

    public Fib() {

    }
    public Fib(List<BigInteger> fibonacci, List<BigInteger> sortedfib) {
        this.fibonacci = fibonacci;
        this.sortedfib = sortedfib;
    }

}
