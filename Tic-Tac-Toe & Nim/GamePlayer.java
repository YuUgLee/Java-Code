public class GamePlayer implements Game{
  /** The game attributed to the game player */
  private Game gamePlaying;

  /**
    * Constructs a GamePlayer object
    * @param g - the game the GamePlayer is playing
    */
  public GamePlayer(Game g){
    gamePlaying = g;
  }

  /**
    * Executes moves
    * Users will play a certain way based on the game
    */
  public void executeMove(){
    gamePlaying.executeMove();
  }

  /**
    * @return true if the moves were valid
    */
  public boolean validate(){
    return gamePlaying.validate();
  }

  /**
    * @return true if the game was won
    */
  public boolean checkWin(){
    return gamePlaying.checkWin();
  }
}