package com.hj.springBlog.model.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqUpdateDto {
	private int id;
	private String title;
	private String content;
}
