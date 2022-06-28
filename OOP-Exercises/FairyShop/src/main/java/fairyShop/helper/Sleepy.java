package fairyShop.helper;

public class Sleepy extends BaseHelper {
    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        this.energy -= 5;
        if (this.energy < 0){
            this.energy = 0;
        }
    }
}
