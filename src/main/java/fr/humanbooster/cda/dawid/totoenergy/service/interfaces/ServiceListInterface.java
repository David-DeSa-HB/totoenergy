package fr.humanbooster.cda.dawid.totoenergy.service.interfaces;

import java.util.List;

public interface ServiceListInterface <T, ID> extends ServiceGetInterface <T, ID> {

    List<T> list();
}
