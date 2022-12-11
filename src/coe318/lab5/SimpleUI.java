package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        CardPile hCards = game.getHouseCards();
        CardPile myCards = game.getYourCards();
        System.out.println ("The house has:" + hCards.toString());
        System.out.println("You have:" + myCards.toString());
    }

  @Override
    public boolean hitMe() {
        String in;
        if (game.score(game.getYourCards()) > 21){ 
            return false;}
        System.out.print("Do you want another card? ");
        in = user.next();
        if (in.toLowerCase().charAt(0) == 'y'){
            return true;}
        else{    
        return false;}
    }

  @Override
    public void gameOver() {
    int myScore =  game.score(game.getYourCards());
        int hScore = game.score(game.getHouseCards());
        System.out.println("Game over");
        display();
        System.out.println("");
        System.out.println("My score: " + + myScore + ", The house score: " + hScore);
        if (myScore > 21 || (myScore <= hScore && hScore <= 21)) {
            System.out.println("The House wins!");
            return;
        }
        if ((hScore > 21 && myScore <= 21) || (myScore <= 21 && hScore <= 21) && (myScore > hScore)) {
            System.out.println("You win!");
            return;
        }    
        
    }

}