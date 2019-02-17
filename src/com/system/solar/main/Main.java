package com.system.solar.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	private final static Map<String, SolarSystemBody> solarSystem = new HashMap<>();
	private final static Set<SolarSystemBody> planets = new HashSet<>();

	public static void main(String[] args) {

		// Added a Dummy Owner
		SolarSystemBody temp = new SolarSystemBody("Kishan", 45);
		solarSystem.put(temp.getBodyName(), temp);

		// Adding Values : Usually stored in database
		temp = new SolarSystemBody("Earth", 30);
		solarSystem.put(temp.getBodyName(), temp);
		planets.add(temp);

		SolarSystemBody tempMoon = new SolarSystemBody("Moon", 34);
		solarSystem.put(tempMoon.getBodyName(), tempMoon);
		temp.addBody(tempMoon);

		temp = new SolarSystemBody("Mars", 46);
		solarSystem.put(temp.getBodyName(), temp);
		planets.add(temp);

		tempMoon = new SolarSystemBody("Phobos", 48);
		solarSystem.put(tempMoon.getBodyName(), tempMoon);
		temp.addBody(tempMoon);

		tempMoon = new SolarSystemBody("Deimos", 49);
		solarSystem.put(tempMoon.getBodyName(), tempMoon);
		temp.addBody(tempMoon);

		// Print all Planets
		System.out.println("All Planets:");
		for (SolarSystemBody planet : planets) {
			System.out.println("\t" + planet.getBodyName());
		}

		// Print all Satellites : Way 1
		System.out.println("-------------------");
		System.out.println("All Satellites : Way 1");
		for (SolarSystemBody planet : planets) {
			Set<SolarSystemBody> satellites = planet.getSatellites();
			for (SolarSystemBody satellite : satellites) {
				System.out.println("\t" + satellite.getBodyName());
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
			System.out.println("\t" + satellite.getBodyName());
		}

		// Print Satellites of Mars
		SolarSystemBody mars = solarSystem.get("Mars");
		System.out.println("-------------------");
		System.out.println("Satellites of " + mars.getBodyName() + ":");
		for (SolarSystemBody marsSatellite : mars.getSatellites()) {
			System.out.println("\t" + marsSatellite.getBodyName());
		}

		// My Name
		SolarSystemBody kishan = solarSystem.get("Kishan");
		System.out.println("-------------------");
		System.out.println("Prepared by: " + kishan.getBodyName());

		// This Object is not added as .equals and hashcode are implemented
		temp = new SolarSystemBody("Mars", 46);
		solarSystem.put(temp.getBodyName(), temp);
		planets.add(temp);

	}

}
