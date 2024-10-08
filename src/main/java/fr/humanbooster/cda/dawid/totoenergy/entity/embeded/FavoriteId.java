package fr.humanbooster.cda.dawid.totoenergy.entity.embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class FavoriteId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "charging_station_id")
    private String chargingStationId;
}
