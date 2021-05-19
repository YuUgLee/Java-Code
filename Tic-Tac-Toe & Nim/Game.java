public interface Game{
  /**
    * Represents how players move during a Game
    */
  void executeMove();
  
  /**
    * @return true if valid moves were made
    */
  boolean validate();

  /**
    * @return true if the game was won
    */
  boolean checkWin();
}