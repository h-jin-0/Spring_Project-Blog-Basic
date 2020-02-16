package com.hj.springBlog.model.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Criteria {
	private int page;
	private int perPageNum;

	public void setPage(int page) {
		if(page<=0) {
			this.page=1;
			return;
		}
		this.page=page;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0||perPageNum>100) {
			this.perPageNum=10;
			return;
		}
		this.perPageNum=perPageNum;
	}
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}

}
