package Game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WarGameTest {

	public static void main(String args[]){
		testPlayGame();
	}
	
	private static void testPlayGame(){
		WarGame game = new WarGame();
		Player p[] = new Player[2];//test content 2 players
		for(int i=0;i<2;i++){
			p[i]= new Player("Test"+(i+1),new LinkedList());
		}
		// 1 deck, 
		CardsDistributor distributor = new CardsDistributor();
		BaseCards cards = new BaseCards();
		List cardsOntableAfterEqualDistribution = distributor.randomDistribution(p, 1, cards);
		Player winner = game.playGame(p, new ArrayList(), cards, 1);
		if (winner != null){
			System.out.println("Test Passed");
		}else {
			throw new UnitTestFailedException("Winner Expected"); 
		}
	}
	
	
}
