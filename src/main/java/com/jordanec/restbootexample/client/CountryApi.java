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

public interface CountryApi {
	public static final String MAIN_PATH = "/"+Constants.API_VERSION+"/"+Constants.COUNTRIES_PATH;
	
	@POST(MAIN_PATH)
	Call<Status> createCountry(@Body Country country);
	
	@GET(MAIN_PATH+"/{idCountry}")
	Call<Country> readCountry(@Path("idCountry") int idCountry);
	
	@GET(MAIN_PATH+"/"+Constants.NAME_VARIABLE+"={"+Constants.NAME_VARIABLE+"}")
	Call<Country> findByName(@Path(Constants.NAME_VARIABLE) String name);
	
	@PUT(MAIN_PATH+"/{idCountry}")
	Call<Status> updateCountry(@Body Country country, @Path("idCountry") int idCountry);
	
	@DELETE(MAIN_PATH+"/{idCountry}")
	Call<Status> deleteCountry(@Path("idCountry") int idCountry);
	
	@GET(MAIN_PATH)
	Call<Collection<Country>> listCountries();
	
	@GET(MAIN_PATH+"/{idCountry}/"+Constants.TEAMS_PATH)
	Call<Collection<Team>> readCountryTeams(@Path("idCountry") int idCountry);
	
	@GET(MAIN_PATH+"/{idCountry}/"+Constants.PLAYERS_PATH)
	Call<Collection<Player>> readCountryPlayers(@Path("idCountry") int idCountry);
	
	@GET(MAIN_PATH+"/{idCountry}/"+Constants.CONFEDERATION_PATH)
	Call<Confederation> readCountryConfederation(@Path("idCountry") int idCountry);
	
	
	
}
