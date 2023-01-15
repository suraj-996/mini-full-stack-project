package com.facebook.service;

import java.util.List;

import com.facebook.model.PostDto;

public interface PostService {
	public PostDto savePost(PostDto postDto) throws Exception;

	public List<PostDto> getAllPost();
	
}
