package com.reactive.reactivepractice;

import org.junit.Test;

import com.reactive.bookmanagement.service.FluxAndMonoPrac;

import reactor.test.StepVerifier;

public class FluxAndMonoTest {



	FluxAndMonoPrac fluxAndMonoPrac = new FluxAndMonoPrac();
	
	@Test
	void fluxFruitsTest()
	{
		var fluxFruitsTest = fluxAndMonoPrac.fluxFruits();
		StepVerifier.create(fluxFruitsTest).expectNext("Mango","Apple").verifyComplete();
		
	}
	
	@Test
	void monoFruitsTest()
	{
		var monoFruitsTest = fluxAndMonoPrac.monoFruits();
		StepVerifier.create(monoFruitsTest).expectNext("Mango").verifyComplete();
	}
}

