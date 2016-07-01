package com.jordanec.restbootexample.client;

import java.util.LinkedHashMap;

import com.jordanec.restbootexample.util.Constants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TokenApi {
	
	@POST(Constants.GET_TOKEN_PATH)
	Call<LinkedHashMap<String, String>> requestToken();
	
}
