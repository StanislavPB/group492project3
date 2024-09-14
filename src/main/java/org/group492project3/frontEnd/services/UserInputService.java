package org.group492project3.frontEnd.services;


import org.group492project3.frontEnd.services.validation.Validation;

import java.util.Scanner;

public class UserInputService {
    public int getInt(String text) {
        System.out.print(text);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public int getInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public String getString(String text) {
        System.out.print(text);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public String getString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}