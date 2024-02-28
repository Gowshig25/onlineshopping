package com.onlineshopping;

import com.onlineshopping.business.ProductOperations;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.onlineshopping.utils.Constants.INVALID_INPUT;

public class OnlineShopping {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ProductOperations prodoperation = new ProductOperations();
        menuTemplate();
        try {
            int choice = in.nextInt();

            boolean flag = true;

            while (flag) {

                switch (choice) {
                    case 1:
                        prodoperation.addItems();
                        break;
                    case 2:
                        prodoperation.findItem();
                        break;
                    case 3:
                        prodoperation.displayEntireItem();
                        break;
                    case 4:
                        prodoperation.removeItems();
                        break;
                    case 5:
                        prodoperation.updateItems();
                        break;
                    case 6:
                        flag = false;
                        System.out.println("Program ends Successfully");
                        break;
                    default:
                        flag = false;
                        System.out.println("Program ends as choice is not available: " + choice);

                }
                if (choice <= 5 && choice >= 1) {
                    menuTemplate();
                    choice = in.nextInt();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT);
        }
    }

    public static void menuTemplate() {
        System.out.println();
        System.out.println("              |----------------------------------------|");
        System.out.println("              *           Online Shopping             *");
        System.out.println("              |                                        |");
        System.out.println("              |     1. Add Items to the Stock          |");
        System.out.println("              |                                        |");
        System.out.println("              |     2.  Find Items                     |");
        System.out.println("              |                                        |");
        System.out.println("              |     3.  Display Entire Item            |");
        System.out.println("              |                                        |");
        System.out.println("              |     4. Remove Item from list           |");
        System.out.println("              |                                        |");
        System.out.println("              |     5.Update Items                     |");
        System.out.println("              |                                        |");
        System.out.println("              |     6. Exist                           |");
        System.out.println("              |----------------------------------------|");

        System.out.println("Enter your choice");
    }
}
