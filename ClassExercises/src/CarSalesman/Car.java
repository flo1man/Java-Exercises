package CarSalesman;

import java.util.List;

public class Car {
    private String model;
    private String engine;
    private int weight;
    private String color;
    private Engine engineModel;

    public Car(String model, String engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, String engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
    }

    public Car(String model, String engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public Car(String model, String engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getEngine(){
        return  this.engine;
    }
    public void setEngineModel(List<Engine> engines, String engineModel){
        var engine = engines.stream().filter(x -> x.getModel().equals(engineModel)).findFirst().orElse(null);
        this.engineModel = engine;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s:\n", this.model));
        sb.append(String.format("\t%s:\n", this.engine));
        sb.append(String.format("\t\tPower: %s\n", this.engineModel.getPower()));
        sb.append(String.format("\t\tDisplacement: %s\n", this.engineModel.getDisplacement() == 0
                ? "n/a" : this.engineModel.getDisplacement()));
        sb.append(String.format("\t\tEfficiency: %s\n", this.engineModel.getEfficiency() == null
                ? "n/a" : this.engineModel.getEfficiency()));
        sb.append(String.format("\tWeight: %s\n", this.weight == 0
                ? "n/a" : this.weight));
        sb.append(String.format("\tColor: %s\n", this.color == null
                ? "n/a" : this.color));

        return sb.toString().trim();
    }
}
