package com.sorbac.codeChef.easy.ATM;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final double TRANSACTION_FEE = .5d;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Integer withdrawal = input.nextInt();
        Double accountCash = input.nextDouble();
        checkAndWithdraw(withdrawal, accountCash);
    }

    private static void checkAndWithdraw(Integer withdrawal, Double accountCash) {
        if (withdrawal % 5 != 0 || accountCash < withdrawal + TRANSACTION_FEE) {
            System.out.printf("%.2f", accountCash);
        } else {
            System.out.printf("%.2f", accountCash - withdrawal - TRANSACTION_FEE);
        }
    }
}