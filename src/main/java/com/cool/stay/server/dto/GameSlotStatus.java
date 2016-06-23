package com.cool.stay.server.dto;

public class GameSlotStatus {
	private int slotId;
	private String intreval;
	
	public GameSlotStatus(int slotId, String intreval){	
		this.slotId=slotId;
		this.intreval=intreval;
	}
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public String getIntreval() {
		return intreval;
	}
	public void setIntreval(String intreval) {
		this.intreval = intreval;
	}

}
