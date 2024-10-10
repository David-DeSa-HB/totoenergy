package fr.humanbooster.cda.dawid.totoenergy.service.interfaces;

public interface ServiceUpdateWithPrincipalInterface<T, DTO, DTOU, ID, PRINCIPAL> {
    T create(DTO dto, PRINCIPAL principal);
    void delete(T object);
    T update(DTOU dto, ID id);
}
