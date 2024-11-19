package fr.humanbooster.cda.dawid.totoenergy.service;

import fr.humanbooster.cda.dawid.totoenergy.entity.ChargingStation;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.repository.ChargingStationRepository;
import fr.humanbooster.cda.dawid.totoenergy.repository.FavoriteRepository;
import fr.humanbooster.cda.dawid.totoenergy.entity.Favorite;
import fr.humanbooster.cda.dawid.totoenergy.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final ChargingStationService chargingStationService;
    private final UserService userService;

    public Favorite create(String userId, String stationId) {
        User user = userService.findOneById(userId);
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