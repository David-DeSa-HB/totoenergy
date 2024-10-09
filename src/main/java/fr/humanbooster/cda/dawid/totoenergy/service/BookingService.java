package fr.humanbooster.cda.dawid.totoenergy.service;


import fr.humanbooster.cda.dawid.totoenergy.dto.BookingCreateDTO;
import fr.humanbooster.cda.dawid.totoenergy.dto.BookingUpdateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.Booking;
import fr.humanbooster.cda.dawid.totoenergy.entity.User;
import fr.humanbooster.cda.dawid.totoenergy.repository.BookingRepository;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceListInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceUpdateInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingService implements ServiceListInterface<Booking, String>, ServiceUpdateInterface<Booking, BookingCreateDTO, BookingUpdateDTO, String> {

    private final BookingRepository bookingRepository;
    private final UserService userService;

    @Override
    public Booking create(BookingCreateDTO dto) {
        Booking booking = new Booking();
        return bookingRepository.saveAndFlush(booking);
    }

    @Override
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> list() {
        return List.of();
    }

    @Override
    public Booking findOneById(String id) {
        return bookingRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Booking update(BookingUpdateDTO dto, String s) {
        return null;
    }

//    public Booking BookingFromCreateDTO(Booking booking, BookingCreateDTO dto) {
//        Principal principal = new User()
//        booking.setStartedAt(dto.getStartedAt());
//        booking.setFinishedAt(dto.getFinishedAt());
//        booking.setChargingStation(chargingStationService.findOneById(dto.getChargingStation()));
//        booking.setChargingStation(userLocalisationRepository.findOneById(dto.getUserLocalisation()));
//        booking.setUser(userService.findOneById(principal.getClass().get));
//        return booking;
//    }

    public Booking BookingFromUpdateDTO(Booking booking, BookingUpdateDTO dto) {
        booking.setStatus(dto.getStatus());
        return booking;
    }
}