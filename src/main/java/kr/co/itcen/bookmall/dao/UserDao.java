package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.UserVo;

public class UserDao {
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

	public Boolean insert(UserVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "insert into user values(null, ?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTell());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPwd());
			pstmt.setString(5, vo.getAddress());

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

	public List<UserVo> getList() {
		List<UserVo> result = new ArrayList<UserVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select * from user order by no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String tell = rs.getString(3);
				String email = rs.getString(4);
				String pwd = rs.getString(5);
				String address = rs.getString(6);

				UserVo vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setTell(tell);
				vo.setEmail(email);
				vo.setPwd(pwd);
				vo.setAddress(address);

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

	public Boolean update(Long no, String select, String changeUserInfo) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			String sql = null;
			
			if(select.equals("name")) {
				sql = "update user set name = " + "'" + changeUserInfo + "'" + "where no = " + no;
			}
			if(select.equals("tell")) {
				sql = "update user set tell = " + "'" + changeUserInfo + "'" + "where no = " + no;
			}
			if(select.equals("email")) {
				sql = "update user set email = " + "'" + changeUserInfo + "'" + "where no = " + no;
			}
			if(select.equals("pwd")) {
				sql = "update user set pwd = " + "'" + changeUserInfo + "'" + "where no = " + no;
			}
			if(select.equals("address")) {
				sql = "update user set address = " + "'" + changeUserInfo + "'" + "where no = " + no;
			}

			//String sql = "update user set name = ?, tell = ?, email = ?, pwd = ?, address = ? where no = " + no;
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
			
			String sql = "delete from user where no = " + no;
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
