package com.demo.org.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//db
		Connection con = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//数据库url
			String urlstr = "jdbc:mysql://10.10.3.254/studentinfo?"
					+ "user=s_2014&password=s_2014";
			con = DriverManager.getConnection(urlstr);
			//
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select count(1) cnt from studentinfo");
			
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				request.setAttribute("cnt", cnt);
			}

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
