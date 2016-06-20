package com.cool.stay.server.dto;

public class GamesBooking {
	private String id;
	private String gamesId;
	private String userId;
	private String slotId;
	private String updateDate;
	private String description;
	private String username;
	private String saved;

	public GamesBooking(String id, String gamesId, String userId, String slotId, String updateDate, String description,
			String username, String saved) {
		this.id = id;
		this.gamesId = gamesId;
		this.userId = userId;
		this.slotId = slotId;
		this.updateDate = updateDate;
		this.description = description;
		this.username = username;
		this.saved = saved;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGamesId() {
		return gamesId;
	}

	public void setGamesId(String gamesId) {
		this.gamesId = gamesId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSaved() {
		return saved;
	}

	public void setSaved(String saved) {
		this.saved = saved;
	}

}
