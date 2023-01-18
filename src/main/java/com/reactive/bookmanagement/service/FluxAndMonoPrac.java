package com.reactive.bookmanagement.service;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
//subscibe --> request --> onNext --> onNext --> onComplete
public class FluxAndMonoPrac {
	
	public Flux<String> fluxFruits()
	{
		return Flux.fromIterable(List.of("Mango","Apple"));
		
	}
	public Flux<String> fluxFruitsMap()
	{
		return Flux.fromIterable(List.of("Mango","Apple"))
				.map(String :: toUpperCase);
		
	}
	public Flux<String> fluxFilter(int number)
	{
		return Flux.fromIterable(List.of("Mango","Apple"))
				.filter(s -> s.length() > number ) ;
	}
	
	public Flux<String> fluxAndMap(int number)
	{
		return Flux.fromIterable(List.of("Mango","Apple")).map(String:: toUpperCase).filter(s -> s.length() > number);
		
	}
	//flatMap --> each element -->flux of 1 to N --> Mango can convert to each and single element as M A N G O 
	//data will be converted to flux seperately 
	//asynchronous one 
	public Flux<String> flatMapFruits()
	{
		return Flux.fromIterable(List.of("Mango","Apple", "Orange")).flatMap(s -> Flux.just(s.split("")));
	}
	
	public Flux<String> concatMapFruits()
	{
		return Flux.fromIterable(List.of("Mango","Apple", "Orange")).concatMap(s -> Flux.just(s.split("")));
	}
	
	
	public Mono<String> monoFruits()
	{
		return Mono.just("Mango");
	}
	// As mono stores single object --> so we can store mono of mono objects we need to pass a List
	public Mono<List<String>> monoFlatMap()
	{
		return Mono.just("Mango").flatMap(s -> Mono.just(List.of(s.split(""))));
	}
	public Flux<String> manyFlatMap()
	{
		return Mono.just("Mango").flatMapMany(s -> Flux.just(s.split("")));
	}
	
 public static void main(String[] args)
 {
	 FluxAndMonoPrac fluxAndMonoPrac = new FluxAndMonoPrac();
	 
	 fluxAndMonoPrac.fluxFruits().subscribe(s -> {System.out.println("s ="+ s );
	 
	 });
	 
	 fluxAndMonoPrac.monoFruits().subscribe(s->{ System.out.println("s ="+ s);
	 });
	 
 }
}
