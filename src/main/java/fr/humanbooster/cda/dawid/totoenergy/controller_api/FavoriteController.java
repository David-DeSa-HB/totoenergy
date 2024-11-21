package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.entity.Favorite;
import fr.humanbooster.cda.dawid.totoenergy.entity.embeded.FavoriteId;
import fr.humanbooster.cda.dawid.totoenergy.service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/favorite")
@AllArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping
    public Favorite addFavorite(String stationId, Principal principal) {
        return favoriteService.create(principal.getName(), stationId);
    }

    @DeleteMapping
    public void removeFavorite(FavoriteId favoriteId) {
        favoriteService.delete(favoriteService.findOneById(favoriteId));
    }
}