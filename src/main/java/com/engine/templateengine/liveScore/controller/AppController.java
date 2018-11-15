package com.engine.templateengine.liveScore.controller;

import com.engine.templateengine.liveScore.Team;
import com.engine.templateengine.liveScore.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AppController {

	private final AppService service;

	@Autowired
	public AppController(AppService service) {
		this.service = service;
	}

	@GetMapping("/ok")
	public String getOk() {
		return "ok";
	}

	@GetMapping("/getAll")
	public Iterable<Team> getAll() {
		return service.getTeams();
	}

	@GetMapping("/getAlls")
	public String getAlls() {
		StringBuilder stringBuilder = new StringBuilder();
		service.getTeams().forEach(team -> stringBuilder.append("<h5>").append(team.toString()).append("</h5>"));
		service.getMatches().forEach(match -> stringBuilder.append("<h5>").append(match.toString()).append("</h5>"));
		return stringBuilder.toString();
	}

	@GetMapping("/withPre/{prefix}")
	public Iterable<Team> getTeamsWith(@PathVariable String prefix) {
		return service.getTeamsWithPrefix(prefix);
	}

	@GetMapping("/withCity/{city}")
	public Team getTeamByCity(@PathVariable String city) {
		return service.getTeamByCity(city);
	}

	@GetMapping("/withCountry/{country}")
	public Iterable<Team> getTeamsByCountry(@PathVariable String country) {
		return service.getTeamsByCountry(country);
	}

	@GetMapping("/allNames")
	public Iterable<String> getAllNames() {
		return service.getTeamNames();
	}

	@GetMapping("/teamNameBy/{co}")
	public Iterable<String> getTeamNameByCountry(@PathVariable String co) {
		return service.getTeamNameByCountry(co);
	}

	@GetMapping("/native/{value}")
	public Iterable<String> useNativeQuery(@PathVariable String value) {
		return service.useNative(value);
	}

	@GetMapping("/native2/{value}")
	public Iterable<Team> useNativeQuery2(@PathVariable String value) {
		return service.useNative2(value);
	}

	@GetMapping("/native3/{value}")
	public Iterable<String> useNativeQuery3(@PathVariable String value) {
		return service.useNative3(value);
	}

	@GetMapping("/native4/{value}")
	public Iterable<String> useNativeQuery4(@PathVariable String value) {
		return service.extendedNative(value);
	}

	@GetMapping("/orm/{value}")
	public Iterable<String> extendedORM(@PathVariable String value) {
		return service.extendedORM(value);
	}

	@GetMapping("/native100/{value1}/{value2}")
	public Iterable<String> native100(@PathVariable String value1, @PathVariable String value2) {
		return service.native100(value1, value2);
	}

	@GetMapping("/orm100/{value1}/{value2}")
	public Iterable<String> useORM100(@PathVariable String value1, @PathVariable String value2) {
		return service.useORM100(value1, value2);
	}

	@GetMapping("/newCountry/{teamName}/{country}")
	public int setTeamCountry(@PathVariable String teamName, @PathVariable String country) {
		return service.setTeamCountry(teamName, country);
	}



	// create Queries in  sql dialect
}
