package problems;

import java.util.Arrays;
//Class Solution.
public class allAnagramsSolution2 {
	static int fullCounter = 0;
	public static void main(String[] args) {
		String str = "abc";
		permutations(str);
	}
	
	public static void permutations (String str){
		char out[] = new char[str.length()];
		int d=0;
		auxPermutations(str,out,d);
	}
	
	public static void auxPermutations(String str,char[]out,int d){
		if(out.length == d){
				if(isValid(out)){
					System.out.println(Arrays.toString(out));
				}
				return;	
		}
		for(int j=0;j<str.length();j++){
					out[d]=str.charAt(j);
					auxPermutations(str,out,d+1);
				
		}
	}
	
	public static boolean isValid(char[]out){
		for(int i=0;i<out.length;i++){
			for(int j=i+1;j<out.length;j++){
				if(out[i]==out[j]){
					return false;
				}
			}
		}
		return true;
	}

}
