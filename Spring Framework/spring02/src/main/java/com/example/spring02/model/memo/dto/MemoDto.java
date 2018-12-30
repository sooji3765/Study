package com.example.spring02.model.memo.dto;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class MemoDto {
	private int idx;
	private String writer;
	private String memo;
	private Date post_date;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	@Override
	public String toString() {
		return "MemoDto [idx=" + idx + ", writer=" + writer + ", memo=" + memo + ", post_date=" + post_date + "]";
	}
	
	public MemoDto() {
		
	}
	public MemoDto(String writer, String memo) {
		
		this.writer = writer;
		this.memo = memo;
	}
	
	
	
	
	
	
	
}

