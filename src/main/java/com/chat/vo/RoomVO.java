package com.chat.vo;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class RoomVO {
	private int seq;
	private String room_title;	//방제목
	private String master_id;	//방장아이디
	private String master_name;	//방장명
	private Date date;
	private int totalCount;		//전체 게시물 수
	private int pageSize;		//페이지에 보여줄 게시물 수
	private int totalPage;		//총 페이지 수
	private int currentPage;	//현재 페이지 수
	private int skipCnt;		//스킵건수
	
	public RoomVO() {
		super();
	}
	
	public RoomVO(String room_title, String master_id, String master_name, Date date) {
		super();
		this.room_title = room_title;
		this.master_id = master_id;
		this.master_name = master_name;
		this.date = date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getRoom_title() {
		return room_title;
	}

	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}

	public String getMaster_id() {
		return master_id;
	}

	public void setMaster_id(String master_id) {
		this.master_id = master_id;
	}

	public String getMaster_name() {
		return master_name;
	}

	public void setMaster_name(String master_name) {
		this.master_name = master_name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getSkipCnt() {
		return skipCnt;
	}

	public void setSkipCnt(int skipCnt) {
		this.skipCnt = skipCnt;
	}
	
	
}
