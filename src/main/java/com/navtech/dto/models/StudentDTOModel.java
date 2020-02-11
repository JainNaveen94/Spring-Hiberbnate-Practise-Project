package com.navtech.dto.models;

public class StudentDTOModel {
	
	private String username;
	private String password;
	private String email;
	private String youtube_channel;
	private String[] hobbies;
	
	/* Default Constructor */
	
	public StudentDTOModel() {
		// TODO Auto-generated constructor stub
	}
	
	/* Getter / Setter */

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	
	
}
