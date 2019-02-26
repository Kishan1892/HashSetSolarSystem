package com.system.solar.main;

public class Planet extends SolarSystemBody {

	public Planet(String bodyName, double distance) {
		super(bodyName, distance, BODYTYPE.PLANET);
	}

	@Override
	public boolean addBody(SolarSystemBody body) {
		if (body.getKey().getBodyType() == BODYTYPE.MOON) {
			return super.addBody(body);
		} else {
			return false;
		}
	}
}
