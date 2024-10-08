package fr.humanbooster.cda.dawid.totoenergy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class ChargingStation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String accessDirectives;

    @Column(nullable = false)
    private Boolean onFoot;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Power power;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Localisation localisation;

    @OneToMany(mappedBy = "chargingStation")
    private List<Media> medias = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<HourlyRate> hourlyRates = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<Favorite> favorites = new ArrayList<>();

}