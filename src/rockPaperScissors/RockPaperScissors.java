package rockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {

		System.out.println("Welcome to Rock Paper Scissors!\n");

		Scores scores = new Scores(); //Object that holds two integers and allows you to increment them
		Scanner playerChoice = new Scanner(System.in);
		int option = 0;

		do{

			System.out.println("\nSelect an option!");
			System.out.println("1: Play the game");
			System.out.println("2: Check the score");
			System.out.println("3: Quit the game\n");

			option = playerChoice.nextInt(); 
			
			switch(option) {

				case 1: playGame(scores, playerChoice);
						break;
	
				case 2: getScore(scores);
						break;
	
				case 3: System.out.println("Thanks for playing!");
						break;
	
				default: System.out.println("You must pick one of given options\n");
						break;
			}
			

		} while(option != 3);

		playerChoice.close();

	}

	private static Scores playGame(Scores scores, Scanner scan) {

		System.out.println("Pick either rock, paper, or scissors");

		//The player makes a choice
		String playerDecision = scan.next(); 
		
		

		//Check to see if the player chose one of the given options
		if(playerDecision.equalsIgnoreCase("rock") == false && playerDecision.equalsIgnoreCase("paper") == false && playerDecision.equalsIgnoreCase("scissors") == false){

			System.out.println("You must select either rock, paper, or scissors");
			return scores;
		}

		//The computer makes a random choice
		Random random = new Random();
		String gameArray[] = {"rock", "paper", "scissors"};
		int randNum = random.nextInt(3);
		String computerChoice = gameArray[randNum];

		System.out.println("\nYou chose: " + playerDecision + "\nThe computer choice: " + computerChoice + "\n");


		if(playerDecision.equalsIgnoreCase(computerChoice)){ //If it's a tie

			System.out.println("It's a tie!");
			return scores;

		} else if(playerDecision.equalsIgnoreCase("rock")){ //If the player chooses rock

			if(computerChoice.equalsIgnoreCase("paper")){ //If the computer chooses paper
				System.out.println("The computer wins!");
				scores.incrementComputerScore();
				return scores;

			} else if(computerChoice.equalsIgnoreCase("scissors")){ //If the computer chooses scissors
				System.out.println("You win!");
				scores.incrementPlayerScore();
				return scores;
			}

		} else if(playerDecision.equalsIgnoreCase("paper")){ //If the player chooses paper

			if(computerChoice.equalsIgnoreCase("rock")){ //If the computer chooses rock
				System.out.println("You win!");
				scores.incrementPlayerScore();
				return scores;

			}else if(computerChoice.equalsIgnoreCase("scissors")){ //If the computer chooses scissor
				System.out.println("The computer wins!");
				scores.incrementComputerScore();
				return scores;
			}

		} else if(playerDecision.equalsIgnoreCase("scissors")){ //If the player chooses scissors

			if(computerChoice.equalsIgnoreCase("rock")){ //If the computer chooses rock
				System.out.println("The computer wins!");
				scores.incrementComputerScore();
				return scores;

			}else if(computerChoice.equalsIgnoreCase("paper")){ //If the computer chooses paper
				System.out.println("You win!");
				scores.incrementPlayerScore();
				return scores;
			}
		}
		return scores;

	}

	private static void getScore(Scores scores) {

		System.out.println("\tPlayer Score: " + scores.getPlayerScore());
		System.out.println("\tComputer Score: " + scores.getComputerScore());

	}

}