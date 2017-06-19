package Game;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainGameOfWar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BaseCards cards = new BaseCards();
		System.out.println("Enter number of Decks being used : ");
		int numberOfDecks = scan.nextInt();
		System.out.println("Enter number of Players : ");
		int numberOfPlayers = scan.nextInt();
		Player p[] = new Player[numberOfPlayers];
		//creating objects for players
		for (int i=0;i<numberOfPlayers;i++){
			 p[i] = new Player("Player" + (i+1) , new LinkedList<String>());
		}
		System.out.println("Number of cards per player : "+(cards.getTotalCardsPerDeck() * numberOfDecks)/numberOfPlayers);
		//Shuffle and Distribute Cards to Players
		CardsDistributor distributor = new CardsDistributor();
		List cardsOntableAfterEqualDistribution = distributor.randomDistribution(p, numberOfDecks, cards);
		System.out.println("Number of cards on table already : "+cardsOntableAfterEqualDistribution.size());
		WarGame actualGame = new WarGame();
		Player winner = actualGame.playGame(p,cardsOntableAfterEqualDistribution,cards,numberOfDecks);
		System.out.println(winner.name +" has won the game !!");
	}
	
	

}
