package com.example.gleb.lesson54;

/**
 * Created by gleb on 14.02.2016.
 */
public class Product {

    String name;
    int price;
    int image;
    boolean box;

    Product(String _describe, int _price, int _image, boolean _box) {
        name = _describe;
        price = _price;
        image = _image;
        box = _box;
    }

}
