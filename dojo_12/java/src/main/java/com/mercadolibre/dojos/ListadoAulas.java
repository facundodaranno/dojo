package com.mercadolibre.dojos;

import java.util.ArrayList;

/**
 * Created by fdaranno on 21/5/18.
 */
public class ListadoAulas {

    private ArrayList<Aula> aulas;

    public ListadoAulas(){
        aulas = new ArrayList();
    }

    public void agregarAula(Aula aula) {
        aulas.add(aula);
    }

    public Aula realizarSolicitud(SolicitudAula solicitudAula) {

        Aula aulaDisponible = new Aula("No Disponbile", 0);

        for ( Aula aula : aulas ) {
            aulaDisponible = aula.respondeASolicitudOrDefault(solicitudAula, aulaDisponible);
        }

        return aulaDisponible;
    }
}
