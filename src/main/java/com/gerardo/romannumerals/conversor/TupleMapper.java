package com.gerardo.romannumerals.conversor;

import static java.util.Arrays.stream;


public class TupleMapper {

    private final String[][] romanTable= {{"I","II","III","IV","V","VI","VII","VIII","IX"},
            {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"M","MM","MMM"}};

    private int[][] brokenNumber;

    public TupleMapper(int[][] brokenNumber) {
        this.brokenNumber = brokenNumber;
    }

    public String getRomanNumber() throws Exception {
        if (brokenNumber==null) throw new Exception();
        return stream(brokenNumber).map(s-> romanTable[s[1]][s[0]-1]).reduce("", String::concat);
    }

}
