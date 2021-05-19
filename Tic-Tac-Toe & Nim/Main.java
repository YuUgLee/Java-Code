/* Newton Bao
 * Justin Le
 * Christopher Shih
 * Ann Luong
  */
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int gameChoice;

    do{
      System.out.println("Choose a game\n1. Tic Tac Toe\n2. Nim");
      while(!in.hasNextInt()){
        in.next();
      }
      gameChoice = in.nextInt();
    } while (gameChoice != 1 && gameChoice != 2);
    
    Game game;
    if (gameChoice == 1){
      game = new TicTacToe();
    }
    else{
      game = new Nim();
    }

    GamePlayer player=new GamePlayer(game);
      while (player.checkWin()==false) {
        player.executeMove();
      }
  }
  //   if (gameChoice == 1){
  //     Game game = new TicTacToe();
  //     GamePlayer player=new GamePlayer(game);
  //     while (player.checkWin()==false) {
  //       player.executeMove();
  //   }

  //   }
  //   if (gameChoice == 2){
  //     Game game = new Nim();
  //     GamePlayer player = new GamePlayer(game);
  //     while (player.checkWin()==false){
  //       player.executeMove();
  //     }
  //   }
  // }
}