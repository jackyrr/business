package com.zft.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<E> implements Serializable{
	
	private List<E> data;
	
	private int totalPage;
	
	public PageModel(){
		
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
	
	
}
