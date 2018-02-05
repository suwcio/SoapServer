package suvsoft.endpoint;

import io.spring.guides.gs_producing_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint //rejestruje klase jako kandydata do przetwarzania przychodzacych wiadomosci SOAP
public class CarEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private suvsoft.repository.CarRepository carRepository;

    @Autowired
    public CarEndpoint(suvsoft.repository.CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarRequest") //wybiera metode przechwytujaca
    @ResponsePayload //mapuje zwracana wartosc na payload odpowiedzi
    public GetCarResponse getCar(@RequestPayload GetCarRequest request) { //przychodzaca wiadomosc bedzie zmapowana do parametru metody
        GetCarResponse response = new GetCarResponse();
        response.setCar(carRepository.findCar(request.getName()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCarRequest") //wybiera metode przechwytujaca
    @ResponsePayload //mapuje zwracana wartosc na payload odpowiedzi
    public CreateCarResponse createCar(@RequestPayload CreateCarRequest request) { //przychodzaca wiadomosc bedzie zmapowana do parametru metody
        CreateCarResponse response = new CreateCarResponse();
        Car car = new Car();
        car.setName(request.getName());
        car.setSpeed(request.getSpeed());
        car.setAcceleration(request.getAcceleration());
        car.setWeight(request.getWeight());
        car.setEngineClass(request.getEngineClass());
        response.setCar(carRepository.createCar(car));

        return response;
    }
}
