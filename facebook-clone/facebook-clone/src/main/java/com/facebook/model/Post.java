package com.facebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Post {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid",strategy = "uuid2")
	private String id;
	
	@Lob
	private String post;
	private String name;
	private String email;
	@Lob
	private String image;
	private String profilePic;
	private String timeStamp;
	
	
}
