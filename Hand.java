/*Programmer: Dylan Driscoll
Class: CS 145
Assignment: Lab 4 Deck of Cards
Date:1/20/23*/

/*This is my class for hands. It creates an
array list for the hand of the player and
the dealer.*/

import java.util.ArrayList;

public class Hand {

   public ArrayList<Card> hand;
   
   /*Constructor method for hand class*/
   public Hand() {
     this.hand = new ArrayList<Card>();
   }/*end of constructor method.*/

   /*This method adds a card to a hand. It will then
   check if the user has an ace with a value of 11
   in their hand and set the value of that ace to 1
   if they are over 21.*/
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
   
   /*This will return an int based on the value
   total of cards in a hand.*/
   public int GetHandValue() {
     int value = 0;

     for (Card card : hand) {
       value += card.getValue();
     }

     return value;
   }
   
   /*This will show the cards in a hand and print blackjack
   if the hand contains a value of 21.*/
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
   
   /*This will show the first card in a hand. it is used to 
   display the first card of the dealers hand.*/
   public void ShowFirstCard() {
    System.out.println(
    "Card 1:" + hand.get(0).getFace()
    + " of " + hand.get(0).getSuit());
    System.out.println(
    "Value: " + hand.get(0).getValue());
    
   }
   /*This method checks if the user contains an ace
   with a value of 11 in their hand. If it does contain
   one, the method will set the value of that ace to 1 
   instead of 11.*/
   private Card containsHighAce() {
     for (Card card : hand) {
       if (card.getValue() == 11) {
         return card;
       }
      }

      return null;
   }
}
