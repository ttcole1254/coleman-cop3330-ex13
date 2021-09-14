package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 13 Solution
 *  Copyright 2021 Tyler Coleman
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the principal: ");
        String principalS = in.nextLine();
        System.out.println("Enter the rate of interest percentage: ");
        String interestPercentS = in.nextLine();
        System.out.println("Enter the number of years: ");
        String yearsS = in.nextLine();
        System.out.println("Enter the number of times the interest is compounded per year: ");
        String compoundsS = in.nextLine();
        double principal = Double.parseDouble(principalS);
        double interestPercent = Double.parseDouble(interestPercentS);
        double years = Double.parseDouble(yearsS);
        double compounds = Double.parseDouble(compoundsS);
        double interest = interestPercent / 100;
        String yearsQuote;
        for (int i = 1; i <= years; i++) {
            double total = principal * Math.pow(1 + (interest / compounds), compounds * i);
            BigDecimal result = new BigDecimal(total).setScale(3, RoundingMode.HALF_UP);
            NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
            if (i == 1) {
                yearsQuote = "year";
            }
            else {
                yearsQuote = "years";
            }
            System.out.printf("$%.02f invested at %.02f%% for %d %s compounded %.02f times per year is %s.\n", principal, interestPercent, i, yearsQuote, compounds, usdCostFormat.format(result.doubleValue()));
        }
    }
}
