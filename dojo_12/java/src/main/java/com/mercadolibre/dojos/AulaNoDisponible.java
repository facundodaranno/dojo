package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 21/5/18.
 */
public class AulaNoDisponible implements Aula {

    public AulaNoDisponible() {}

    public String mostrarNombre() {
        return "Aula no disponibles";
    }

    public boolean equals(AulaDisponible aula) {
        return false;
    }

    public boolean equals(AulaNoDisponible aula) {
        return true;
    }

    public Aula respondeASolicitudOrDefault(SolicitudAula solicitudAula, Aula defaultAula) {
        return defaultAula;
    }
}
