package com.sorbac.codeChef.may14.ojumps;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        long myInput = Long.valueOf(input.readLine());
        out.append(isJumpable(myInput) ? "yes" : "no");
        out.newLine();
        out.flush();
    }

    public static boolean isJumpable(long myLong) {
        int myModulo = (int) (myLong % 6);
        if (myModulo == 0 || myModulo == 1 || myModulo == 3) {
            return true;
        }
        return false;
    }

}
