package com.engine.templateengine.liveScore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Getter
@Setter
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long matchId;
	@Temporal(value = TemporalType.DATE)
	private Date date;
	@OneToOne
	private Team homeTeam;
	@OneToOne
	private Team awayTeam;
	@Column(nullable = false)
	private int goalsHome;
	@Column(nullable = false)
	private int goalsAway;

	protected Match() {
	}

	public Match(Team homeTeam, Team awayTeam, int goalsHome, int goalsAway) {
		this.date = Date.from(Instant.now());
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.goalsHome = goalsHome;
		this.goalsAway = goalsAway;
	}

	@Override
	public String toString() {
		return String.format("id:%d date:%s home:%s %d %d away:%s ", matchId, date, homeTeam.getName(), goalsHome, goalsAway, awayTeam.getName());
	}


}
