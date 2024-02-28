package com.onlineshopping.business;

import com.onlineshopping.customexception.DuplicateProductExpection;
import com.onlineshopping.implementations.ProductImpl;
import com.onlineshopping.interfaces.ProductIntref;
import com.onlineshopping.model.Products;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.onlineshopping.utils.CommonUtils.randomGenerate;
import static com.onlineshopping.utils.Constants.*;



public class ProductOperations {

    List<Products> products = new ArrayList<>();
    ProductIntref productImpl = new ProductImpl();
    Scanner in = new Scanner(System.in);

    /**
     * This method is used to get the inputs from user.
     */
    public void addItems() {

        int id_num = randomGenerate();
        String id = "PID_" + "" + id_num;

        try {
            System.out.println("Enter the Name of the product");
            String name = in.next();
            System.out.println(ENTER_PRICE);
            float price = in.nextFloat();
            System.out.println(ENTER_QUANTIY);
            int quan = in.nextInt();
            productImpl.addProducts(new Products(id, name, price, quan), products);
        } catch (DuplicateProductExpection e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT);
            in.nextLine();
        }
        }





    public void findItem() {
        String input1="";
        if (products.size() == 0){
            System.out.println(NO_PRODUCT);
            System.out.println("Would to like to add any items Y/N");
            input1=in.next();
            if(input1.equals("y") || input1.equals("Y")) {
                addItems();
            }
        }else{
            System.out.println("Enter the product Name ");
            String input = in.next();
            Products temp = productImpl.findProduct(input, products);
            if (temp != null)
                System.out.println(temp);
             else
                System.out.println("Where the product Not found");

        }
    }


    public void displayEntireItem() {
        if (products.size() == 0) {
            System.out.println(NO_PRODUCT);
        } else {
            for (Products temp : products) {
                System.out.println(temp);
            }
        }
    }


    //Remove Items
    public void removeItems() {
        if (products.size() == 0) {
            System.out.println(NO_PRODUCT);
        } else {
            System.out.println("Enter the ID of the product");
            String id_input = in.next();
            productImpl.deleteProduct(id_input, products);
        }
    }

    public void updateItems() {
        if (products.size() == 0) {
            System.out.println(NO_PRODUCT);
        } else {
            System.out.println("Enter the Product ID");
            String input = "";
            try {
                input = in.next();
                Products temp = productImpl.findProductById(input, products);
                if (temp == null) {
                    System.out.println("The Product with this ID not Found");
                } else {
                    System.out.println(ENTER_PRICE);
                    float new_price = in.nextFloat();
                    System.out.println(ENTER_QUANTIY);
                    int new_quantity = in.nextInt();
                    productImpl.updateProducts(temp, new_price, new_quantity);
                    System.out.println("The Item is updated Successfully");
                }
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT);
            }

        }
    }


}
