
/*This is my deck of cards class. It creates a deck
as a linked list, adds all the cards using for loops,
shuffles the deck, uses collections to shuffle the 
cards, then adds the cards to a queue.*/
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeckOfCards {

  /*This class will create a linked list deck object, fill
  it with all 52 cards, shuffle it, put those cards into
  a Queue<Card> object and return the Queue<Card>.*/
  public static Queue<Card> InitializeDeck() {
    List<Card> deck = new LinkedList<>();

    for (Card.Suit s : Card.Suit.values()) {
      for (Card.Face f : Card.Face.values()) {
        Card card = new Card(s, f);
        deck.add(card);
      }
    }

    Collections.shuffle(deck);

    Queue<Card> shuffledDeck = new LinkedList<Card>();

    for (int i = 0; i <= 51; i++) {
      shuffledDeck.add(deck.get(i));
    }

    return shuffledDeck;
  }
}
