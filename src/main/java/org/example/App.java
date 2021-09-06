/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 James Karlinski
 */

package org.example;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        final double WI_TAX_RATE = 0.055;
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the order amount? ");
        double orderAmount = scanner.nextDouble();

        System.out.print("What is the state? ");
        String stateInput = scanner.next();

        String wiStateMessage = "";
        DecimalFormat moneyFormatter = new DecimalFormat("#,##0.00");
        if(stateInput.equalsIgnoreCase("wi") || stateInput.equalsIgnoreCase("wisconsin")) {
            double taxAmount = orderAmount * WI_TAX_RATE;
             wiStateMessage = MessageFormat.format(
                "The subtotal is ${0}.\nThe tax is ${1}.\n",
                moneyFormatter.format(orderAmount),
                moneyFormatter.format(orderAmount * WI_TAX_RATE)
             );

            orderAmount = orderAmount + taxAmount;
        }

        String finalMessage = MessageFormat.format(
            "{0}The total is ${1}.",
            wiStateMessage,
            moneyFormatter.format(orderAmount)
        );

        System.out.println(finalMessage);
    }
}
