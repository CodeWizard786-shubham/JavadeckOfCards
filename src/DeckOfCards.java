
import java.util.*;

public class DeckOfCards {
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args) {
        List<String> deck = createDeck();
        Collections.shuffle(deck, new Random());
        String[][] playersCards = distributeCards(deck);
        printCards(playersCards);
    }

    private static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(rank + " of " + suit);
            }
        }
        return deck;
    }

    private static String[][] distributeCards(List<String> deck) {
        String[][] playersCards = new String[4][9];
        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                playersCards[i][j] = deck.get(cardIndex);
                cardIndex++;
            }
        }
        return playersCards;
    }

    private static void printCards(String[][] playersCards) {
        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("Player " + (i+1) + " cards:");
            for (int j = 0; j < playersCards[i].length; j++) {
                System.out.println(playersCards[i][j]);
            }
            System.out.println();
        }
    }
}