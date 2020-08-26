package com.gerardo.romannumerals.conversor;

import java.util.Hashtable;

public class RomanConversor {

    public String toRoman(int decimalNumber) throws Exception {
        return (new TupleMapper(new NumberBreaker(decimalNumber).breakdown())).getRomanNumber();
    }

    public int toDecimal(String arabicNumber) throws Exception{
        return romanToDecimal(arabicNumber);
    }

    private int romanToDecimal(String num) throws Exception {
        Hashtable<Character, Integer> ht = getRomansMap();
        try{
            int intNum=0;
            int prev = 0;
            for(int i = num.length()-1; i>=0 ; i--)
            {
                int temp = ht.get(num.charAt(i));
                if(temp < prev)
                    intNum-=temp;
                else
                    intNum+=temp;
                prev = temp;
            }
            return intNum;
        } catch(Exception e){
            throw e;
        }

    }

    private Hashtable<Character, Integer> getRomansMap() {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        ht.put('I',1);
        ht.put('X',10);
        ht.put('C',100);
        ht.put('M',1000);
        ht.put('V',5);
        ht.put('L',50);
        ht.put('D',500);
        return ht;
    }

}
