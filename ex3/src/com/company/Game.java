package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                if (i != j){
                    if (args[i].equals(args[j])){
                        game.changeInputData();
                        return;
                    }
                }
            }
        }
        if (args.length % 2 == 0)
        {
            game.changeInputData();
            return;
        }
        game.startGame(args);
    }

    public void startGame(String[] args){
        KeyAndHMACGenerator generator = new KeyAndHMACGenerator();
        int random = generator.randomMove(args.length);
        byte[] randomKey = generator.generateKey();
        byte[] hmacSha256 = new byte[32];
        try {
            hmacSha256 = generator.calculateHmacSha256(randomKey, args[random].getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.printf("HMAC: %032x%n", new BigInteger(1, hmacSha256));
        availableMoves(args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int clientIndex = 0;
        String line = null;
        try {
            line = reader.readLine();
            if (line.equals("?")){
                new TableOfWinners().showTable(args, random);
                line = reader.readLine();
            }
            else if (Integer.parseInt(line) == 0)
                System.exit(0);
            reader.close();
        } catch (IOException | NumberFormatException e) {
            changeInputData();
        }
        try {
            clientIndex = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            changeInputData();
            return;
        }
        if (clientIndex > args.length){
            changeInputData();
            return;
        }
        System.out.println("Your move - " + args[clientIndex-1]);
        System.out.println("Computer move - " + args[random]);
        WinnerDetector winnerDetector = new WinnerDetector();
        winnerDetector.winLose(args, clientIndex-1, random);
        System.out.printf("HMAC key: %032x%n", new BigInteger(1, randomKey));
    }

    public void availableMoves(String[] args){
        System.out.println("Available moves:");
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + 1 + " - " + args[i]);
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
        System.out.println("Enter your move: ");
    }

    public void changeInputData(){
        System.out.println("Change the input data!");
        System.out.println("Example: 1, 2, 3");
    }
}
