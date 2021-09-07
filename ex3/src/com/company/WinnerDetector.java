package com.company;

public class WinnerDetector {

    public void winLose(String[] arr, int clientIndex, int compIndex) {
        if (clientIndex == compIndex){
            System.out.println("Nobody wins");
            return;
        }
        if (clientIndex > arr.length/2){
            if (compIndex < clientIndex && compIndex >= clientIndex - arr.length / 2)
                System.out.println("You win");
            else
                System.out.println("You lose");
        }
        else if (clientIndex <= arr.length / 2){
            if (compIndex > clientIndex && compIndex <= clientIndex + arr.length / 2)
                System.out.println("You lose");
            else
                System.out.println("You win");
        }
    }

}
