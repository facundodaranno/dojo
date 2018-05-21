package com.mercadolibre.dojos;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	private SpreadSheet sheet;
	
	@Before
	public void setup() {
	}
	
	@Test
	@Ignore
	public void se_solicita_un_aula_para_10_personas_debe_indicar_aula_b() {

		// Listado de aulas:  [{nombre:aula_a, capacidad:5},{nombre:aula_b, capacidad:15}]
		// ...
        // Code here!
        // ... 

		assertThat( result , "aula b");
	}

}
