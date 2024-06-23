package pe.edu.bikeswap.bike_service.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.bikeswap.bike_service.domain.repository.BikeRepository;
import pe.edu.bikeswap.bike_service.entity.BikeEntity;

import java.util.List;

@Service
public class BikeService {
    private  final BikeRepository bikeRepository;

    @Autowired
    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public List<BikeEntity> getAllBikes() {
        return bikeRepository.findAll();
    }

    public BikeEntity getBikeById(Long id) {
        return bikeRepository.findById(id).orElse(null);
    }

    public BikeEntity addBike(BikeEntity bike) {
        return bikeRepository.save(bike);
    }

    public void deleteBike(Long id) {
        bikeRepository.deleteById(id);
    }
}
