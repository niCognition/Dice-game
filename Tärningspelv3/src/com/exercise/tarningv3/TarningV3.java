package com.exercise.tarningv3;

import java.util.Scanner;

public class TarningV3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int antalKast;
        int antalSidor = 6;
        int antalSpelare;
        int table[][] = new int[100][100];
        int spelarPoang[] = new int[100];
        String spelaIgen;

        System.out.println(" _______ _   _  _____  _   _ _____ _   _  _____  _____ _____  ______ _      _ ");
        System.out.println("|__   __(_)_(_)|  __ \\| \\ | |_   _| \\ | |/ ____|/ ____|  __ \\|  ____| |    | |");
        System.out.println("   | |    / \\  | |__) |  \\| | | | |  \\| | |  __| (___ | |__) | |__  | |    | |");
        System.out.println("   | |   / _ \\ |  _  /| . ` | | | | . ` | | |_ |\\___ \\|  ___/|  __| | |    | |");
        System.out.println("   | |  / ___ \\| | \\ \\| |\\  |_| |_| |\\  | |__| |____) | |    | |____| |____|_|");
        System.out.println("   |_| /_/   \\_\\_|  \\_\\_| \\_|_____|_| \\_|\\_____|_____/|_|    |______|______(_)");
        System.out.println("             Högst poäng efter att tärningar slagits vinner!");
        System.out.println("");

        do {
            System.out.println("Hur många spelare är ni?");
            antalSpelare = scan.nextInt();
            scan.nextLine();

            System.out.println("Välj antal kast.");
            antalKast = scan.nextInt();
            scan.nextLine();

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
            for(int i = 0; i <= antalSpelare; i++) {
                if (spelarPoang[i] == max) {
                    System.out.println("\nVinnaren är spelare " + i + " med: " + max + " poäng!");
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

        }while(!spelaIgen.equalsIgnoreCase("nej"));
    }

    public static int kast(int inAntalsidor){
        int utKast = (int)(1 + inAntalsidor * Math.random());
        return utKast;
    }
}
