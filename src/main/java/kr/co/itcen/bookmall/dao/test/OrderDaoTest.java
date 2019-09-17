package kr.co.itcen.bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		//insertTest();
		selectTest();
		//updateTest();
		//deleteTest();
	}

	private static void deleteTest() {
		System.out.println("delete test--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("삭제할 주문번호를 입력하세요.>> ");
		Long no = scanner.nextLong();
		
		OrderDao dao = new OrderDao();
		dao.delete(no);
		
		scanner.close();
	}

	private static void updateTest() {
		System.out.println("update test--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("변경할 배송주소를 입력해주세요.(카트번호,배송주소)>> ");
		String changeOrderInfo = scanner.nextLine();
		
		String[] orderInfo = changeOrderInfo.split(",");
		Long no = Long.parseLong(orderInfo[0]);
		String changeSendAddress = orderInfo[1];
		
		OrderDao dao = new OrderDao();
		dao.update(no, changeSendAddress);
		
		scanner.close();
	}

	private static void selectTest() {
		System.out.println("select test--------------------------");
		
		OrderDao dao = new OrderDao();
		
		List<OrderVo> list = dao.getList();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		System.out.println("insert test--------------------------");
		
		OrderDao dao = new OrderDao();
		
		OrderVo vo1 = new OrderVo();
		vo1.setNo((long)1);
		vo1.setUserNo((long)3);
		vo1.setTotalPrice(50000);
		vo1.setSendAddress("경기도 성남시 분당구 정자동");
		dao.insert(vo1);
		System.out.println(vo1);
		
		OrderVo vo2 = new OrderVo();
		vo2.setNo((long)2);
		vo2.setUserNo((long)1);
		vo2.setTotalPrice(35000);
		vo2.setSendAddress("서울특별시 강남구");
		dao.insert(vo2);
		System.out.println(vo2);
		
		OrderVo vo3 = new OrderVo();
		vo3.setNo((long)3);
		vo3.setUserNo((long)1);
		vo3.setTotalPrice(40000);
		vo3.setSendAddress("서울특별시 강남구");
		dao.insert(vo3);
		System.out.println(vo3);
	}

}
