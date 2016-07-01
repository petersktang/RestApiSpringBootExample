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

public interface SponsorApi {
	public static final String MAIN_PATH = "/"+Constants.API_VERSION+"/"+Constants.SPONSORS_PATH;
	
	@POST(MAIN_PATH)
	Call<Status> createSponsor(@Body Sponsor sponsor);
	
	@GET(MAIN_PATH+"/{idSponsor}")
	Call<Sponsor> readSponsor(@Path("idSponsor") int idSponsor);
	
	@GET(MAIN_PATH+"/"+Constants.NAME_VARIABLE+"={"+Constants.NAME_VARIABLE+"}")
	Call<Sponsor> findByName(@Path(Constants.NAME_VARIABLE) String name);
	
	@PUT(MAIN_PATH+"/{idSponsor}")
	Call<Status> updateSponsor(@Body Sponsor sponsor, @Path("idSponsor") int idSponsor);
	
	@DELETE(MAIN_PATH+"/{idSponsor}")
	Call<Status> deleteSponsor(@Path("idSponsor") int idSponsor);
	
	@GET(MAIN_PATH)
	Call<Collection<Sponsor>> listSponsors();
	
	@GET(MAIN_PATH+"/{idSponsor}/"+Constants.TEAMS_PATH)
	Call<Collection<Team>> readSponsorTeams(@Path("idSponsor") int idSponsor);
	
	@GET(MAIN_PATH+"/{idSponsor}/"+Constants.PLAYERS_PATH)
	Call<Collection<Sponsor>> readSponsorPlayers(@Path("idSponsor") int idSponsor);
}
