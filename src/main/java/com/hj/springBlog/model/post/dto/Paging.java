package com.hj.springBlog.model.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paging {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int displayPageNum = 5;

	private Criteria cri;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();// 페이징 계산하는 메서드
	}

	private void calcData() {
		endPage=(int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);//현재의 엔드페이지(이 블럭의 엔드)
		// cri.getpage : 현재 나의 페이지
		// 현재 페이지를 나누기 (한 블럭당 페이지가 몇개)해서 ex0.2나오면 ceil하면 1이되겠지 그러면 displaypanum하면 엔드
		// 페이지가 구해짐

		startPage=(endPage-displayPageNum)+1;
		int tendPage=(int)(Math.ceil(totalCount)/(double)cri.getPerPageNum());//실제 전체중의 end페이지 구해둔거
		// totalPage
		// 한 페이지당 표시하는 레코드 수로 나눠주면 토탈 페이지 수가 나온다.

		if(endPage>tendPage) endPage=tendPage;
		prev=startPage==1?false:true;
		next=endPage>=tendPage?false:true;
	}
	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

}
