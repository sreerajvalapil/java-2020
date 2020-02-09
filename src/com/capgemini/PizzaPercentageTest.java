package com.capgemini;

import java.util.Scanner;

public class PizzaPercentageTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        if (inputArray.length > 0) {
            double radius = Double.parseDouble(inputArray[0]);
            double outerCrust = Double.parseDouble(inputArray[1]);
            double areaOfCircle = radius * radius * Math.PI;
            double cheeseCircleRadius = radius - outerCrust;
            double areaOfInnerCircle = cheeseCircleRadius * cheeseCircleRadius * Math.PI;
            double percentagePizza = areaOfInnerCircle * 100 / areaOfCircle;
            System.out.printf("%.6f %n", percentagePizza);
        }

    }
}
