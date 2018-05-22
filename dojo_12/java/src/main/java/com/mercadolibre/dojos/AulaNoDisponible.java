package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 21/5/18.
 */
public class AulaNoDisponible implements Aula {

    public String mostrarNombre() {
        return "No hay aula disponible";
    }

    public boolean equals(Object object) {
        return object.getClass().equals( this.getClass() );
    }

    public Aula respondeASolicitudOrDefault(SolicitudAula solicitudAula, Aula defaultAula) {
        return defaultAula;
    }
}
