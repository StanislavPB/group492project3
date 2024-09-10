package org.group492project3.frontEnd.services;

import java.util.Scanner;

public class UserInputService {
    public int getInt(String text) {
        System.out.print(text);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public String getString(String text) {
        System.out.print(text);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}