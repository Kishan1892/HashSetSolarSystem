package com.system.solar.main;

import java.util.HashSet;
import java.util.Set;

public class SolarSystemBody {

	private final String bodyName;
	private final double distance;
	private final String type;
	private final Set<SolarSystemBody> satellites;

	public SolarSystemBody(String bodyName, String type, double distance) {
		this.bodyName = bodyName;
		this.type = type;
		this.distance = distance;
		this.satellites = new HashSet<>();
	}

	public String getType() {
		return type;
	}

	public String getBodyName() {
		return bodyName;
	}

	public double getDistance() {
		return distance;
	}

	public Set<SolarSystemBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}

	public boolean addBody(SolarSystemBody body) {
		return this.satellites.add(body);
	}

}
