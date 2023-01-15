package com.facebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facebook.model.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, String>{

}
