package fr.humanbooster.cda.dawid.totoenergy.controller_api;

import fr.humanbooster.cda.dawid.totoenergy.dto.BookingCreateDTO;
import fr.humanbooster.cda.dawid.totoenergy.dto.BookingUpdateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.Booking;
import fr.humanbooster.cda.dawid.totoenergy.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public List<Booking> showAllBookings() {
        return bookingService.list();
    }

    @GetMapping("/{id}")
    public Booking showBooking(@PathVariable String id) {
        return bookingService.findOneById(id);
    }

    @PostMapping
    public Booking createBooking(@RequestBody BookingCreateDTO dto, Principal principal) {
        return bookingService.create(dto, principal);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable String id, @RequestBody BookingUpdateDTO dto) {
        return bookingService.update(dto, id);
    }

}
