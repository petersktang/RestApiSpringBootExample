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

public interface PlayerApi {
	public static final String MAIN_PATH = "/"+Constants.API_VERSION+"/"+Constants.PLAYERS_PATH;
	
	@POST(MAIN_PATH)
	Call<Status> createPlayer(@Body Player player);
	
	@GET(MAIN_PATH+"/{idPlayer}")
	Call<Player> readPlayer(@Path("idPlayer") int idPlayer);
	
	@GET(MAIN_PATH+"/"+Constants.NAME_VARIABLE+"={"+Constants.NAME_VARIABLE+"}")
	Call<Player> findByName(@Path(Constants.NAME_VARIABLE) String name);
	
	@PUT(MAIN_PATH+"/{idPlayer}")
	Call<Status> updatePlayer(@Body Player player, @Path("idPlayer") int idPlayer);
	
	@DELETE(MAIN_PATH+"/{idPlayer}")
	Call<Status> deletePlayer(@Path("idPlayer") int idPlayer);
	
	@GET(MAIN_PATH)
	Call<Collection<Player>> listPlayers();
	
	@GET(MAIN_PATH+"/{idPlayer}/"+Constants.PLAYER_PATH)
	Call<Team> readPlayerTeam(@Path("idPlayer") int idPlayer);
	
	@GET(MAIN_PATH+"/{idPlayer}/"+Constants.COUNTRY_PATH)
	Call<Country> readPlayerCountry(@Path("idPlayer") int idPlayer);
	
	@GET(MAIN_PATH+"/{idPlayer}/"+Constants.SPONSOR_PATH)
	Call<Sponsor> readPlayerSponsor(@Path("idPlayer") int idPlayer);
	
	
	
	
}
