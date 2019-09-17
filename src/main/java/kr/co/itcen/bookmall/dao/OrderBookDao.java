package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrderBookVo;

public class OrderBookDao {
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

	public Boolean insert(OrderBookVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "insert into order_book values(null, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo.getBookNo());
			pstmt.setLong(2, vo.getOrderNo());
			pstmt.setInt(3, vo.getTotalCount());

			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if (rs.next()) {
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

	public List<OrderBookVo> getList() {
		List<OrderBookVo> result = new ArrayList<OrderBookVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select order_book.no, book.no, book.name, order_book.count from order_book join book, orderTable where order_book.book_no = book.no and order_book.order_no = orderTable.no order by order_book.no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Long no = rs.getLong(1);
				Long bookNo = rs.getLong(2);
				String bookName = rs.getString(3);
				int totalCount = rs.getInt(4);

				OrderBookVo vo = new OrderBookVo();
				vo.setNo(no);
				vo.setBookNo(bookNo);
				vo.setBookName(bookName);
				vo.setTotalCount(totalCount);

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

	public Boolean update(Long no, int changeCount) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			String sql = "update order_book set count = " + changeCount + " where no = " + no;

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

			String sql = "delete from order_book where no = " + no;
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
