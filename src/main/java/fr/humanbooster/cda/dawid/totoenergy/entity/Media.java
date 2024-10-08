package fr.humanbooster.cda.dawid.totoenergy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String extension;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ChargingStation chargingStation;

}