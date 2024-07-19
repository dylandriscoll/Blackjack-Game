import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeckOfCards {
  
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
