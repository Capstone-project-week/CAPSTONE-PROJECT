package com.example.demo.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Storyviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long story_id;
	private Long user_id;
	private Long Likecount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStory_id() {
		return story_id;
	}
	public void setStory_id(Long story_id) {
		this.story_id = story_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getLikecount() {
		return Likecount;
	}
	public void setLikecount(Long likecount) {
		Likecount = likecount;
	}
	public Storyviews(Long id, Long story_id, Long user_id, Long likecount) {
		super();
		this.id = id;
		this.story_id = story_id;
		this.user_id = user_id;
		Likecount = likecount;
	}
	public Storyviews() {
		super();
		// TODO Auto-generated constructor stub
	}

}
