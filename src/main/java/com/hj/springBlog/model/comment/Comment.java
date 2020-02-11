package com.hj.springBlog.model.comment;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comment {
	private int id;
	private int userId;
	private int postId;
	private String content;
	private Timestamp createDate;
	
	@Builder
	public Comment(int userId, int postId, String content) {
		this.userId = userId;
		this.postId = postId;
		this.content = content;
	}

	
}
