package com.navtech.dto.models;

public class StudentDetailDTOModel {
	
	private String youtube_channel;
	private String[] hobbies;
	
	/* Default Constructor */
	
	public StudentDetailDTOModel() {
		// TODO Auto-generated constructor stub
	}

	/* Parameterized Constructor */
	
	public StudentDetailDTOModel(String youtube_channel, String[] hobbies) {
		this.youtube_channel = youtube_channel;
		this.hobbies = hobbies;
	}
	
	/* Getter / Setter */
	
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
