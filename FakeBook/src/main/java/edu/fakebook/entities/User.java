package edu.fakebook.entities;

import java.util.List;

public class User {
	private int userId;
	private String userName;
	private String name;
	private String phoneNo;
	private String password;
	private String dateOfBirth;
	private String status;
	private String bio;
	private String studiedAt;
	private String imagePath;
	private List<Post> posts;
	private String friendshipStatus;
	
	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getStudiedAt() {
		return studiedAt;
	}

	public void setStudiedAt(String studiedAt) {
		this.studiedAt = studiedAt;	
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getFriendshipStatus() {
		return friendshipStatus;
	}

	public void setFriendshipStatus(String friendshipStatus) {
		this.friendshipStatus = friendshipStatus;
	}
	
	

}
