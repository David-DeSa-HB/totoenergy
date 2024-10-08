package fr.humanbooster.cda.dawid.totoenergy.service.interfaces;

public interface ServiceGetInterface<T, ID>{

    T findOneById(ID id);
}
