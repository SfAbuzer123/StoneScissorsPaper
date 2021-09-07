package com.company;

public class TableOfWinners {
    public void showTable(String[] arr, int compIndex) {
        WinnerDetector detector = new WinnerDetector();
        for (int i = 0; i < arr.length; i++) {
            System.out.print("If you pick " + arr[i] + " ");
            detector.winLose(arr, i, compIndex);
        }
    }
}
