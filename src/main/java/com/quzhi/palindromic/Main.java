package com.quzhi.palindromic;

public class Main {

    public static void main(String[] args) {
        String testStr0 = "banana"; // "nan", "ana"
        String testStr1 = "cbbd"; // "bb"
        String testStr2 = "babad"; // "aba", "bab"
        String testStr3 = "pqweriqwerabgghggbazxcvzx"; // "abgghggba"
        String testStr4 = "p"; // "abgghggba"
        System.out.println(dynamicProgramming(testStr0));
        System.out.println(dynamicProgramming(testStr1));
        System.out.println(dynamicProgramming(testStr2));
        System.out.println(dynamicProgramming(testStr3));
        System.out.println(dynamicProgramming(testStr4));
    }

    private static String dynamicProgramming(final String inputStr) {
        boolean[][] isPalinMatrix = new boolean[inputStr.length()][inputStr.length()];
        int left = 0;
        int right = 0;
        for (int len = 2; len < inputStr.length(); len++) {
            for (int i = 0; i < inputStr.length() - len; i++) {
                int j = i + len;
                if ((len == 2 || len == 3) && inputStr.charAt(i) == inputStr.charAt(j - 1)) {
                    isPalinMatrix[i][j] = true;
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                } else if (isPalinMatrix[i + 1][j - 1] && inputStr.charAt(i) == inputStr.charAt(j - 1)) {
                    isPalinMatrix[i][j] = true;
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                } else {
                    isPalinMatrix[i][j] = false;
                }
//                System.out.println("substring (" + i + ", " + j + "): " + inputStr.substring(i, j) + "? " + isPalinMatrix[i][j]);
            }
        }
        if (right - left < 1) {
            return "";
        } else {
            return inputStr.substring(left, right);
        }
    }
}
