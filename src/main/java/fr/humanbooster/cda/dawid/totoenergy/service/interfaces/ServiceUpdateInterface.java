package fr.humanbooster.cda.dawid.totoenergy.service.interfaces;

public interface ServiceUpdateInterface <T, DTO, DTOU, ID> extends ServiceCreateDeleteInterface <T, DTO> {

    T update(DTOU dto, ID id);
}
