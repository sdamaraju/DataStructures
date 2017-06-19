package Game;

/*BaseCards Class takes care of basic cards related stuff : 
*Like setting up the number of suites, the minimum/maximum vales for the cards,
*mapping for the character cards, number of suites and total cards in deck etc 	
*/
import java.util.HashMap;
import java.util.List;

public class BaseCards {
	private int minIntValue = 2;
	private int maxIntValue = 10;
	private int minCharacterIntValue = 11;
	private int maxCharacterIntValue = 14;
	private int totalCardsPerDeck = 52;
	private int totalSuites = 4;
	private HashMap<String,Integer> map;
	
	private void initStringToIntegerMap(){
		map = new HashMap<String,Integer>();
		map.put("J", 11);
		map.put("Q", 12);
		map.put("K", 13);
		map.put("A", 14);
	}
	
	int getMinOfAll(){
		int minInt = minIntValue ; int minChar = minCharacterIntValue;
		return minInt < minChar ? minInt : minChar;
	}
	
	int getMaxOfAll(){
		int maxInt = maxIntValue ; int maxChar = maxCharacterIntValue;
		return maxInt > maxChar ? maxInt : maxChar;
	}
	
	int getCardsPerSuite(){
		return totalCardsPerDeck/totalSuites;
	}
	
	int getTotalSuites(){
		return totalSuites;
	}
	
	int getTotalCardsPerDeck(){
		return totalCardsPerDeck;
	}
	BaseCards(){
		initStringToIntegerMap();
	}
	
	public List generateListOfCards(List list,int numberOfDecks){ 
		for(int j=0;j<numberOfDecks;j++){
			for(int i=0 ;i< this.getCardsPerSuite();i++){
				for(int k=0;k<this.getTotalSuites();k++)
					list.add(k+2);
			}
		}	
		return list;
	}
}
