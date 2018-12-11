package IeadsProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SnakeAndLadder {
	void snakeGame() throws IOException {
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	       System.out.println("Let's Play Snake & Ladder Game");
	       System.out.println("===================================================================================");
	       System.out.println("There are snakes on squares 17, 54, 62, 64, 87, 93, 95 and 98");
	       System.out.println("There are ladders on squares 4, 9, 20, 28, 40, 51, 63 and 71");
	       System.out.println("Please! Press any key to start the game...");
	       br.readLine();
	       Random r=new Random();
        int player1Index = 1, player2Index = 1;
        int playerIndex;
        int playerNum = 1; // 1 for player1; 2 for player2
        while ((player1Index != 100) || (player2Index != 100)) {
            System.out.println("Player " + playerNum+ ", press any key to shuffle the die...");
            br.readLine();
            int dThrow = r.nextInt(6);
            if (dThrow == 0) {
                dThrow++;
            }
            System.out.println("The number on the die is " + dThrow);
            if (playerNum == 1) {
                playerIndex = player1Index;
            } else {
                playerIndex = player2Index;
            }
            if ((playerIndex + dThrow) > 100) {
                System.out.println("You will have to wait for the next turn, you have exceeded 100.");
            } else if ((playerIndex + dThrow) == 100) {
                System.out.println("Congratulations player "+ playerNum+ ", you have won the game! Better luck next time, Player "
                                + (playerNum == 1 ? 2 : 1) + ".");
                break;
            } else {
                playerIndex += dThrow;
                System.out.println("You have progressed by " + dThrow+ " square(s), and your new position is " + playerIndex+ ".");
                System.out.println("Press any key to see whether you encountered a snake or a ladder.");
                br.readLine();
                System.out.println();
                if (playerNum == 1) {
                    player1Index = stepMove(playerIndex);
                    playerNum = 2;
                } else {
                    player2Index = stepMove(playerIndex);
                    playerNum = 1;
                }
            }
        }
    }
    private int stepMove(int playerIndex) {
    	 switch(playerIndex)
         {
             case 4  : System.out.println("Wow! You got the ladder on square 4! Your new position is 14.");
             playerIndex=14;
                       break;
             case 9 :  System.out.println("Wow! You got the ladder on square 9! Your new position is 31.");
             playerIndex=31;
                       break;
             case 17 : System.out.println("Whoops! You were caught by the snake at square 17. You're now down to square 7.");
             playerIndex=7;
                       break;
             case 20 : System.out.println("Wow! You got the ladder at square 20! Your new position is 38.");
             playerIndex=38;
                       break;
             case 28 : System.out.println("Wow! You got the ladder at square 28! Your new position is 84.");
             playerIndex=84;
                       break;
             case 40 : System.out.println("Wow! You got the ladder on square 40! Your new position is 59.");
             playerIndex=59;
                       break;
             case 51 : System.out.println("Wow! You got the ladder on square 51! Your new position is 67.");
             playerIndex=67;
             			 break;
             case 54 : System.out.println("Whoops! You were caught by the snake at square 54! You're now down to square 34.");
             playerIndex=34;
             			 break;  
             case 62 : System.out.println("Whoops! You were caught by the snake at square 62! You're now down to square 19.");
             playerIndex=19;
                       break;
             case 64 : System.out.println("Whoops! You were caught by the snake at square 64! You're now down to square 60.");    
             playerIndex=60;
                       break;                
             case 63 : System.out.println("Wow! You got the ladder on square 63! Your new position is 81!! Getting close, but watch for the snake on 99!");
             playerIndex=81;
                       break;
             case 71 : System.out.println("Wow! You got the ladder on square 71! Your new position is 91.");
             playerIndex=91;
                       break;
             case 87 : System.out.println("Whoops! You were caught by the snake at square 87! You're now down to square 24.");
             playerIndex=24;
                       break;
             case 93 : System.out.println("Whoops! You were caught by the snake at square 93! You're now down to square 73.");
             playerIndex=73;
                       break;
             case 95 : System.out.println("Whoops! You were caught by the snake at square 95! You're now down to square 75.");    
             playerIndex=75;
                       break;
             case 99 : System.out.println("Whoops! You were caught by the snake at square 99! You're now down to square 78.");   
             playerIndex=78;
                       break;
             default : System.out.println("No snakes or ladders here.");       
         }
        return playerIndex;
    }
}