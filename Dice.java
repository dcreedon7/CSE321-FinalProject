import java.util.Random;

public class Dice {
    private int value;
    private Random random;

    public Dice() {
        random = new Random();
        roll();
    }

    public void roll() {
        value = random.nextInt(6) + 1;
    }

    public int getValue() {
        return value;
    }
}
