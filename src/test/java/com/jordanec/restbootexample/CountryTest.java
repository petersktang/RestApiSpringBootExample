package com.jordanec.restbootexample;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import com.jordanec.restbootexample.client.CountryApi;
import com.jordanec.restbootexample.client.ServiceGenerator;
import com.jordanec.restbootexample.model.Confederation;
import com.jordanec.restbootexample.model.Team;
import com.jordanec.restbootexample.model.Player;
import com.jordanec.restbootexample.model.Country;
import com.jordanec.restbootexample.model.Status;
import retrofit2.Call;

public class CountryTest {
	private CountryApi countryApi;
	private static CountryTest countryTest;
	private LinkedHashMap<String, String> tokens;

	protected CountryTest() {
	}

	public static CountryTest getInstance(LinkedHashMap<String, String> tokens) {
		if (countryTest == null) {
			countryTest = new CountryTest();
			countryTest.setTokens(tokens);
			countryTest.createCountryApi();
		}
		return countryTest;
	}

	public Country countryReadTest(int idCountry) {
		// System.out.println("\n\ncountryReadTest...\n\n");
		Call<Country> call = countryApi.readCountry(idCountry);

		try {
			retrofit2.Response<Country> response = call.execute();
			if (response.isSuccessful()) {
				Country country = response.body();
				System.out.println("idCountry: " + country.getIdCountry() + " name:" + country.getName());
				return country;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean countryCreateTest(String name, int positionRankingFifa, int idConfederation) {
		System.out.println("\n\ncountryCreateTest...\n\n");
		Confederation confederation = ConfederationTest.getInstance().confederationReadTest(idConfederation);
		Country country = new Country(confederation, name, positionRankingFifa);

		Call<Status> call = countryApi.createCountry(country);

		try {
			retrofit2.Response<Status> response = call.execute();
			if (response.isSuccessful()) {
				Status status = response.body();
				System.out.println("status.getCode()=" + status.getCode() + country.getName() + "\nstatus.getMessage()="
						+ status.getMessage());
				return true;
			}
			System.out.println("response.message()=" + response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean countryUpdateTest(int idCountry) {
		System.out.println("\n\ncountryUpdateTest...\n\n");
		Country country = countryReadTest(idCountry);
		country.setName(country.getName() + "_Updated");

		Call<Status> call = countryApi.updateCountry(country, idCountry);

		try {
			retrofit2.Response<Status> response = call.execute();
			if (response.isSuccessful()) {
				Status status = response.body();
				System.out.println("status.getCode()=" + status.getCode() + country.getName() + "\nstatus.getMessage()="
						+ status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean countryDeleteTest(int idCountry) {
		System.out.println("\n\ncountryDeleteTest...\n\n");
		Call<Status> call = countryApi.deleteCountry(idCountry);

		try {
			retrofit2.Response<Status> response = call.execute();
			if (response.isSuccessful()) {
				Status status = response.body();
				System.out.println("status.getCode()=" + status.getCode() + "idCountry: " + idCountry
						+ "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean countryListTest() {
		System.out.println("\n\ncountryListTest...\n\n");
		Call<Collection<Country>> call = countryApi.listCountries();

		try {
			retrofit2.Response<Collection<Country>> response = call.execute();
			if (response.isSuccessful()) {
				Collection<Country> countries = response.body();
				Iterator<Country> iterator = countries.iterator();
				Country country;
				while (iterator.hasNext()) {
					country = iterator.next();
					System.out.println("idCountry" + country.getIdCountry() + " name:" + country.getName());
				}

				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean countryFindByNameTest(String name) {
		System.out.println("\n\nFindByNameTest...\n\n");
		Call<Country> call = countryApi.findByName(name);

		try {
			retrofit2.Response<Country> response = call.execute();
			if (response.isSuccessful()) {
				Country country = response.body();
				System.out.println("idCountry: " + country.getIdCountry() + " name:" + country.getName());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Collection<Team> countryTeamsReadTest(int idCountry) {
		System.out.println("\n\ncountryTeamsReadTest...\n\n");
		Call<Collection<Team>> call = countryApi.readCountryTeams(idCountry);

		try {
			retrofit2.Response<Collection<Team>> response = call.execute();
			if (response.isSuccessful()) {
				Collection<Team> countryTeams = response.body();
				System.out.println("idCountry: " + idCountry);

				Iterator<Team> iterator = countryTeams.iterator();
				Team team;
				while (iterator.hasNext()) {
					team = iterator.next();
					System.out.println("idTeam: " + team.getIdTeam() + " name:" + team.getName());
				}

				return countryTeams;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Collection<Player> countryPlayersReadTest(int idCountry) {
		System.out.println("\n\ncountryPlayersReadTest...\n\n");
		Call<Collection<Player>> call = countryApi.readCountryPlayers(idCountry);

		try {
			retrofit2.Response<Collection<Player>> response = call.execute();
			if (response.isSuccessful()) {
				Collection<Player> countryPlayers = response.body();
				System.out.println("idCountry: " + idCountry);

				Iterator<Player> iterator = countryPlayers.iterator();
				Player player;
				while (iterator.hasNext()) {
					player = iterator.next();
					System.out.println("idPlayer: " + player.getIdPlayer() + " name:" + player.getName());
				}

				return countryPlayers;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Confederation countryConfederationReadTest(int idCountry) {
		System.out.println("\n\ncountryConfederationReadTest...\n\n");
		Call<Confederation> call = countryApi.readCountryConfederation(idCountry);

		try {
			retrofit2.Response<Confederation> response = call.execute();
			if (response.isSuccessful()) {
				Confederation countryConfederation = response.body();
				System.out.println("idConfederation: " + countryConfederation.getIdConfederation() + " name:"
						+ countryConfederation.getName());
				return countryConfederation;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean doAllTests() {
		if (countryCreateTest("New Zealand", 151, 5) && 
			countryReadTest(1) != null && countryUpdateTest(48)	&& 
			countryListTest() && 
			countryFindByNameTest("New Zealand_Updated") && 
			countryDeleteTest(48) && 
			countryTeamsReadTest(1) != null && 
			countryPlayersReadTest(1) != null && 
			countryConfederationReadTest(1) != null) {
			System.out.println("country tests successful! ");
			return true;
		} else {
			System.out.println("Error in country tests");
			return false;
		}
	}

	public void createCountryApi() {
		countryTest.countryApi = ServiceGenerator.createService(CountryApi.class, getTokens());
	}

	public LinkedHashMap<String, String> getTokens() {
		return countryTest.tokens;
	}

	public void setTokens(LinkedHashMap<String, String> tokens) {
		countryTest.tokens = tokens;
	}
}