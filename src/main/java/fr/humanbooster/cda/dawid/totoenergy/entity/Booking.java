package fr.humanbooster.cda.dawid.totoenergy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate startedAt;

    @Column(nullable = false)
    private LocalDate finishedAt;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    private User user;

    @ManyToOne
    private ChargingStation chargingStation;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserLocalisation userLocalisation;

}