import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderGame {

    private List<Player> playerList;
    private DiceRoller diceRoller;
    private static final int BOARD_SIZE = 100;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    public SnakeLadderGame(List<Player> playerList,DiceRoller diceRoller) {
      this.playerList=playerList;
      this.diceRoller=diceRoller;
      initializeSnakeLadderGame();
    }

    private void initializeSnakeLadderGame() {
        snakes = new HashMap<>();
        snakes.put(16, 6);
        snakes.put(47, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);

        ladders = new HashMap<>();
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);

    }

    public  int getNextPosition(int currentPosition,int roll)
    {
        int newPosition =currentPosition+roll;
        if(newPosition>100)
        {
            return currentPosition;
        }
        if(snakes.containsKey(newPosition))
        {
            newPosition = snakes.get(newPosition);
        }
        if(ladders.containsKey(newPosition))
        {
            newPosition = ladders.get(newPosition);
        }
        return newPosition;
    }
    int currentPlayerIndex = 0;
    public void startGame()
    {

        while(true)
        {
            Player currentplayer= playerList.get(currentPlayerIndex);

            System.out.println(currentplayer.getName()+" rolled die");


            System.out.println(currentplayer.getName() + "'s new position is: " + currentplayer.getPosition());

            int roll= diceRoller.rollDice();
            System.out.println("Player"+  " rolled   "+ roll);

            currentplayer.setPosition(getNextPosition(currentplayer.getPosition(),roll));


            System.out.println(currentplayer.getName() + "'s new position is: " + currentplayer.getPosition());

            if (currentplayer.getPosition() == BOARD_SIZE) {
                System.out.println(currentplayer.getName() + " wins!");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex+1)%playerList.size();

        }

    }




}

