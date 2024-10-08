package fr.humanbooster.cda.dawid.totoenergy.entity;

import fr.humanbooster.cda.dawid.totoenergy.entity.embeded.FavoriteId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Favorite {

    @EmbeddedId
    private FavoriteId id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "charging_station_id", insertable = false, updatable = false)
    private ChargingStation chargingStation;

}