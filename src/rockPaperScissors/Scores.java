package rockPaperScissors;

public class Scores {
	
	private int playerScore;
	private int computerScore;
	
	public int getPlayerScore(){
		return this.playerScore;
	}
	
	public int getComputerScore(){
		return this.computerScore;
	}
	
	public boolean incrementPlayerScore(){
		this.playerScore++;
		return true;
	}
	
	public boolean incrementComputerScore(){
		this.computerScore++;
		return true;
	}

}
