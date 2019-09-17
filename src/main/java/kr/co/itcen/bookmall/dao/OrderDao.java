package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDao {
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

	public Boolean insert(OrderVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "insert into orderTable values(null, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo.getUserNo());
			pstmt.setInt(2, vo.getTotalPrice());
			pstmt.setString(3, vo.getSendAddress());

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

	public List<OrderVo> getList() {
		List<OrderVo> result = new ArrayList<OrderVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select orderTable.no, orderTable.user_no, user.name, user.email, orderTable.total_price, orderTable.send_address from orderTable join user where orderTable.user_no = user.no order by orderTable.no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				Long no = rs.getLong(1);
				Long userNo = rs.getLong(2);
				String userName = rs.getString(3);
				String userEmail = rs.getString(4);
				int totalPrice = rs.getInt(5);
				String sendAddress = rs.getString(6);

				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setUserNo(userNo);
				vo.setUserName(userName);
				vo.setUserEmail(userEmail);
				vo.setTotalPrice(totalPrice);
				vo.setSendAddress(sendAddress);

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

	public Boolean delete(Long no) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();

			String sql = "delete from orderTable where no = " + no;
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

	public Boolean update(Long no, String changeSendAddress) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			String sql = "update orderTable set send_address = " + "'" + changeSendAddress + "'" + " where no = " + no;
			
			pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
			
			System.out.println("변경 완료!");
			
		}catch (SQLException e) {
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
