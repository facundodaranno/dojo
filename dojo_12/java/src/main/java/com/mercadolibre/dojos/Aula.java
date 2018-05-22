package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 22/5/18.
 */
public interface Aula {
    Aula respondeASolicitudOrDefault(SolicitudAula solicitudAula, Aula aulaDisponible);
    String mostrarNombre();
}
