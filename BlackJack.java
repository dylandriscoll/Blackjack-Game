
/*This program will allow the user to play blackjack vs a 
dealer.*/

import java.util.*;

public class BlackJack {
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    introMenu();

    String userCommand = "y";
    
    while (userCommand.startsWith("y")) {
      System.out.println(
      "Would you like to play?");

      System.out.println(
      "Please type Y or N.");
      userCommand = input.next();
      userCommand.toLowerCase();
      while (
      !userCommand.startsWith("y") 
      && !userCommand.startsWith("n")) {
        System.out.println(
        "Please enter Y to play or N to quit");
        userCommand = input.next();
        userCommand.toLowerCase();
      }
      if (userCommand.startsWith("y")) {
        play(input);
      }
    }

    System.out.println(
    "Come back anytime!");
    input.close();
  }
  
  public static void introMenu() {
    System.out.println(
    "Hello! This program will allow you to play Blackjack");
    System.out.println(
      "House Rules: The dealer is required to " +
      "hit on 16 or below and stand on 17 or above."
    );
  }
  
  public static void play(Scanner input) {
    Queue<Card> deck = DeckOfCards.InitializeDeck();

    Hand userHand = new Hand();
    Hand dealerHand = new Hand();

    userHand.AddCard(deck.remove());
    userHand.AddCard(deck.remove());

    dealerHand.AddCard(deck.remove());
    dealerHand.AddCard(deck.remove());

    System.out.println(
    "Your cards are:");
    userHand.ShowCards();

    System.out.println();

    System.out.println(
    "Dealer is showing ");
    dealerHand.ShowFirstCard();

    hitOrStay(deck, userHand, input);

    dealerChoice(deck, dealerHand);
    
    System.out.println(
    "Your cards: ");
    userHand.ShowCards();
    
    declareWinner(userHand, dealerHand);
  }
  
  public static void hitOrStay(Queue<Card> deck, Hand userHand, Scanner input) {
    String hOrS = "";
    boolean intCheck = intCheck(hOrS);
    
    if (userHand.GetHandValue() == 21) {
      return;
    }

    while (!intCheck && userHand.GetHandValue() < 21
           && !hOrS.startsWith("2")) {
      System.out.println(
      "Your hand value: " + userHand.GetHandValue());
      System.out.println(
      "Would you like to hit(1) or stay(2)?");
      hOrS = input.next();
      while (!hOrS.startsWith("1") && !hOrS.startsWith("2")
             && !intCheck) {
        System.out.println(
        "Please type 1 for hit or 2 for stay.");
        hOrS = input.next();
        intCheck(hOrS);
      }
      if (hOrS.startsWith("1")) {
        userHand.AddCard(hit(deck));
      }
    }
  }
  
  public static boolean intCheck(String hOrS) {
        Scanner intChecker = new Scanner(hOrS);
        if (intChecker.hasNextInt()) {
            return true;
        } else {
            return false;
        }
  }
  
  public static void declareWinner(Hand userHand, Hand dealerHand) {
    System.out.println();
    if (
    userHand.GetHandValue() > 21) {
      System.out.println("You busted! ");
      System.out.println("Dealer wins! ");
      return;
    }
    if (
    dealerHand.GetHandValue() > 21) {
      System.out.println("Dealer busted! ");
      System.out.println("You win! ");
      return;
    }
    if (
    userHand.GetHandValue() == dealerHand.GetHandValue()) {
      System.out.println("It's a push! ");
      return;
    }
    if (
      dealerHand.GetHandValue() >= userHand.GetHandValue() &&
      dealerHand.GetHandValue() <= 21
    ) {
      System.out.println("Dealer wins! ");
      return;
    } else {
      System.out.println("You win! ");
      return;
    }
  }
   
  public static Card hit(Queue<Card> deck) {
    Card card = deck.remove();
    System.out.println(
    "Next card dealt is: ");
    System.out.println(
    card.getFace() + " of " + card.getSuit());
    return card;
  }
   
  public static void dealerChoice(Queue<Card> deck, Hand dealerHand) {
    System.out.println();
    System.out.println(
    "Dealer shows their cards");
    dealerHand.ShowCards();
    System.out.println();
    while (dealerHand.GetHandValue() <= 16) {
      System.out.println(
      "Dealer chooses to hit.");
      Card newCard = hit(deck);
      dealerHand.AddCard(newCard);
      System.out.println();
    }
    System.out.println(
    "Dealers cards: ");
    dealerHand.ShowCards();
  }

  public static String playAgain(Scanner input, String userCommand) {
    System.out.println();
    System.out.println(
    "Do you want to play again?");
    userCommand = input.next();
    userCommand.toLowerCase();
    return userCommand;
  }
}
