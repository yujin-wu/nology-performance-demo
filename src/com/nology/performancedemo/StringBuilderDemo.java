package com.nology.performancedemo;

public class StringBuilderDemo {
    public static void main(String[] args) {

        // start timer
        long start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 600000; i++) {
            sb.append("b");
        }

        // Group Table, Participants Table,

        System.out.println(sb);

        long end = System.currentTimeMillis();
        System.out.println("Length of string " + sb.length() + " in " + (end - start) + " ms");
    }
}
