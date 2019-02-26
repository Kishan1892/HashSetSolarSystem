package com.system.solar.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.system.solar.main.SolarSystemBody.Key;

public class Main {

	private final static Map<Key, SolarSystemBody> solarSystem = new HashMap<>();
	private final static Set<SolarSystemBody> planets = new HashSet<>();
	private final static Set<SolarSystemBody> creator = new HashSet<>();

	public static void main(String[] args) {

		// Added a Dummy Owner
		SolarSystemBody kishan = new Planet("Kishan", 45);
		creator.add(kishan);

		// Adding Values : Usually stored in database
		SolarSystemBody temp = new Planet("Earth", 30);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);

		SolarSystemBody tempMoon = new Moon("Moon", 34);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addBody(tempMoon);

		temp = new Planet("Mars", 46);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);

		tempMoon = new Moon("Phobos", 48);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addBody(tempMoon);

		tempMoon = new Moon("Deimos", 49);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addBody(tempMoon);

		// Print all Planets
		System.out.println("All Planets:");
		for (SolarSystemBody planet : planets) {
			System.out.println("\t" + planet);
			// System.out.println("\t" + planet.getKey());
		}

		// Print all Satellites : Way 1
		System.out.println("-------------------");
		System.out.println("All Satellites : Way 1");
		for (SolarSystemBody planet : planets) {
			Set<SolarSystemBody> satellites = planet.getSatellites();
			for (SolarSystemBody satellite : satellites) {
				System.out.println("\t" + satellite);
			}
		}

		// Print all Satellites : Way 2
		Set<SolarSystemBody> satellites = new HashSet<>();
		for (SolarSystemBody planet : planets) {
			satellites.addAll(planet.getSatellites());
		}

		System.out.println("-------------------");
		System.out.println("All Satellites : Way 2");
		for (SolarSystemBody satellite : satellites) {
			System.out.println("\t" + satellite);
		}

		// Print Satellites of Mars
		SolarSystemBody mars = solarSystem.get(SolarSystemBody.makeKey("Mars", SolarSystemBody.BODYTYPE.PLANET));
		System.out.println("-------------------");
		System.out.println("Satellites of " + mars.getKey().getBodyName() + ":");
		for (SolarSystemBody marsSatellite : mars.getSatellites()) {
			System.out.println("\t" + marsSatellite);
		}

		// Print Satellites of Earth
		SolarSystemBody earth = solarSystem.get(SolarSystemBody.makeKey("Earth", SolarSystemBody.BODYTYPE.PLANET));
		System.out.println("-------------------");
		System.out.println("Satellites of " + earth.getKey().getBodyName() + ":");
		for (SolarSystemBody earthSatellite : earth.getSatellites()) {
			System.out.println("\t" + earthSatellite);
		}

		// This Object is not added as .equals and hashcode are implemented
		temp = new Planet("Mars", 46);
		solarSystem.put(temp.getKey(), temp);
		planets.add(temp);

		Set<SolarSystemBody> satellitess = new HashSet<>();
		for (SolarSystemBody planet : planets) {
			satellitess.addAll(planet.getSatellites());
		}

		System.out.println();
		System.out.println("The solar system contains:");
		System.out.println("==========================");
		for (SolarSystemBody body : solarSystem.values()) {
			System.out.println("\t" + body);
		}

		// ME
		System.out.println("-------------------");
		SolarSystemBody myName = creator.stream().findFirst().get();
		System.out.println("Prepared by: " + myName.getKey().getBodyName());

	}

}
