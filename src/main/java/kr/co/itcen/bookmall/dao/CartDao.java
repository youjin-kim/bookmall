package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CartVo;

public class CartDao {
	private Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.1.85:3306/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver: " + e);
		}

		return connection;
	}
	
	public Boolean insert(CartVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();

			String sql = "insert into cart values(null, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo.getBook_no());
			pstmt.setLong(2, vo.getUser_no());
			pstmt.setInt(3, vo.getStock());

			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long no = rs.getLong(1);
				vo.setNo(no);
			}


		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}

		return result;
	}

	public List<CartVo> getList() {
		List<CartVo> result = new ArrayList<CartVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select * from cart order by user_no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				Long book_no = rs.getLong(2);
				Long user_no = rs.getLong(3);
				int stock = rs.getInt(4);
				
				CartVo vo = new CartVo();
				vo.setNo(no);
				vo.setBook_no(book_no);
				vo.setUser_no(user_no);
				vo.setStock(stock);
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}

		return result;
	}

	public Boolean update(Long user_no, Long no, String select, int changeInfo) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			String sql = null;
			
			if(select.equals("book_no")) {
				Long changeBookNo = (long)changeInfo;
				sql = "update cart set book_no = " + "'" + changeBookNo + "'" + "where no = " + no + " and user_no = " + user_no;
			}
			if(select.equals("stock")) {
				sql = "update cart set stock = " + "'" + changeInfo + "'" + "where no = " + no + " and user_no = " + user_no;
			}

			pstmt = connection.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
			System.out.println("변경 완료!");
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}

		return result;
	}

	public Boolean delete(Long no) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "delete from cart where no = " + no;
			pstmt = connection.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
			System.out.println("삭제 완료!");
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}

		return result;
	}

}
