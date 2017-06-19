package Game;

/*
* CardsDistributor class takes care of the distribution of cards after the shuffling of cards is done using the shuffle cards method.
* The List of shuffled cards is then iterated card by card and then add each to the player's cards
* Once all cards are equally distributed and there is a remainder, then add those remainder number of cards to cards on table, the winner of first round will win those cards too.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsDistributor {
	ArrayList list;
	CardsDistributor(){
		list = new ArrayList();
	}
	
	 List randomDistribution(Player p[],int numberOfDecks,BaseCards cards){
		ArrayList shuffledCards = shuffleCards(cards,numberOfDecks);
		ArrayList listOfCardsOnTableAfterEqualDistribution = new ArrayList();
		int totalCards = (numberOfDecks* cards.getTotalCardsPerDeck());
		int cardsTodistributeEqually =  totalCards/p.length;
		int k=0;
		for(int i=0;i<cardsTodistributeEqually*p.length;i++){
			if(k==p.length) k=0;
			p[k].cards.add(list.get(i).toString()); //distribute the cards in the list to all the players in the array
			k++; // 
		}
		for(int j=cardsTodistributeEqually*p.length;j<totalCards;j++){
			listOfCardsOnTableAfterEqualDistribution.add(list.get(j)); // in case of uneven distribution, add the excess cards to list of cards on table
		}
		return listOfCardsOnTableAfterEqualDistribution;
		
	}
	
	private ArrayList shuffleCards(BaseCards cards, int numberOfDecks){ // get all cards per suite and then iterate it for the number of suites and then add them to list of cards. 
		list = (ArrayList) cards.generateListOfCards(list,numberOfDecks);
		Collections.shuffle(list); // shuffle the list of cards
		return list;
	} 
}
