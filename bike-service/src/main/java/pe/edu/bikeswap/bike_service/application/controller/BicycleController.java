package pe.edu.bikeswap.bike_service.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.bikeswap.bike_service.domain.service.BikeService;
import pe.edu.bikeswap.bike_service.entity.BikeEntity;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/bikes")
public class BicycleController {
    private final BikeService bikeService;

    @Autowired
    public BicycleController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    // URL: http://localhost:8080/api/v1/bikes
    // Method: GET
    @GetMapping
    public ResponseEntity<List<BikeEntity>> getAllBicycles() {
        return new ResponseEntity<>(bikeService.getAllBikes(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/bikes/{bikeId}
    // Method: GET
    @GetMapping("/{bikeId}")
    public ResponseEntity<BikeEntity> getBicycleByBicycleId(@PathVariable(name = "bikeId") Long bicycleId) {
        BikeEntity bike = bikeService.getBikeById(bicycleId);
        return new ResponseEntity<>(bike, HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/bikes/{bikeId}
    // Method: DELETE
    @DeleteMapping("/{bikeId}")
    public ResponseEntity<BikeEntity> deleteBicycleByBicycleId(@PathVariable(name = "bikeId") Long bicycleId) {
        bikeService.deleteBike(bicycleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // URL: http://localhost:8080/api/v1/bikes
    // Method: POST
    @PostMapping
    public ResponseEntity<BikeEntity> createBike(@RequestBody BikeEntity bike) {
        BikeEntity savedBike = bikeService.addBike(bike);
        return new ResponseEntity<>(savedBike, HttpStatus.CREATED);
    }
}
