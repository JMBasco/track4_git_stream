package org.ssglobal.training.codes;

public class ScoreInfo {
	private String firstname;
	private String lastname;
	private int score;
	
	public ScoreInfo(String lname, String fname, int s) {
		firstname = fname;
		lastname = lname;
		score = s;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getScore() {
		return score;
	}	
		
}
