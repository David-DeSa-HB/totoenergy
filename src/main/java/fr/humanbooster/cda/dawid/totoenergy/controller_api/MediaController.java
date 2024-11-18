package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.entity.Media;
import fr.humanbooster.cda.dawid.totoenergy.service.MediaService;
import fr.humanbooster.cda.dawid.totoenergy.dto.MediaDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
@AllArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @GetMapping()
    public List<Media> List() {
        return mediaService.list();
    }
    
    @GetMapping("/{id}")
    public Media findMediaBySearch(@PathVariable String id){
        return mediaService.findOneById(id);
    }
    
    @PostMapping
    public Media mediaService(@Valid @RequestBody MediaDTO dto){
        return mediaService.create(dto);
    }
    
    @PutMapping("/{id}")
    public void updateMediaById(
            @PathVariable String id,
            @Valid @RequestBody MediaDTO dto){
        if (id != null){
            mediaService.update(dto, id);
        }
    }
    
    @DeleteMapping("/{id}")
    public void deleteMediaByID(@PathVariable String id){
        if (id != null){
            mediaService.delete(mediaService.findOneById(id));
        }
    }
    
    
}