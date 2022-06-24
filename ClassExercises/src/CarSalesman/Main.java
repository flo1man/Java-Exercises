package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int engineCount = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < engineCount; i++) {
            String[] engineTokens = scanner.nextLine().split(" ");
            String model = engineTokens[0];
            int power = Integer.parseInt(engineTokens[1]);

            if (engineTokens.length == 4){
                int displacement = Integer.parseInt(engineTokens[2]);
                String efficiency = engineTokens[3];
                engines.add(new Engine(model, power, displacement, efficiency));
            }
            else if (engineTokens.length == 3) {
                try{
                    int displacement = Integer.parseInt(engineTokens[2]);
                    engines.add(new Engine(model, power, displacement));
                }
                catch (Exception e){
                    String efficiency = engineTokens[2];
                    engines.add(new Engine(model, power, efficiency));
                }
            }
            else {
                engines.add(new Engine(model, power));
            }
        }

        int carCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < carCount; i++) {
            String[] carTokens = scanner.nextLine().split(" ");
            String model = carTokens[0];
            String engine = carTokens[1];

            if (carTokens.length == 4){
                int weight = Integer.parseInt(carTokens[2]);
                String color = carTokens[3];
                cars.add(new Car(model, engine, weight, color));
            }
            else if (carTokens.length == 3) {
                try{
                   int weight = Integer.parseInt(carTokens[2]);
                   cars.add(new Car(model, engine, weight));
                }
                catch (Exception e){
                    String color = carTokens[2];
                    cars.add(new Car(model, engine, color));
                }
            }
            else {
                cars.add(new Car(model, engine));
            }
        }

        for (var car:cars){
            car.setEngineModel(engines, car.getEngine());
        }

        for (var car:cars){
            System.out.println(car);
        }
    }
}
