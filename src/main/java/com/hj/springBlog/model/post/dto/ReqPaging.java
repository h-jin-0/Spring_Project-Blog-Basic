package com.hj.springBlog.model.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqPaging {
	private int startLimit;
	private int endLimit;
}
