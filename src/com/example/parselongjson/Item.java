package com.example.parselongjson;

import java.util.ArrayList;

public class Item {
	
	private ArrayList<Attachment> attachments = new ArrayList<Attachment>(); // you can also do array list of comment, likes and reposts if needed.

	// believe me its better to have all elements of same type String. even if you have integers.
	private String comments_count;
	private String date;
	private String from_id;
	private String id;
	private String likes_count;
	private String owner_id;
	private String post_type;
	private String reposts_count;
	private String text;
	
	public ArrayList<Attachment> getAttachments() {
		return attachments;
	}
	
	public void setAttachments(ArrayList<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	public String getComments_count() {
		return comments_count;
	}
	
	public void setComments_count(String comments_count) {
		this.comments_count = comments_count;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getFrom_id() {
		return from_id;
	}

	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLikes_count() {
		return likes_count;
	}

	public void setLikes_count(String likes_count) {
		this.likes_count = likes_count;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getPost_type() {
		return post_type;
	}

	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}

	public String getReposts_count() {
		return reposts_count;
	}

	public void setReposts_count(String reposts_count) {
		this.reposts_count = reposts_count;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
