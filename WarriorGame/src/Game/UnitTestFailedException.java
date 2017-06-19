package Game;

public class UnitTestFailedException extends RuntimeException{
	
	UnitTestFailedException(String message){
		throw new RuntimeException(message);
	}
	
}
