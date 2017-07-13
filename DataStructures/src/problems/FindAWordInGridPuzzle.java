package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAWordInGridPuzzle {

	char[][] puzzleGrid = new char[3][3];
	int[][] visit = new int[3][3];
	
	public FindAWordInGridPuzzle(){
	puzzleGrid[0][0] = 'a';
	puzzleGrid[0][1] = 'b';
	puzzleGrid[0][2] = 'c';
	puzzleGrid[1][0] = 'd';
	puzzleGrid[1][1] = 'e';
	puzzleGrid[1][2] = 'f';
	puzzleGrid[2][0] = 'g';
	puzzleGrid[2][1] = 'h';
	puzzleGrid[2][2] = 'i';
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			visit[i][j]=0;
		}
	}
	}
	
	public static void main(String[] args) {
		//System.out.println("a".substring(1).length());
		FindAWordInGridPuzzle test = new FindAWordInGridPuzzle();
		boolean value = test.isTheWordInThePuzzleGrid("hfec",test.puzzleGrid,test.visit);
	}
	
	private boolean isTheWordInThePuzzleGrid(String str,char puzzle[][],int visit[][]){
		int i=0;int j=0;
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		for(int k=0;k<3;k++){
			for(int l=0;l<3;l++){
				if(puzzle[k][l]==str.charAt(0)){
					list.add(auxWordPuzzle(k,l,str,puzzle,visit));
				}				
			}
		}
		boolean found = false;
		for(int h=0;h<list.size();h++){
			if(list.get(h)==true){
				found = true;
			}
		}
		System.out.println(found);
		return found;
	}
	
	private static boolean auxWordPuzzle(int i, int j,String str,char [][] puzzle,int[][] visit){
		if(i>2 || j>2 || i<0 || j<0){
			return false;
		}
		if(str.length() == 0){
			return true;
		}
		System.out.println("String : " + str );
		/*for(int k=0;k<3;k++){
			System.out.println();
			for(int l=0;l<3;l++){
				System.out.print(visit[k][l]);				
			}
		}*/
		
		if(str.charAt(0) == puzzle[i][j] && visit[i][j]!=1){
			visit[i][j]=1;
			for(int k=0;k<3;k++){
				System.out.println();
				for(int l=0;l<3;l++){
					System.out.print(visit[k][l]);				
				}
			}System.out.println();System.out.println();
			str = str.substring(1);
			boolean found = (auxWordPuzzle(i-1, j, str, puzzle,visit) ||
			auxWordPuzzle(i, j-1, str, puzzle,visit) ||
			auxWordPuzzle(i, j+1, str, puzzle,visit) ||
			auxWordPuzzle(i+1, j, str, puzzle,visit));
			visit[i][j]=0;
			return found;
			
			
		}else{
			return false;
		}
	} 
	
	
}
