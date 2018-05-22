package com.mercadolibre.dojos;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for the dojo.
 */
public class DojoTest {

	
	@Before
	public void setup() {
	}
	
	@Test
	public void se_solicita_un_aula_para_10_personas_debe_indicar_aula_b() {

		// Listado de aulas:  [{nombre:aula_a, capacidadSolicitada:5},{nombre:aula_b, capacidadSolicitada:15}]

		Aula aulaA = new Aula("aula_a", 5);
		Aula aulaB = new Aula("aula_b", 15);
		Aula aulaB = new Aula("aula_c", 15);

		ListadoAulas listadoAulas = new ListadoAulas();
		listadoAulas.agregarAula( aulaA );
		listadoAulas.agregarAula( aulaB );

		SolicitudAula solicitudAula = new SolicitudAula(10);
		Aula aulaDisponible = listadoAulas.realizarSolicitud( solicitudAula );

		Aula aulaEsperada = new Aula("aula_b", 15);
		Assert.assertTrue( aulaDisponible.equals( aulaEsperada ) );
	}

}
