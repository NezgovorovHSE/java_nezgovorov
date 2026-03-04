package com.example.military;

import com.example.military.ui.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   СИСТЕМА УПРАВЛЕНИЯ ВОЕННЫМ СОСТАВОМ");
        System.out.println("=========================================");

        Menu menu = new Menu();
        menu.start();
    }
}