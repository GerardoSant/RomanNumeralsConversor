package com.gerardo.romannumerals.conversor;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class NumberBreaker {
    private final int number;

    public NumberBreaker(int number) {
        this.number = number;
    }

    public int[][] breakdown(){
        if(number <= 0 || number >= 4000) return null;
        return stream()
                .map(this::tuple)
                .filter(this::isNotZero)
                .toArray(int[][]::new);
    }

    private String number() {
        return String.valueOf(number);
    }

    private boolean isNotZero(int[] tuple) {
        return tuple[0] != 0;
    }

    private int[] tuple(Integer i) {
        return new int[] {
                parseInt(number().substring(i,i+1)),
                number().length() - 1 - i
        };
    }

    private Stream<Integer> stream() {
        return IntStream.iterate(0, l -> l + 1)
                .limit(number().length())
                .boxed();
    }


}
