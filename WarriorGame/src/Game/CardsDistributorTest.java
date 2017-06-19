package Game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CardsDistributorTest {

	// testing methods randomDistribution.
	
	public static void main(String args[]){
		testRandomDistribution();
	}
	
	private static void testRandomDistribution(){
		CardsDistributor randomDistributor = new CardsDistributor();
		Random random = new Random();
		BaseCards cards = new BaseCards();
		int numberOfPlayers = random.nextInt(4-0) + 2;
		Player[] p = new Player[numberOfPlayers];
		for(int i=0;i<p.length;i++){
			p[i] = new Player("Player" + (i+1),new LinkedList());
		}
		int numberOfDecks = random.nextInt(4-0) + 2;
		List listOfCardsOnTable = randomDistributor.randomDistribution(p, numberOfDecks,cards);
		if ((listOfCardsOnTable.size()) == (numberOfDecks*cards.getTotalCardsPerDeck()) - ((numberOfDecks*cards.getTotalCardsPerDeck())/p.length)*p.length ){ //cards on table = total cards - equal each distribution cards * number of players
			System.out.println("Test Passed");
		}else {
			throw new UnitTestFailedException("CardsDistributor.randomDistribution Failed"); 
		}
	}
	
}
