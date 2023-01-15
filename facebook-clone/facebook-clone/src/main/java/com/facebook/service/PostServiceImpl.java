package com.facebook.service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.model.Post;
import com.facebook.model.PostDto;
import com.facebook.repository.PostRepo;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public PostDto savePost(PostDto postDto) throws Exception {
		try {
			Post post=modelMapper.map(postDto, Post.class);
			if(postDto.getFile()!=null && !postDto.getFile().equalsIgnoreCase("null")) {
				post.setImage(postDto.getFile());
			}else {
				post.setImage(null);
			}
			post=postRepo.save(post);
			postDto.setId(post.getId());
			postDto.setFile(null);
			postDto.setImage(post.getImage());
		}catch(Exception e) {
			throw new Exception("could not save post "+e);
		}
		return postDto;
	}
	@Override
	public List<PostDto> getAllPost() {
		List<Post> posts=postRepo.findAll();
		List<PostDto> postDtos=posts.stream().map((p)->modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}
}
