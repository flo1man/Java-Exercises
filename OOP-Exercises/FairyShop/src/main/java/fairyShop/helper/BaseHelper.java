package fairyShop.helper;

import fairyShop.models.Helper;
import fairyShop.models.Instrument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static fairyShop.common.ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY;

public abstract class BaseHelper implements Helper {
    protected String name;
    protected int energy;
    protected Collection<Instrument> instruments;

    protected BaseHelper(String name, int energy){
        this.instruments = new ArrayList<>();
        setName(name);
        setEnergy(energy);
    }

    @Override
    public void work() {
        this.energy -= 10;
        if (this.energy < 0){
            this.energy = 0;
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        if (this.energy > 0){
            return true;
        }

        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name){
        if(name.isBlank()){
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }
}
