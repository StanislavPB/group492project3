package org.group492project3.frontEnd.services;

import java.util.InputMismatchException;

import org.group492project3.frontEnd.services.validation.Validation;

import java.util.Scanner;

public class UserInputService {
    DecorationService decor;
    MessageService message;

    public UserInputService(DecorationService decor, MessageService message) {
        this.decor = decor;
        this.message = message;
    }

    public int getInt(String text) {
        System.out.print(text);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public int getInt() {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        int number = 0;
        while (!valid) {
            try {
                number = in.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                message.printErrorMessage("Incorrect input.Please input number.Try again.");
                System.out.print("Enter number of item:");
                in.next();
            }
        }
        return number;
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