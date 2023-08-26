import java.util.Random;

public class StandardDiceRoller implements DiceRoller{

    @Override
    public int rollDice() {

            Random rand = new Random();
            return rand.nextInt(6) + 1;

    }
}
