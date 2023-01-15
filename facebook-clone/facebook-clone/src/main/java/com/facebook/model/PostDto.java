package com.facebook.model;



import lombok.Data;

@Data
public class PostDto {
	private String id;
	private String post;
	private String name;
	private String email;
	private String image;
	private String profilePic;
	private String timeStamp;
	private String file;
}
