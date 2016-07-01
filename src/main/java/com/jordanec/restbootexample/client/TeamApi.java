package com.jordanec.restbootexample.client;

import java.util.Collection;

import com.jordanec.restbootexample.model.*;
import com.jordanec.restbootexample.util.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.DELETE;

public interface TeamApi {
	public static final String MAIN_PATH = "/"+Constants.API_VERSION+"/"+Constants.TEAMS_PATH;
	
	@POST(MAIN_PATH)
	Call<Status> createTeam(@Body Team team);
	
	@GET(MAIN_PATH+"/{idTeam}")
	Call<Team> readTeam(@Path("idTeam") int idTeam);
	
	@GET(MAIN_PATH+"/"+Constants.NAME_VARIABLE+"={"+Constants.NAME_VARIABLE+"}")
	Call<Team> findByName(@Path(Constants.NAME_VARIABLE) String name);
	
	@PUT(MAIN_PATH+"/{idTeam}")
	Call<Status> updateTeam(@Body Team team, @Path("idTeam") int idTeam);
	
	@DELETE(MAIN_PATH+"/{idTeam}")
	Call<Status> deleteTeam(@Path("idTeam") int idTeam);
	
	@GET(MAIN_PATH)
	Call<Collection<Team>> listTeams();
	
	@GET(MAIN_PATH+"/{idTeam}/"+Constants.STADIUMS_PATH)
	Call<Collection<Stadium>> readTeamStadiums(@Path("idTeam") int idTeam);
	
	@GET(MAIN_PATH+"/{idTeam}/"+Constants.PLAYERS_PATH)
	Call<Collection<Player>> readTeamPlayers(@Path("idTeam") int idTeam);
	
	@GET(MAIN_PATH+"/{idTeam}/"+Constants.COUNTRIES_PATH)
	Call<Country> readTeamCountry(@Path("idTeam") int idTeam);
	
	@GET(MAIN_PATH+"/{idTeam}/"+Constants.CONFEDERATIONS_PATH)
	Call<Collection<Confederation>> readTeamConfederations(@Path("idTeam") int idTeam);
	
}
