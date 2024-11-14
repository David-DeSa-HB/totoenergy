package fr.humanbooster.cda.dawid.totoenergy.service;


import fr.humanbooster.cda.dawid.totoenergy.dto.BookingCreateDTO;
import fr.humanbooster.cda.dawid.totoenergy.dto.BookingUpdateDTO;
import fr.humanbooster.cda.dawid.totoenergy.entity.Booking;
import fr.humanbooster.cda.dawid.totoenergy.repository.BookingRepository;
import fr.humanbooster.cda.dawid.totoenergy.repository.UserRepository;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceListInterface;
import fr.humanbooster.cda.dawid.totoenergy.service.interfaces.ServiceUpdateWithPrincipalInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingService implements ServiceListInterface<Booking, String>,
        ServiceUpdateWithPrincipalInterface<Booking, BookingCreateDTO, BookingUpdateDTO, String, Principal> {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ChargingStationService chargingStationService;
    private final UserLocalisationService userLocalisationService;

    @Override
    public Booking create(BookingCreateDTO dto, Principal principal) {
        Booking booking = bookingFromCreateDTO(new Booking(), dto, principal);
        return bookingRepository.saveAndFlush(booking);
    }

    @Override
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> list() {
        return bookingRepository.findAll();
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

    public Booking bookingFromCreateDTO(Booking booking, BookingCreateDTO dto, Principal principal) {
        booking.setStartedAt(dto.getStartedAt());
        booking.setFinishedAt(dto.getFinishedAt());
        booking.setChargingStation(chargingStationService.findOneById(dto.getChargingStation()));
        booking.setUserLocalisation(userLocalisationService.findOneById(dto.getUserLocalisation()));
        booking.setUser(userRepository.findByEmail(principal.getName()).orElseThrow());
        return booking;
    }

    public Booking BookingFromUpdateDTO(Booking booking, BookingUpdateDTO dto) {
        booking.setStatus(dto.getStatus());
        return booking;
    }
}