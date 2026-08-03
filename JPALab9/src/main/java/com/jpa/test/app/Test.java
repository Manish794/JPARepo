package com.jpa.test.app;

public class Test {
    public static void main(String[] args) {

        String existing = "B1-009";
        if(existing.isBlank()) {
            System.out.println("B1-001");
        } else {
            int hyphenIndex = existing.indexOf("-");
            String maxId = existing.substring(hyphenIndex+1);
            long maxIdLong = Long.parseLong(maxId);
            System.out.println("B1-"+ String.format("%03d",maxIdLong + 1));

        }

    }
}
