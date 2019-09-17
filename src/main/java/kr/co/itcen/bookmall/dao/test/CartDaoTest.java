package kr.co.itcen.bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		selectTest();
		// insertTest();
		// updateTest();
		// deleteTest();

	}

	private static void deleteTest() {
		System.out.println("delete test--------------------------");

		Scanner scanner = new Scanner(System.in);

		System.out.print("삭제할 카트번호를 입력하세요.>> ");
		Long no = scanner.nextLong();

		CartDao dao = new CartDao();
		dao.delete(no);

		scanner.close();
	}

	private static void updateTest() {
		System.out.println("update test--------------------------");

		Scanner scanner = new Scanner(System.in);

		System.out.print("변경할 사항을 입력하세요.(회원번호,도서번호,항목,변경내용)>> ");
		String changeCartInfo = scanner.nextLine();

		String[] cartInfo = changeCartInfo.split(",");
		Long userNo = Long.parseLong(cartInfo[0]);
		Long no = Long.parseLong(cartInfo[1]);
		String select = cartInfo[2];
		int changeInfo = Integer.parseInt(cartInfo[3]);

		CartDao dao = new CartDao();
		dao.update(userNo, no, select, changeInfo);

		scanner.close();
	}

	private static void selectTest() {
		System.out.println("select test--------------------------");

		CartDao dao = new CartDao();

		List<CartVo> list = dao.getList();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		System.out.println("insert test--------------------------");

		CartDao dao = new CartDao();

		CartVo vo1 = new CartVo();
		vo1.setBookNo((long) 1);
		vo1.setUserNo((long) 1);
		vo1.setStock(1);
		dao.insert(vo1);
		System.out.println(vo1);

		CartVo vo2 = new CartVo();
		vo2.setBookNo((long) 3);
		vo2.setUserNo((long) 1);
		vo2.setStock(2);
		dao.insert(vo2);
		System.out.println(vo2);

		CartVo vo3 = new CartVo();
		vo3.setBookNo((long) 2);
		vo3.setUserNo((long) 3);
		vo3.setStock(1);
		dao.insert(vo3);
		System.out.println(vo3);
	}

}
