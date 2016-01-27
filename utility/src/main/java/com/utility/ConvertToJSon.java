package com.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ConvertToJSon {

	public static void main(String[] args) {
		gsonTest();
	}

	public static void gsonTest() {
		Gson gson = new Gson();
		Map<String, Collection<String>> root = new HashMap<>();
		Collection<String> funcs = new ArrayList<>();
		funcs.add("asdadas");
		funcs.add("asd=sddsds");
		funcs.add("asd=sddsds1");
		funcs.add("asd=sddsds,adsyiuasu=1");
		root.put("API", funcs);
		System.out.println(gson.toJson(root));
		
		/*
		 * String json =
		 * "[[\"asdadas\",\"asd\u003dsddsds\",\"asd\u003dsddsds1\",\"asd\u003dsddsds,adsyiuasu\u003d1\"]]"
		 * ; Type collectionType = new
		 * TypeToken<Collection<Collection<String>>>() { }.getType();
		 * Collection<Collection<String>> con = gson.fromJson(json,
		 * collectionType); System.out.println(con);
		 */
	}

}
