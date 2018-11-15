package com.engine.templateengine.liveScore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long teamId;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private String city;

	protected Team() {
	}

	public Team(String name, String country, String city) {
		this.name = name;
		this.country = country;
		this.city = city;
	}

	@Override
	public String toString() {
		return String.format("id:%d name:%s country:%s city:%s", teamId, name, country, city);
	}
}

