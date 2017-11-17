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
	public void setup() {}
	
	@Test
	public void should_get_fat_whether_it_eats_biscuits() {
		Packman packman  = new Packman();
		Biscuit biscuit = new Biscuit() ;

		Weight packmanInitialWeight = packman.getWeight();

		packman.eat( biscuit );

		Assert.assertTrue( packman.isFatterThan( packmanInitialWeight ) );
	}

	@Test
	public void should_get_double_fat_whether_it_eats_cherry() {
		Packman packman  = new Packman();
		Cherry cherry = new Cherry();
		Weight packmanInitialWeight = packman.getWeight();

		packman.eat( cherry );

		Assert.assertTrue( packman.isDoubleThan( packmanInitialWeight ));
	}

	@Test
	public void should_not_eat_and_is_not_double_than() {
		Packman packman  = new Packman();
		Weight packmanWeight = packman.getWeight();
		Assert.assertFalse( packman.isDoubleThan( packmanWeight ));
	}

}
