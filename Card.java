
/*This is my card class. It uses enum and switch/case
to create the define the card objects and determine
their value for the blackjack game.*/

public class Card {

  private Suit Suit;
  private Face Face;
  private int Value;

  /*Constructor method for my card class*/
  public Card(Suit suit, Face face) {
    this.Suit = suit;
    this.Face = face;
    this.Value = getInitialValue(face);
  }/*End of constructor method.*/

  /*Getter method for a card suit*/
  public Suit getSuit() {
    return Suit;
  }

  /*Getter method for a card face*/
  public Face getFace() {
    return Face;
  }

  /*Getter method for a card value*/
  public int getValue() {
    return Value;
  }

  /*Setter method for a card value*/
  public void setValue(int val) {
    this.Value = val;
  }
  
  /*Getter method for a string representation of a card*/
  public static String toString(Card card) {
    String cardString =
      card.getFace().toString() + " of " + card.getSuit().toString();
    return cardString;
  }
  
  /*Getter method for the initial value of the card. Returns
  different values depending on the face.*/
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
