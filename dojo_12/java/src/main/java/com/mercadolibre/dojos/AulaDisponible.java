package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 21/5/18.
 */
public class AulaDisponible implements Aula {

    private String nombre;
    private Integer capacidad;

    public AulaDisponible(String nombre, Integer capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public String mostrarNombre() {
        return nombre;
    }

    public boolean equals(AulaDisponible aula) {
        return nombre.equals( aula.nombre ) && capacidad.equals(aula.capacidad );
    }

    public Aula respondeASolicitudOrDefault(SolicitudAula solicitudAula, Aula defaultAula) {
        return solicitudAula.esCubiertaPor(capacidad, this, defaultAula);
    }
}
