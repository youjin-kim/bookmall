package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.BookVo;

public class BookDao {
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

	public Boolean insert(BookVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "insert into book values(null, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo.getCategory_no());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setInt(4, vo.getStock());

			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if (rs.next()) {
				Long no = rs.getLong(1);
				vo.setNo(no);
			}

			System.out.println("추가 완료!");

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

	public List<BookVo> getList() {
		List<BookVo> result = new ArrayList<BookVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select * from book order by category_no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				Long category_no = rs.getLong(2);
				String name = rs.getString(3);
				int price = rs.getInt(4);
				int stock = rs.getInt(5);

				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setCategory_no(category_no);
				vo.setName(name);
				vo.setPrice(price);
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

	public Boolean update(Long no, String select, String changeBookInfo) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			String sql = null;

			if (select.equals("name")) {
				sql = "update book set name = " + "'" + changeBookInfo + "'" + "where no = " + no;
			}
			if (select.equals("price")) {
				int changePrice = Integer.parseInt(changeBookInfo);
				sql = "update book set price = " + "'" + changePrice + "'" + "where no = " + no;
			}
			if (select.equals("stock")) {
				int changeStock = Integer.parseInt(changeBookInfo);
				sql = "update book set stock = " + "'" + changeStock + "'" + "where no = " + no;
			}
			if (select.equals("category_no")) {
				Long changeCategoryNo = Long.parseLong(changeBookInfo);
				sql = "update book set category_no = " + "'" + changeCategoryNo + "'" + "where no = " + no;
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
			
			String sql = "delete from book where no = " + no;
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
