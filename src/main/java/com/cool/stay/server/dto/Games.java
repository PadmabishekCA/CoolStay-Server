package com.cool.stay.server.dto;

import java.util.Map;

public class Games {
	private String id;
	private String description;
	private String numOfPlayers;
	private String image;
	private String names;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public Games(String id, String description, String numOfPlayers, String image) {
		this.id = id;
		this.description = description;
		this.numOfPlayers = numOfPlayers;
		this.image = image;
	}
	
	public Games(String id, String names, String description) {
		this.id = id;
		this.names=names;
		//System.out.println(this.names);
		this.description=description;
	}
	
	public Games(String id){
		this.id=id;
	}
	
	public Games(Map createGame){
		this.names=createGame.get("gameName").toString();
		this.description=createGame.get("gameDesc").toString();
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(String numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
