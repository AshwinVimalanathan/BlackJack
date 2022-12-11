package coe318.lab5;
/**
 *
 * @ Ashwin Vimalanathan
 */
import coe318.lab5.Card;
import java.util.ArrayList;
import java.util.Random;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;
    private Random rand;
    public CardPile() {
        cards = new ArrayList<Card>();
        rand = new Random();
//        cards = new ArrayList(52);
//        for(int i=0; i<4; i++){
//            for(int j=2; j<=14; j++){
//                Card a = new Card(j,i,true);
//                this.cards.add(a);
        }
    
    
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
        cards.add(card);
    }
    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        Random rand = new Random();
        int n = rand.nextInt(cards.size());
        Card a = this.cards.get(n);
        this.cards.remove(n);
        return a; //FIX THIS
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<cards.size();i++){
            sb.append(cards.get(i).toString() + "\n");
        }
        return (sb.toString());
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }


}