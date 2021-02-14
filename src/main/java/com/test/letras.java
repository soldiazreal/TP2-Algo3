package com.test;

import java.awt.*;
import java.util.Arrays;

public class letras {

    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        System.out.println(Arrays.toString(fontNames));
    }


}
