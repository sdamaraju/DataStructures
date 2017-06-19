package Game;

import java.util.HashMap;
import java.util.List;

public interface Cards {
	int minIntValue = Integer.MAX_VALUE;
	int maxIntValue = Integer.MIN_VALUE;
	int minCharacterIntValue = Integer.MAX_VALUE;
	int maxCharacterIntValue = Integer.MIN_VALUE;
	int totalCardsPerDeck = 0;
	int totalSuites = 0;
	HashMap<String,Integer> map = new HashMap();;
	
	int getMinOfAll();
	
	int getMaxOfAll();
	
	int getCardsPerSuite();
	
	int getTotalSuites();
	
	int getTotalCardsPerDeck();

	public List generateListOfCards(List list,int numberOfDecks);
}
