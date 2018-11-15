package com.engine.templateengine.cars;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
	private int id;
	private String name;

	public String getRandom() {
		return "random as result";
	}
}
