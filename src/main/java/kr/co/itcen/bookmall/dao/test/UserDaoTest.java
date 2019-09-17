package kr.co.itcen.bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		selectTest();
		//insertTest();
		//updateTest();
		//deleteTest();

	}

	private static void deleteTest() {
		System.out.println("delete test--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("삭제할 회원번호를 입력하세요.>> ");
		Long no = scanner.nextLong();
		
		UserDao dao = new UserDao();
		dao.delete(no);
		
		scanner.close();
		
	}

	private static void updateTest() {
		System.out.println("update test--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("변경할 사항을 입력하세요.(회원번호,항목,변경내용)>> ");
		String changeInfo = scanner.nextLine();
		
		String[] userInfo = changeInfo.split(",");
		Long no = Long.parseLong(userInfo[0]);
		String select = userInfo[1];
		String changeUserInfo = userInfo[2];
		
		UserDao dao = new UserDao();
		dao.update(no, select, changeUserInfo);
		
		scanner.close();
		
	}

	private static void selectTest() {
		System.out.println("select test--------------------------");
		
		UserDao dao = new UserDao();
		
		List<UserVo> list = dao.getList();
		for(UserVo vo : list) {
			System.out.println(vo);
		}
		
	}

	private static void insertTest() {
		System.out.println("insert test--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("추가할 회원 정보를 입력하세요.(이름, 전화번호, 이메일, 비밀번호, 주소)>> ");
		String user = scanner.nextLine();
		
		UserDao dao = new UserDao();
		
		String[] userArray = user.split(",");
		String name = userArray[0];
		String tell = userArray[1];
		String email = userArray[2];
		String pwd = userArray[3];
		String address = userArray[4];
		
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setTell(tell);
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setAddress(address);
		dao.insert(vo);
		System.out.println(vo);
		
		scanner.close();
		
	}

}
