package Game;

/*
* Player class : individual player has his/her own properties : 
* name and set of cards and game status
*/

import java.util.Queue;

public class Player {

	String name;
	Queue<String> cards;
	Boolean gameOver;
	
	Player(String name,Queue<String> cards){
		this.name = name;
		this.cards = cards;
		this.gameOver = false;
	}
	
}
