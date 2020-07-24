package com.tzxy.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.tzxy.dao.sendDao;
import com.tzxy.domain.PageBean;
import com.tzxy.domain.Send;

public class forumService {

	public PageBean getPageBean(int currentPage) throws SQLException{
		PageBean pageBean = new PageBean();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		//��ȡ�ж�������¼
		//�����ݿ⵱�в�ѯ
		sendDao sendDao = new sendDao();
		Long count=sendDao.getCount();
		pageBean.setTotalCount(count.intValue());
		//һҳչʾ����������
		Integer pageCount=5; //15/5=3   16/5=3  1 ����ȡ��
		//��ҳ��
		 double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageCount);//3.1=4
		pageBean.setTotalPage((int )totalPage);
		//��ǰҳ��ѯ�ĽǱ�pageBean.getTotalCount()
		Integer index=(pageBean.getCurrentPage()-1)*pageCount;
		 List<Send> list = sendDao.getPageData(index,pageCount);
		
		pageBean.setSendsList(list);
		return pageBean;
	}

}
