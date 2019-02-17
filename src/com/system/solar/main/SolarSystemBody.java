package com.system.solar.main;

import java.util.HashSet;
import java.util.Set;

public class SolarSystemBody {

	private final String bodyName;
	private final double distance;
	private final Set<SolarSystemBody> satellites;

	public SolarSystemBody(String bodyName, double distance) {
		this.bodyName = bodyName;
		this.distance = distance;
		this.satellites = new HashSet<>();
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		// Debug Purpose
		// System.out.println("obj.getClass() is " + obj.getClass());
		// System.out.println("this.getClass() is " + this.getClass());
		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		String objName = ((SolarSystemBody) obj).getBodyName();
		return this.bodyName.equals(objName);
	}

	@Override
	public int hashCode() {
		// Debug Purpose
		// System.out.println("hashcode was called");
		return this.bodyName.hashCode() + 8;
	}

}
