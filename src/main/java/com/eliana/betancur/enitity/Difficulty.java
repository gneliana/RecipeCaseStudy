package com.eliana.betancur.enitity;


public enum Difficulty {
	
	EASY ("EASY", "easy"), 
	MODERATE ("MODERATE", "moderate"), 
	ADVANCED ("ADVANCED", "advanced"), 
	HARD ("HARD", "hard"), 
	CHEF ("CHEF", "chef");
	
	private final String type;
	private final String  name;
	
	Difficulty (String name, String Difficulty) {
		this.name = name;
		this.type = Difficulty;
	}
	
	public String getType() {
		return this.type;
	}
}
