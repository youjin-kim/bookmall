package kr.co.itcen.bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.OrderBookDao;
import kr.co.itcen.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {

	public static void main(String[] args) {
		// insertTest();
		selectTest();
		// updateTest();
		// deleteTest();

	}

	private static void deleteTest() {
		System.out.println("delete test--------------------------");

		Scanner scanner = new Scanner(System.in);

		System.out.print("삭제할 주문도서번호를 입력하세요.>> ");
		Long no = scanner.nextLong();

		OrderBookDao dao = new OrderBookDao();
		dao.delete(no);

		scanner.close();
	}

	private static void updateTest() {
		System.out.println("update test--------------------------");

		Scanner scanner = new Scanner(System.in);

		System.out.print("변경할 사항을 입력하세요.(주문도서번호,수량)>> ");
		String changeOrderBookInfo = scanner.nextLine();

		String[] orderBookInfo = changeOrderBookInfo.split(",");
		Long no = Long.parseLong(orderBookInfo[0]);
		int changeCount = Integer.parseInt(orderBookInfo[1]);

		OrderBookDao dao = new OrderBookDao();
		dao.update(no, changeCount);

		scanner.close();
	}

	private static void selectTest() {
		System.out.println("select test--------------------------");

		OrderBookDao dao = new OrderBookDao();

		List<OrderBookVo> list = dao.getList();
		for (OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		System.out.println("insert test--------------------------");

		OrderBookDao dao = new OrderBookDao();

		OrderBookVo vo1 = new OrderBookVo();
		vo1.setNo((long) 1);
		vo1.setBookNo((long) 2);
		vo1.setOrderNo((long) 1);
		vo1.setTotalCount(1);
		dao.insert(vo1);
		System.out.println(vo1);

		OrderBookVo vo2 = new OrderBookVo();
		vo2.setNo((long) 2);
		vo2.setBookNo((long) 1);
		vo2.setOrderNo((long) 2);
		vo2.setTotalCount(1);
		dao.insert(vo2);
		System.out.println(vo2);
	}

}
