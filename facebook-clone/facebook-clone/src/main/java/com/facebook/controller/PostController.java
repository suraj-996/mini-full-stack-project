package com.facebook.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.model.PostDto;
import com.facebook.service.PostService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(value = "http://localhost:3000")
public class PostController {
	@Autowired
	private PostService postService;
	
	@PostMapping("/posts")
	public PostDto savePostController(@RequestParam Map<String,String> requestParams) throws Exception {
		String strPost=requestParams.get("post");
		String email=requestParams.get("email");
		String name=requestParams.get("name");
		String file=requestParams.get("file");
		String profilePic=requestParams.get("profilePic");
		PostDto postDto=new PostDto();
		postDto.setFile(file);
		postDto.setName(name);
		postDto.setEmail(email);
		postDto.setPost(strPost);
		postDto.setProfilePic(profilePic);
		postDto.setTimeStamp(new Date().toString());
		postDto=postService.savePost(postDto);
		return postDto;
	}
	
	@GetMapping("/posts")
	public List<PostDto> getAllPostController(){
		return postService.getAllPost();
	}
}
