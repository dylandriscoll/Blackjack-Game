import java.util.ArrayList;

public class Hand {

   public ArrayList<Card> hand;
   
   public Hand() {
     this.hand = new ArrayList<Card>();
   }

   public void AddCard(Card card) {
     this.hand.add(card);

     if (GetHandValue() > 21) {
       Card highAce = containsHighAce();
       if (highAce != null) {
         this.hand.remove(highAce);
         highAce.setValue(1);
         this.hand.add(highAce);
       }
     }
   }

   public int GetHandValue() {
     int value = 0;

     for (Card card : hand) {
       value += card.getValue();
     }

     return value;
   }
   
   public void ShowCards() {
     for (int i = 0; i < this.hand.size(); i++) {
       System.out.println(
       "Card " + (i+1) + ": " + 
       hand.get(i).getFace() + " of " + hand.get(i).getSuit());
     }

     System.out.println("Value: " + GetHandValue());
     if (GetHandValue() == 21) {
      System.out.println("Blackjack!");
     }
   }

   public void ShowFirstCard() {
    System.out.println(
    "Card 1:" + hand.get(0).getFace()
    + " of " + hand.get(0).getSuit());
    System.out.println(
    "Value: " + hand.get(0).getValue());
    
   }

   private Card containsHighAce() {
     for (Card card : hand) {
       if (card.getValue() == 11) {
         return card;
       }
      }

      return null;
   }
}
