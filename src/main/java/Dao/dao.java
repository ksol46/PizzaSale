package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.dto;

public class dao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static Connection getConnection () throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe", "ksol46", "0406");
		return con;
	}
	
	public int insert(HttpServletRequest request, HttpServletResponse response) {
		int saleno = Integer.parseInt(request.getParameter("saleno"));
		String bcode = request.getParameter("bcode");
		String saledate = request.getParameter("saledate");
		String pizzacode = request.getParameter("pizzacode");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int result = 0;
		
		try {
			conn = getConnection();
			String sql = "insert into table_saleif_03 values (?, ? ,?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, saleno);
			ps.setString(2, bcode);
			ps.setString(3, saledate);
			ps.setString(4, pizzacode);
			ps.setInt(5, quantity);
			
			result = ps.executeUpdate();
			
			conn.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String inqury (HttpServletRequest request, HttpServletResponse response) {
		ArrayList<dto> list = new ArrayList<dto>();
		
		try {
			conn = getConnection();
			String sql = "select"
					+ " s.saleno,"
					+ " b.bcode ||'-'|| b.bname as bname,"
					+ " to_char(s.saledate,'yyyy-mm-dd') as saledate,"
					+ " p.pizzacode,"
					+ " p.pizzaname,"
					+ " s.quantity,"
					+ " (s.quantity * p.cost) as total"
					+ " from table_branch_02 b"
					+ " join table_saleif_03 s"
					+ " on b.bcode = s.bcode"
					+ " join table_pizza_01 p"
					+ " on p.pizzacode = s.pizzacode"
					+ " order by s.saleno";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				dto dto = new dto();
				
				dto.setSaleno(rs.getInt(1));
				dto.setBname(rs.getString(2));
				dto.setSaledate(rs.getString(3));
				dto.setPizzacode(rs.getString(4));
				dto.setPizzaname(rs.getString(5));
				dto.setQuantity(rs.getInt(6));
				dto.setTake(rs.getInt(7));
				
				list.add(dto);
			}
					
			request.setAttribute("list", list);
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "inqury.jsp";
	}
	
	public String branch (HttpServletRequest request, HttpServletResponse response) {
		ArrayList<dto> blist = new ArrayList<dto>();
		try {
			conn = getConnection();
			String sql = "select"
					+ "	b.bcode,"
					+ "	b.bname,"
					+ " '￦'||to_char(sum(p.cost*s.quantity),'999,999,999') as total"
					+ " from table_branch_02 b"
					+ " join table_saleif_03 s"
					+ " on b.bcode = s.bcode"
					+ " join table_pizza_01 p"
					+ " on s.pizzacode = p.pizzacode"
					+ " group by b.bcode, b.bname"
					+ " order by b.bcode";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto dto = new dto();
				
				dto.setBcode(rs.getString(1));
				dto.setBname(rs.getString(2));
				dto.setTotal(rs.getString(3));
				
				blist.add(dto);
			}
			
			request.setAttribute("blist", blist);
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "branch.jsp";
	}

	public String goods (HttpServletRequest request , HttpServletResponse response) {
		ArrayList<dto> glist = new ArrayList<dto>();
		
		try {
			
			conn = getConnection();
			String sql = "select"
					+ "	p.pizzacode,"
					+ "	p.pizzaname,"
					+ " '￦'||to_char(sum(p.cost*(s.quantity)),'999,999,999') as total"
					+ " from table_branch_02 b"
					+ " join table_saleif_03 s"
					+ " on b.bcode = s.bcode"
					+ " join table_pizza_01 p"
					+ " on s.pizzacode = p.pizzacode"
					+ " group by p.pizzacode, p.pizzaname"
					+ " order by total desc";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				dto dto = new dto();
				dto.setPizzacode(rs.getString(1));
				dto.setPizzaname(rs.getString(2));
				dto.setTotal(rs.getString(3));
				
				glist.add(dto);
			}
			
			request.setAttribute("glist",glist);
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "goods.jsp";
	}
}
