package com.systemsinmotion.petfinder.api;

public class API {
	private static String KEY = "key=36e256001ab1dd0de1be38ee95827f7d";
	private static String URL = "http://api.petfinder.com/";
	
	public static final String GET_RANDOM = URL + APIMethod.GET_RANDOM + KEY;
	public static final String BREED_LIST = URL + APIMethod.BREED_LIST + KEY;
	public static final String GET = URL + APIMethod.GET + KEY;
	public static final String FIND = URL + APIMethod.FIND + KEY;
}
