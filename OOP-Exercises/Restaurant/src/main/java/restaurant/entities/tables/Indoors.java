package restaurant.entities.tables;

public class Indoors extends BaseTable{
    private static final double INITIAL_PRICE_PER_PERSON = 3.50;

    public Indoors(int number, int size) {
        super(number, size, INITIAL_PRICE_PER_PERSON);
    }
}
