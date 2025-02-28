package pe.edu.bikeswap.bike_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="bikes")
@Data
public class BikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false, length = 16)
    private String name;

    @Column(name="brand", nullable = false, length = 16)
    private String brand;

    @Column(name="image_url", nullable = false)
    private String imageUrl;
}
