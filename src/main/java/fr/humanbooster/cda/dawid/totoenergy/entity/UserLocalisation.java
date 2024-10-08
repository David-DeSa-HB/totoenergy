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
public class UserLocalisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isBilling = false;

    @ManyToOne
    private User user;

    @ManyToOne
    private Localisation localisation;

    @OneToMany(mappedBy = "userLocalisation")
    private List<Booking> bookings = new ArrayList<>();
}