package suvsoft.repository;

import io.spring.guides.gs_producing_web_service.Car;
import io.spring.guides.gs_producing_web_service.EngineClass;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CarRepository {
    private static final Map<String, Car> cars = new HashMap<>();

    @PostConstruct
    public void initData() {
        Car rcsan = new Car();
        rcsan.setName("RC San");
        rcsan.setSpeed(50);
        rcsan.setAcceleration(3);
        rcsan.setWeight(1);
        rcsan.setEngineClass(EngineClass.ELECTRIC);
        cars.put(rcsan.getName(), rcsan);

        Car snw35 = new Car();
        snw35.setName("SNW 35");
        snw35.setSpeed(65);
        snw35.setAcceleration(4);
        snw35.setWeight(2);
        snw35.setEngineClass(EngineClass.GLOW);
        cars.put(snw35.getName(), snw35);

        Car humma = new Car();
        humma.setName("Humma");
        humma.setSpeed(64);
        humma.setAcceleration(3);
        humma.setWeight(2);
        humma.setEngineClass(EngineClass.GLOW);
        cars.put(humma.getName(), humma);

        Car toyeca = new Car();
        toyeca.setName("Toyeca");
        toyeca.setSpeed(64);
        toyeca.setAcceleration(3);
        toyeca.setWeight(2);
        toyeca.setEngineClass(EngineClass.GLOW);
        cars.put(toyeca.getName(), toyeca);
    }

    public Car findCar(String name) {
        Assert.notNull(name, "The car's name must not be null");
        return cars.get(name);
    }

    public Car createCar(Car car) {
        cars.put(car.getName(), car);
        return car;
    }
}
