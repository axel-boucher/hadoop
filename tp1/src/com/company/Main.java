// Axel Boucher
// 29/09/2017

package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void echo(String[] args){
        System.out.print(args[0]);
        for( int i = 1; i < args.length; i++){
            System.out.print(" " + args[i]);
        }
        System.out.println("");
    }

    public static void recho(String[] args){
        System.out.print(args[args.length-1]);
        for( int i = args.length-2; i >= 0; i--){
            System.out.print(" " + args[i]);
        }
        System.out.println("");
    }

    public static void guesser(){
        Random rand = new Random();
        int secret_number = rand.nextInt(1000) + 1; //1->1000
        Scanner sc = new Scanner(System.in);
        int player_guess = 0;
        boolean won = false;

        while(won == false){

            System.out.println("Pick a number between 1 and 1000: ");
            try {
                player_guess = sc.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("This is not an Integer");
                sc.next();
            }

            if (player_guess == secret_number){
                won = true;
            }
            else if (player_guess < secret_number){
                System.out.println("The secret number is bigger than " + player_guess);
            }
            else if (player_guess > secret_number){
                System.out.println("The secret number is smaller than " + player_guess);
            }
        }

        System.out.println("You win");
        System.out.println("The secret number was " + player_guess);
    }


    public static void main(String[] args) {
        echo(args);
        recho(args);
        guesser();
    }

    /*
    1/ program recho (reverse echo)
    2/ read keyboard value (from std in) blinder integer
        dichotomic research of number
        a/your prog choose a number randomly
        b/prog ask for a number
        c/you type a number
        d/prog tells if secret number is bigger or smaller, if good value: print success message then quit
    */
}
