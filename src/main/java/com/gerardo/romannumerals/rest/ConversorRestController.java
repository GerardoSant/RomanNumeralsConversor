package com.gerardo.romannumerals.rest;


import com.gerardo.romannumerals.conversor.RomanConversor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ConversorRestController {

    @RequestMapping("/decimalToRoman")
    public String decimalToRoman(@RequestParam String number, HttpServletResponse response){
        try{
            return new RomanConversor().toRoman(Integer.parseInt(number));
        } catch (Exception e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Error: Invalid number - Roman numerals goes from 1 to 4000";
        }
    }

    @RequestMapping("/romanToDecimal")
    public String romanToDecimal(@RequestParam String number, HttpServletResponse response){
        try{
            return String.valueOf(new RomanConversor().toDecimal(number));
        } catch (Exception e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Error: Invalid number - Passed number was not detected as roman number";
        }
    }
}
