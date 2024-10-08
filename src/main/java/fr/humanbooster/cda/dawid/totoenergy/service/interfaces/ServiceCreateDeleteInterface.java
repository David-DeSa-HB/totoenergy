package fr.humanbooster.cda.dawid.totoenergy.service.interfaces;

public interface ServiceCreateDeleteInterface <T, DTO> {

    T create(DTO dto);

    void delete(T object);

}
