package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarGame {

	public Player playGame(Player p[],List cardsOnTable,Cards cards,int numberOfDecks){
		int playersOut = 0;
		int round = 0;
		Scanner scan = new Scanner(System.in); // use for every round check (scan.nextInt does that for us)
		while(playersOut < p.length -1){
			round ++; // increment the round
			ArrayList<Integer> templist = new ArrayList<Integer>();  // list to compare the cards put by each player on the table
			for(int i=0;i<p.length;i++){
				if(p[i].gameOver != true){
					int temp = (Integer.parseInt(p[i].cards.remove())); // pop out the cards from the player's set.
					System.out.println("Player " + (i+1) + " puts " +temp+ " on the table");
					templist.add(temp);
					cardsOnTable.add(temp); // cardsOnTable is the list that has all the cards put by all players
				}else{
					templist.add(Integer.MIN_VALUE);// when player is already out of the game , then for that player just add Integer min value
					cardsOnTable.add(Integer.MIN_VALUE);
				}
			}
			// Business display the cards on table
			System.out.println("All cards on table for round : "+round);
			for(int i=0;i<cardsOnTable.size();i++){
				System.out.println(cardsOnTable.get(i));
			}
			
			// Technical display the cards in tempList
			/*System.out.println("All cards on temp list for round : "+round);
			for(int i=0;i<templist.size();i++){
				System.out.println(templist.get(i));
			}*/
				
			cardsOnTable = whoWonTheRound(p, templist, cardsOnTable);
							
			if(round%25==0){  // After every 25 rounds, check for player with minimum number of cards and eliminate that player
				playersOut = eliminatePlayerAfterXRounds(p,round,playersOut);
			}
			
			// At the end of each round : we need the count of cards with each player
			System.out.println("At the end of round " + round);
			for(int i=0;i<p.length;i++){
				if(p[i].cards.size()==0 && p[i].gameOver == false){
					System.out.println("Player "+(i+1)+" game over");
					p[i].gameOver = true;
					playersOut++;
				}else{
					System.out.println("Player "+(i+1)+" left with cards : "+p[i].cards.size());
				}
			}
			
			//System.out.println("number of Players in for the round " + (p.length - playersOut));
			scan.nextInt();// run the game round after round....to evaluate the logic and the game proceedings.
			}
		for (int i=0;i<p.length;i++){
			if(p[i].gameOver != true){
				return p[i];
			}	
			
		}

		return null;
	}
	
	private List whoWonTheRound(Player p[],List<Integer> templist,List<Integer> cardsOnTable){
		boolean bust = false;  //bust is when 2 or more players have same max card, and hence no one wins, that case, cards on table will remain on the table until the next round till a player wins
		int maxCardPlayer = 0;
		int max = templist.get(0);
		int sameMaxCardsCount=1;
		for(int i=0;i<p.length;i++){ // logic to identify the max card
				if(templist.get(i) > max){
					max = templist.get(i);
					sameMaxCardsCount=1; //if new max, then players with max cards is back to 1
					maxCardPlayer = i;
				}else if(templist.get(i)==max && templist.get(i)!= Integer.MIN_VALUE && i!=0){
					sameMaxCardsCount++; // if another player has same max card, then chance of a bust, increment the samemaxCardsCount
				}
				
		}
		if(sameMaxCardsCount > 1){ //chance of a bust, because there are more than 1 players with same max card
			templist= new ArrayList();
			bust = true;
			System.out.println("More than 1 player has faced up the Max Card");					
		}
		if(bust==false){ // then 1 player has the max card and he won the round.
			for(int i=0;i<cardsOnTable.size();i++){	
				if((Integer)cardsOnTable.get(i)!=Integer.MIN_VALUE)
				p[maxCardPlayer].cards.add(cardsOnTable.get(i).toString()); // add the cards on table to the players cards.
			}
			System.out.println("Player " +(maxCardPlayer+1)+" won the round");
			cardsOnTable = new ArrayList();// refresh the cards On table list as the list of cards already got added to the player's set of cards
		}
		return cardsOnTable;
	}
	
	private int eliminatePlayerAfterXRounds(Player p[],int round,int playersOut){
		ArrayList<Integer> remainingCardsForEachPlayer = new ArrayList();
		for(int i=0;i<p.length;i++){
			if(p[i].gameOver == false){
				remainingCardsForEachPlayer.add(p[i].cards.size()); // checking the remaining cards for each player and adding them to list
			}else{
				remainingCardsForEachPlayer.add(Integer.MAX_VALUE);//if the player is already out of the game, just add Int.MAX 
			}
		}
		int minCardsPlayer = 0;
		int sameMinCards =1 ;
		ArrayList<Integer> sameMinCardsPlayersIndices = new ArrayList(); // If two or more players have same number of cards add all their indices to the list
		int minValue = remainingCardsForEachPlayer.get(0);
		for(int i=0;i<remainingCardsForEachPlayer.size();i++){
			if(remainingCardsForEachPlayer.get(i) < minValue){
				sameMinCards = 1;
				sameMinCardsPlayersIndices = new ArrayList(); // refresh the list as there is a new minimum value
				sameMinCardsPlayersIndices.add(i);
				minCardsPlayer = i;
			}else if(remainingCardsForEachPlayer.get(i) == minValue){
				sameMinCards++;
				sameMinCardsPlayersIndices.add(i); //if the same minimum cards are there for the other players add them to this list
			}
		}
		if(sameMinCards > 1 && (p.length- playersOut) > 2){ // if more than 2 players are playing and there are few with least number of cards, eliminate them
			for(int i=0;i<sameMinCardsPlayersIndices.size();i++){
				p[sameMinCardsPlayersIndices.get(i)].gameOver = true;
				System.out.println("Player "+ (sameMinCardsPlayersIndices.get(i)+1)+" eliminated as he has the least number of cards in round " + round);
				playersOut++;
			}
		}else if (sameMinCards == 1){ // if just 1 has the least number of cards, eliminate him
			p[minCardsPlayer].gameOver = true;
			System.out.println("Player "+ (minCardsPlayer+1)+" eliminated as he has the least number of cards in round " + round);
			playersOut++;
		}
		return playersOut;
	}
}
