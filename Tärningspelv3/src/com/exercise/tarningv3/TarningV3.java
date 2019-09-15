package com.exercise.tarningv3;

import java.util.Scanner;

public class TarningV3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int antalKast, antalSpelare;
        int antalSidor = 6;
        int table[][] = new int[100][100];
        int datorSlag[] = new int[100];
        int spelarPoang[] = new int[100];
        int highScore[] = new int[100];
        String spelaIgen, datorVal;

        System.out.println(
                " _______ _   _  _____  _   _ _____ _   _  _____  _____ _____  ______ _      _ \n" +
                "|__   __(_)_(_)|  __ \\| \\ | |_   _| \\ | |/ ____|/ ____|  __ \\|  ____| |    | |\n" +
                "   | |    / \\  | |__) |  \\| | | | |  \\| | |  __| (___ | |__) | |__  | |    | |\n" +
                "   | |   / _ \\ |  _  /| . ` | | | | . ` | | |_ |\\___ \\|  ___/|  __| | |    | |\n" +
                "   | |  / ___ \\| | \\ \\| |\\  |_| |_| |\\  | |__| |____) | |    | |____| |____|_|\n" +
                "   |_| /_/   \\_\\_|  \\_\\_| \\_|_____|_| \\_|\\_____|_____/|_|    |______|______(_)\n" +
                "             Högst poäng efter att tärningar slagits vinner!\n");

        do {
            System.out.println("Hur många spelare är ni?");
            antalSpelare = queryNum(scan);

            System.out.println("Vill ni lägga till en dator? (y/n)");
            datorVal = scan.nextLine();

            System.out.println("Välj antal kast.");
            antalKast = queryNum(scan);

            if (datorVal.equalsIgnoreCase("y")){
                for (int i = 1; i <= antalKast; i++){
                    datorSlag[i] = kast(antalSidor);
                    System.out.println("Dator kast " + i + " Poäng " + datorSlag[i]);
                }
            }

            System.out.println(" ");

            for (int i = 1; i <= antalSpelare; i++) {
                for (int j = 1; j <= antalKast; j++) {
                    table[i][j] = kast(antalSidor);
                    System.out.println("Spelare " + i + " Kast " + j + " Poäng " + table[i][j]);
                }
                System.out.println(" ");
            }
            //Loop som sparar ner array värdena från 2d till en ny array som kan
            //hålla koll på spelarnas totala poäng.
            //Tänker en loop som går igenom hela table[1][1 till antalSpelare]
            //Så att varje spelare får en egen del i 1d arrayen.
            //loopar, arrayer eller kanske en egen metod?
            int datorPoang = 0;

            for (int i = 1; i <= antalKast; i++){
                datorPoang += datorSlag[i];
            }

            System.out.println("Datorns totalpoäng: " + datorPoang);

            for (int n = 1; n <= antalSpelare; n++){
                for (int i = 1; i <= antalKast; i++){
                    spelarPoang[n] += table[n][i];
                }
                System.out.println("Totalpoäng spelare " + n + ": " + spelarPoang[n]);
            }

            int max = spelarPoang[0];
            for (int i = 1; i < spelarPoang.length; i++){
                if (spelarPoang[i] > max){
                    max = spelarPoang[i];
                }
            }

            if (datorPoang > max){
                System.out.println("\nVinnaren är datorn med: " + datorPoang);
            } else {
                for (int i = 0; i <= antalSpelare; i++) {
                    if (spelarPoang[i] == max) {
                        System.out.println("\nVinnaren är spelare " + i + " med: " + max + " poäng!");
                    }
                }
            }

            //Array som sparar in highscores.

            System.out.println("\nvill du spela igen?");
            spelaIgen = scan.nextLine();

            if (spelaIgen.equalsIgnoreCase("nej")) {
                System.out.println(" ");
                System.out.println("   _____          __  __ ______    ______      ________ _____  _ ");
                System.out.println("  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\| |");
                System.out.println(" | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) | |");
                System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  /| |");
                System.out.println(" | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\|_|");
                System.out.println("  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_(_)");
                System.out.println("\n                    Tack för att du spelade!");
                break;
            }

        } while(!spelaIgen.equalsIgnoreCase("nej"));
    }

    public static int kast(int inAntalsidor){
        int utKast = (int)(1 + inAntalsidor * Math.random());
        return utKast;
    }

    // Fråga användaren efter ett heltal tills ett rimligt heltal har angivits.
    public static int queryNum(Scanner scanner) {
        /* Initalisera returnValue till null så vi kan försöka få ett
           värde till den while (returnValue == null) */
        Integer returnValue = null;

        while (returnValue == null) {
            // Det här är vår prompt.
            System.out.print("> ");

            /* try {} försöker utföra någonting, om ett fel av typen Exception uppstår så
               fångar catch (Exception e) det och försöker fixa situationen. Exception är en
               klass som alla andra Exceptions ärver från och därmed kommer den fånga allt. */
            try {
                returnValue = Integer.valueOf(scanner.nextLine());

                // Om vi kommit hit så vet vi att vi fått ett tal, men inte vad för tal.
                if (returnValue <= 0) {
                    returnValue = null; // Resetta värdet så att loopen kommer köras igen.
                    System.out.println("Talet måste vara högre än noll. Försök igen.");
                }

            } catch (Exception e) {
                System.out.println("Det där är inte ett heltal! Försök igen.");
            }
        }

        return returnValue; // returnValue är en Integer, men konverteras automatiskt till int när det returneras.
    }
}
