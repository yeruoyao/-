package com.tzxy.domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	  //��ǰ����һҳ
    private Integer currentPage;
    //������ҳ
    private Integer totalPage;
    //��������¼
    private  Integer totalCount;
    //��ǰҳ��Ʒ
    private List<Send> sendsList=new ArrayList<Send>();
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<Send> getSendsList() {
		return sendsList;
	}
	public void setSendsList(List<Send> sendsList) {
		this.sendsList = sendsList;
	}
	
}
