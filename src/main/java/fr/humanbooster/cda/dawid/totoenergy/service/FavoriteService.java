package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.entity.ChargingStation;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.entity.embeded.FavoriteId;
import fr.humanbooster.cda.dawid.totoenergy.repository.FavoriteRepository;
import fr.humanbooster.cda.dawid.totoenergy.entity.Favorite;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final ChargingStationService chargingStationService;
    private final UserService userService;

    public Favorite findOneById(FavoriteId favoriteId) {
        return favoriteRepository.findById(favoriteId).orElseThrow(EntityNotFoundException::new);
    }

    public Favorite create(String stationId, String userEmail) {
        User user = userService.findOneByEmail(userEmail);
        ChargingStation station = chargingStationService.findOneById(stationId);
        List<Favorite> favorites = user.getFavorites();

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setChargingStation(station);
        favorite.setCreatedAt(LocalDateTime.now());
        favorites.add(favorite);
        return favoriteRepository.saveAndFlush(favorite);
    }

    public void delete(Favorite favorite)  {
        favoriteRepository.delete(favorite);
    }
}