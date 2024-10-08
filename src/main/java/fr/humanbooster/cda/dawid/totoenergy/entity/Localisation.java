package fr.humanbooster.cda.dawid.totoenergy.entity;

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
public class Localisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String streetNumber;

    @Column(nullable = false)
    private String streetName;

    private String latitude;

    private String longitude;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "localisation")
    private List<ChargingStation> chargingStations = new ArrayList<>();

    @OneToMany(mappedBy = "localisation")
    private List<UserLocalisation> userLocalisations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private User owner;

    @ManyToOne
    private UserLocalisation userLocalisation;

}