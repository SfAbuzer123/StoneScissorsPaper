package com.company;

public class WinnerDetector {

    public String winLose(String[] arr, int clientIndex, int compIndex) {
        if (clientIndex == compIndex){
            return "DRAW";
        }
        if (clientIndex > arr.length/2){
            if (compIndex < clientIndex && compIndex >= clientIndex - arr.length / 2)
               return "WIN";
            else
                return "LOSE";
        }
        else if (clientIndex <= arr.length / 2){
            if (compIndex > clientIndex && compIndex <= clientIndex + arr.length / 2)
                return "LOSE";
            else
                return "WIN";
        }
        return null;
    }

}
