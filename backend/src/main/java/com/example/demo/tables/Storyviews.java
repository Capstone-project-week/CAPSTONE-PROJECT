package com.example.demo.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Storyviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "story_id")
	private Long storyId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "likecount")
	private Long likeCount;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStoryId() {
		return storyId;
	}
	public void setStoryId(Long storyId) {
		this.storyId = storyId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}
	
	public Storyviews(Long id, Long storyId, Long userId, Long likeCount) {
		super();
		this.id = id;
		this.storyId = storyId;
		this.userId = userId;
		this.likeCount = likeCount;
	}
	
	public Storyviews() {
		super();
	}
}
