package com.company;

public class TableOfWinners {
    public void showTable(String[] arr) {
        System.out.print(String.format("%-20s", "you V\\computer ->"));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%-20s", arr[i]));
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%-20s", arr[i] + "    "));
            for (int j = 0; j < arr.length; j++) {
                if (i == j){
                    System.out.print(String.format("%-20s", "draw |"));
                    continue;
                }
                if (i > arr.length/2){
                    if (j < i && j >= i - arr.length / 2)
                        System.out.print(String.format("%-20s", "you win |"));
                    else
                        System.out.print(String.format("%-20s", "you lose |"));
                }
                else if (i <= arr.length / 2){
                    if (j > i && j <= i + arr.length / 2)
                        System.out.print(String.format("%-20s", "you lose |"));
                    else
                        System.out.print(String.format("%-20s", "you win |"));
                }
            }
            System.out.println();
        }
    }
}
