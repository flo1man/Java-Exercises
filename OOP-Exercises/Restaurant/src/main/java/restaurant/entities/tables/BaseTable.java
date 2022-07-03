package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;

    private boolean isReservedTable;

    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson){
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        setNumber(number);
        setSize(size);
        setPricePerPerson(pricePerPerson);
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setSize(int size){
        if (size < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }

        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople){
        if (numberOfPeople < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
    }

    public void setPricePerPerson(double pricePerPerson){
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReservedTable = true;
        setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double sum = this.healthyFood.stream().mapToDouble(x -> x.getPrice()).sum()
                + this.beverages.stream().mapToDouble(x -> x.getPrice()).sum();

        return sum;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.isReservedTable = false;
        setNumberOfPeople(0);
    }

    @Override
    public String tableInformation() {
        StringBuilder sb =  new StringBuilder();
        sb.append(String.format("Table - %d", this.number))
                .append(String.format("Size - %d", this.size))
                .append(String.format("Type - %s", this.getClass().getName()))
                .append(String.format("All price - %d", this.pricePerPerson));

        return sb.toString().trim();
    }
}
