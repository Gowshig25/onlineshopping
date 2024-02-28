package com.onlineshopping.implementations;

import com.onlineshopping.customexception.DuplicateProductExpection;
import com.onlineshopping.interfaces.ProductIntref;
import com.onlineshopping.model.Products;

import java.util.List;

public class ProductImpl implements ProductIntref {
    @Override
    public void addProducts(Products product, List<Products> products) throws DuplicateProductExpection {
        Products temp = findProduct(product.getP_name(), products);
        if (temp == null) {
            products.add(product);
            System.out.println("The item is added successfully");
        } else {
            throw new DuplicateProductExpection("The element is already exist");
        }
    }

    @Override
    public Products findProduct(String prod_name, List<Products> productList) {
        for (Products temp : productList) {
            if (temp.getP_name().equals(prod_name))
                return temp;
        }
        // throw new NoProductException("The Product is not found");
        return null;
    }

    @Override
    public Products findProductById(String prod_name, List<Products> productList) {
        for (Products temp : productList) {
            if (temp.getP_id().equals(prod_name))
                return temp;
        }
        // throw new NoProductException("The Product is not found");
        return null;
    }


    @Override
    public void deleteProduct(String productId, List<Products> products) {
        Products temp = findProductById(productId, products);
        if (temp == null) {
            System.out.println("The Product with this ID not found");
        } else {
            products.remove(temp);
            System.out.println("The Product is removed");
        }

    }

    @Override
    public void updateProducts(Products product, float new_price, int new_quantity) {
        product.setP_price(new_price);
        product.setP_quantity(new_quantity);
    }

}







/*
public static void findProduct(String val, ArrayList<Products> s) throws NoProductException {
        int flag=1;
        for(Products temp:s){
            if(temp.getP_name().equals(val)){
                flag=0;
                System.out.println(temp);
            }
        }
        if(flag==1){
            throw new NoProductException("The Product has not found");
        }

    }
 */