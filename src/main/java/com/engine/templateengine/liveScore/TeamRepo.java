package com.engine.templateengine.liveScore;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TeamRepo extends CrudRepository<Team, Long> {
	Team getTeamByCity(String city);

	Iterable<Team> getByCountry(String country);

	@Query(value = "SELECT t.name FROM Team t")
	Iterable<String> getTeamNames();

	@Query(value = "SELECT t.name FROM Team t WHERE t.country = :co")
	Iterable<String> getTeamNameByCountry(@Param("co") String co);

	@Query(value = "select t.name, t.teamId from Match m join Team t on m.homeTeam = t.teamId where t.country like :value% order by t.name")
	Iterable<String> extendedORM(@Param("value") String value);

	@Query(value = "select t.name from Team t where country = :value")
	Iterable<String> useNative(@Param("value") String value);

	@Query(value = "select t from Team t where country = :value")
	Iterable<Team> useNative2(@Param("value") String value);

	@Query(value = "select t.name from Match m join Team t on m.home_team_team_id = t.team_id where t.country = :value", nativeQuery = true)
	Iterable<String> useNative3(@Param("value") String value);

	@Query(
			value = "select m.date, m.match_id from Match m join Team t on m.home_team_team_id = t.team_id where t.country like :value% limit 1"
			, nativeQuery = true)
	Iterable<String> extendedNative(@Param("value") String value);

	@Query(value = "select t.name from Match m join Team t on m.home_team_team_id = t.team_id where t.country = ?2 and t.name like ?1%", nativeQuery = true)
	Iterable<String> useNative100(String value1, String value2);

	@Query(value = "select t.name from Match m join Team t on m.homeTeam = t.teamId where t.country = ?2 and t.name like ?1%")
	Iterable<String> useORM100(String value1, String value2);

	@Transactional
	@Modifying
	@Query(value = "update Team t set t.country = :newCountry where t.name = :teamName")
	int setTeamCountry(@Param("teamName") String teamName, @Param("newCountry") String newCountry);

	

// namedQueries

//  also works
//	@Modifying
//	@Query(value = "update Team t set t.country = ?1 where t.name = ?2", nativeQuery = true)
//	int setTeamCountry(String newCountry, String teamName);

}

