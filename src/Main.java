
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        //game has a player
        List<Player> playerList= new ArrayList<>();

        playerList.add(new Player("player 1"));
        playerList.add(new Player("player 2"));

        //game has  dice
        DiceRoller diceRoller= new StandardDiceRoller();

        //the game
        SnakeLadderGame snakeLadderGame= new SnakeLadderGame(playerList,diceRoller);
        snakeLadderGame.startGame();


    }


}