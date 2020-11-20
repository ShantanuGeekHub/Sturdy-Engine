import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		
		char[][] gameBoard = {{' ','|',' ','|',' '},
				{'-','-','-','-','-'},
				{' ','|',' ','|',' '},
				{'-','-','-','-','-'},
				{' ','|',' ','|',' '}};
		
		printGameBoard(gameBoard);
		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the position (1-9)");
			int pos = sc.nextInt();
			while(playerPositions.contains(pos) || cpuPositions.contains(pos))
			{
				System.out.println("Position Taken, Enter Empty Position.");
				pos = sc.nextInt();
			}
			
			System.out.println("Player:");
			setValue(pos,gameBoard,"player");
			printGameBoard(gameBoard);
			System.out.println();
			
			String winner = checkWinner();
			if(winner.length()>0)
			{
				
				System.out.println(winner);
				break;
				
			}
			
			Random rand = new Random();
			int cpuPos = rand.nextInt(9)+1;
			while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos))
			{
				cpuPos = rand.nextInt(9)+1;
			}
			
			System.out.println("Cpu:");
			setValue(cpuPos,gameBoard,"cpu");
			printGameBoard(gameBoard);
			System.out.println();
			
			
			winner = checkWinner();
			if(winner.length()>0)
			{
				
				System.out.println(winner);
				break;
				
			}
			
			
		}
		
				
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		
		for(char[] row : gameBoard)
		{
			for(char k : row)
			{
				System.out.print(k);
			}
			System.out.println();
		}
		
	}
	
	public static void setValue(int pos, char[][] gameBoard, String user) {
		
		char symbol;
		
		if(user.equals("player"))
		{
			symbol = 'X';
			playerPositions.add(pos);
		}
		else
		{
			symbol = 'O';
			cpuPositions.add(pos);
		}
		
		
		switch(pos)
		{
		
		case 1:
			gameBoard[0][0] = symbol;
			break;
			
		case 2:
			gameBoard[0][2] = symbol;
			break;
			
		case 3:
			gameBoard[0][4] = symbol;
			break;
			
		case 4:
			gameBoard[2][0] = symbol;
			break;
			
		case 5:
			gameBoard[2][2] = symbol;
			break;
			
		case 6:
			gameBoard[2][4] = symbol;
			break;
			
		case 7:
			gameBoard[4][0] = symbol;
			break;
			
		case 8:
			gameBoard[4][2] = symbol;
			break;
		
		case 9:
			gameBoard[4][4] = symbol;
			break;
		
		default:
			System.out.println("Invalid input...!!!");
			break;
		}
		
	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List botCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List diag1 = Arrays.asList(1,5,9);
		List diag2 = Arrays.asList(3,5,7);		
		
		ArrayList<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(botRow);
		winningConditions.add(leftCol);
		winningConditions.add(rightCol);
		winningConditions.add(botCol);
		winningConditions.add(diag1);
		winningConditions.add(diag2);
		
		for(List l : winningConditions) {
			
			if(playerPositions.containsAll(l))
			{
				return "Congratulations, You Won..!!!";
			}
			else if(cpuPositions.containsAll(l))
			{
				return "Cpu Wins...!!! :(";
			}
			else if(playerPositions.size() + cpuPositions.size() == 9)
			{
				return "Tie...!!!";
			}
			
			
			
		}
		
		return""; 
	}
	
}