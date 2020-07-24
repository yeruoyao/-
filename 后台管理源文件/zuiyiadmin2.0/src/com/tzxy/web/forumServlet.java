package com.tzxy.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tzxy.domain.PageBean;
import com.tzxy.domain.PingLun;
import com.tzxy.domain.Send;
import com.tzxy.domain.SendPing;
import com.tzxy.service.forumService;
import com.tzxy.service.sendService;

@WebServlet("/forumServlet")
public class forumServlet extends BaseServlet {
	public String getPageData(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{

        try {
            //��ȡ��ǰҳ��
            String currentPage = request.getParameter("currentPage");
            //2.��ҳ���ҵ��㣬����ҳ�����һ��pageBean
             forumService forumService = new forumService();
            PageBean pageBean= null;
            pageBean = forumService.getPageBean(Integer.parseInt(currentPage));
            //3.��pageBeanд������
            request.setAttribute("pageBean",pageBean);
            //4.ת��
            return  "forum/index.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }
	
	public String PlText(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{

		String tid1 = request.getParameter("tid");
		int tid=Integer.valueOf(tid1);
		sendService sendService = new sendService();
		try {
			int sum = sendService.getSum(tid);
			boolean flag = sendService.updateSum(tid,sum);
			if(flag) {
				Send findSend = sendService.findSend(tid);
				List<PingLun> findALLP = sendService.findALLP(tid);
				Collections.reverse(findALLP);
				SendPing sendPing = new SendPing();
				sendPing.setSend(findSend);
				sendPing.setList(findALLP);
				request.setAttribute("sendPing", sendPing);
				return "forum/pltext.jsp";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}
