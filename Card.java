
/*This is my card class. It uses enum and switch/case
to create the define the card objects and determine
their value for the blackjack game.*/

public class Card {

  private Suit Suit;
  private Face Face;
  private int Value;

  public Card(Suit suit, Face face) {
    this.Suit = suit;
    this.Face = face;
    this.Value = getInitialValue(face);
  }

  public Suit getSuit() {
    return Suit;
  }

  public Face getFace() {
    return Face;
  }

  public int getValue() {
    return Value;
  }

  public void setValue(int val) {
    this.Value = val;
  }
  
  public static String toString(Card card) {
    String cardString =
      card.getFace().toString() + " of " + card.getSuit().toString();
    return cardString;
  }
  
  public static int getInitialValue(Face face) {
    switch (face) {
      case KING:
      case QUEEN:
      case JACK:
      case TEN:
        return 10;
      case NINE:
        return 9;
      case EIGHT:
        return 8;
      case SEVEN:
        return 7;
      case SIX:
        return 6;
      case FIVE:
        return 5;
      case FOUR:
        return 4;
      case THREE:
        return 3;
      case TWO:
        return 2;
      case ACE:
        return 11;
    }
    return 0;
  }

  enum Suit {
    DIAMONDS,
    HEARTS,
    SPADES,
    CLUBS,
  }

  enum Face {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE,
  }
}
