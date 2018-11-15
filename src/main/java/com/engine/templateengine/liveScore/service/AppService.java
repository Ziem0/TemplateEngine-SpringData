package com.engine.templateengine.liveScore.service;

import com.engine.templateengine.liveScore.Match;
import com.engine.templateengine.liveScore.MatchRepo;
import com.engine.templateengine.liveScore.Team;
import com.engine.templateengine.liveScore.TeamRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@Slf4j
public class AppService {

	private final TeamRepo teamRepo;
	private final MatchRepo matchRepo;

	@Autowired
	public AppService(TeamRepo teamRepo, MatchRepo matchRepo) {
		this.teamRepo = teamRepo;
		this.matchRepo = matchRepo;
	}

	public Iterable<Match> getMatches() {
		return matchRepo.findAll();
	}

	public Iterable<Team> getTeams() {
		return teamRepo.findAll();
	}

	public Iterable<Team> getTeamsWithPrefix(String prefix) {
		Predicate<Team> check = team -> team.getName().startsWith(prefix);
		List<Team> teamsWithPrefix = new ArrayList<>();

		this.getTeams().forEach(team -> {
			if (check.test(team)) {
				teamsWithPrefix.add(team);
			}
		});

		return teamsWithPrefix;
	}

	public Team getTeamByCity(String city) {
		return teamRepo.getTeamByCity(city);
	}

	public Iterable<Team> getTeamsByCountry(String country) {
		return teamRepo.getByCountry(country);
	}

	public Iterable<String> getTeamNames() {
		return teamRepo.getTeamNames();
	}

	public Iterable<String> getTeamNameByCountry(String co) {
		return teamRepo.getTeamNameByCountry(co);
	}

	public Iterable<String> useNative(String value) {
		return teamRepo.useNative(value);
	}

	public Iterable<Team> useNative2(String value) {
		return teamRepo.useNative2(value);
	}

	public Iterable<String> useNative3(String value) {
		return teamRepo.useNative3(value);
	}

	public Iterable<String> extendedNative(String value) {
		return teamRepo.extendedNative(value);
	}

	public Iterable<String> native100(String value1, String value2) {
		return teamRepo.useNative100(value1, value2);
	}

	public Iterable<String> extendedORM(String value) {
		return teamRepo.extendedORM(value);
	}

	public Iterable<String> useORM100(String value1, String value2) {
		return teamRepo.useORM100(value1, value2);
	}

	public int setTeamCountry(String teamName, String newCountry) {
		return teamRepo.setTeamCountry(teamName, newCountry);
	}



}
