package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 21/5/18.
 */
public class SolicitudAula {

    public Integer capacidadSolicitada;

    public SolicitudAula(Integer capacidad) {
        capacidadSolicitada = capacidad;
    }

    public Aula esCubiertaPor(Integer capacidadDisponible, Aula aulaDisponible, Aula defaultAula) {
        return capacidadSolicitada <= capacidadDisponible ? aulaDisponible : defaultAula;
    }
}
