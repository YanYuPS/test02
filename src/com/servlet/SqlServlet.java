package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SqlServlet
 */
@WebServlet("/SqlServlet")
public class SqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SqlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Allow-Methods", "*");
         response.setHeader("Access-Control-Max-Age", "3600");
         response.setHeader("Access-Control-Allow-Headers", "*");
         response.setHeader("Access-Control-Allow-Credentials", "true");
         
         
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		response.getWriter().append("Served at111: ").append(id).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//        /* ��������������ַ */
//        response.setHeader("Access-Control-Allow-Origin", "*");  
//        /* �����������󷽷�GET, POST, HEAD �� */
//        response.setHeader("Access-Control-Allow-Methods", "*");  
//        /* ����Ԥ�������Ļ���ʱ�� (s) */
//        response.setHeader("Access-Control-Max-Age", "3600");  
//        /* ������������ͷ x-requested-with*/
//        response.setHeader("Access-Control-Allow-Headers", "*");  
//        /* �Ƿ�Я��cookie */
//        response.setHeader("Access-Control-Allow-Credentials", "true");  
        
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
