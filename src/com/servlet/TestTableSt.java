package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.TableCaseSer;
import com.service.TableDepSer;
import com.service.TablePeoSer;

/**
 * Servlet implementation class TestTableSt
 */
@WebServlet("/TestTableSt")
public class TestTableSt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestTableSt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*"); 
        response.setHeader("Access-Control-Allow-Methods", "*");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");  
        response.setContentType("text/html;charset=utf-8");
        
        String name=request.getParameter("name");
        System.out.println(name);
        
        String r="";
        if("处罚案件".equals(name.subSequence(0, 4)) ) {
        	TableCaseSer table=new TableCaseSer();
        	r=table.txtRe2();
        }else if("执法人员".equals(name.subSequence(0, 4))) {
        	TablePeoSer table=new TablePeoSer();
        	r=table.txtRe2();
        }else if("执法机关".equals(name.subSequence(0, 4))) {
        	TableDepSer table=new TableDepSer();
        	r=table.txtRe2();
        }
		response.getWriter().append(r);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
