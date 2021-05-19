import java.util.*;
import java.io.*;

public class TicTacToe implements Game{
  private char[][] board=new char[3][3];
  private int rand1;
  private int rand2;
  private int count;
  private int count1;
    /**
    * Constructs a gameboard of TicTacToe
    */
  public TicTacToe(){
	  for (int i=0;i<board.length;i++){
      board[i]= new char[]{'*','*','*'};
      System.out.println(board[i]);
    }
  }
    /**
    * Executes move for user and computer
    */
  public void executeMove(){
	  Scanner scnr= new Scanner(System.in);
	  System.out.println("Enter in the row (0-2):");
	  rand1=scnr.nextInt();
	  System.out.println("Enter in the column (0-2):");
	  rand2=scnr.nextInt();
	  Random rand= new Random();
	  while (validate()!=true) {
      System.out.println("That marker is occupied. PLease try a different position.");
		  System.out.println("Enter in the row (0-2):");
		  rand1=scnr.nextInt();
		  System.out.println("Enter in the column (0-2):");
		  rand2=scnr.nextInt();
	  }
	  board[rand1][rand2]='X';
	  if (checkWin()==true) {
		  for (int i=0;i<board.length;i++){
			  System.out.println(board[i]);
			    }
		  System.out.println("Game over");
		  checkWinner();
	  }
	  else {
	  while (validate()!=true) {
	  rand1=rand.nextInt(3);
	  rand2=rand.nextInt(3);
	  }
	  board[rand1][rand2]='O';
	  if (checkWin()==true) {
		  for (int i=0;i<board.length;i++){
			  System.out.println(board[i]);
			    }
		  System.out.println("Game over");
		  checkWinner();
	  }
	  else if (checkWin()==false) {
		  for (int i=0;i<board.length;i++){
			  System.out.println(board[i]);
			    }
	    }
	  } 
  }

    /**
    * Validates the position if its occupied by computer or user
    * @return true - if position is not occupied
    * @return false - if position is occupied
    */
  public boolean validate(){
  if (rand1 < 0 || rand1 > 2){
    return false;
  }
  if (rand2 < 0 || rand2 > 2){
    return false;
  }
	if (board[rand1][rand2]=='*') {
		return true;
	}
	return false;

  }

	  /**
    * Checks winner and displays winner
    */
  public void checkWinner(){
	  if (count==3) {
		  System.out.println("You win!");
	  }
	  else {
		  System.out.println("Computer wins. You lose."); 
	  }
  }
  
  /**
    * Checks for a three way win 
    * @return true - if a win is found
    * @return false - if a win is not found
    */
  public boolean checkWin(){
	  count=0;
	  count1=0;
	  for (int i=0;i<board.length;i++){
		  for (int j=0;j<board.length;j++) {
			  if (board[i][j]=='X') {
				  count++;
			  }
			  if (board[i][j]=='O') {
				  count1++;
			  }
			  if (count==3) {
				  return true;
			  }
			  if (count1==3) {
				  return true;
			  }
		  }
		  count=0;
		  count1=0;
	    }
	  count=0;
	  count1=0;
	  for (int i=0;i<board.length;i++){
		  for (int j=0;j<board.length;j++) {
			  if (board[j][i]=='X') {
				  count++;
			  }
			  if (board[j][i]=='O') {
				  count1++;
			  }
			  if (count==3) {
				  return true;
			  }
			  if (count1==3) {
				  return true;
			  }
		  }
		  count=0;
		  count1=0;
	    }
	  if (board[0][0]=='X' && board[1][1]=='X' && board [2][2]=='X') {
		  count=3;
		  return true;
		  
	  }
	  if (board[0][2]=='X' && board[1][1]=='X' && board [2][0]=='X') {
		  count=3;
		  return true;
	  }
	  if (board[0][0]=='O' && board[1][1]=='O' && board [2][2]=='O') {
		  count1=3;
		  return true;
		  
	  }
	  if (board[0][2]=='O' && board[1][1]=='O' && board [2][0]=='O') {
		  count1=3;
		  return true;
	  }
		  
	return false;
    
  }

}