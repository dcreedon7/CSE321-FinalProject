import java.util.Random;

public class Dice {
        private int value;
        private boolean rollable;

        public Dice() {
            value = -1;
            rollable = true;
        }

        public int getValue() {
            return value;
        }

        public boolean isRollable() {
            return rollable;
        }

        public void roll() {
        	if (rollable == true || value < 1) {
        		value = new Random().nextInt(6) + 1;
        	}
        }

		public void setValue(int value) {
			this.value = value;
		}

		public void setRollable(boolean rollable) {
			this.rollable = rollable;
		}
    }