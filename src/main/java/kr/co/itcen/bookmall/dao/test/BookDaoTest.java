package kr.co.itcen.bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		selectTest();
		insertTest();
		updateTest();
		deleteTest();

	}

	private static void deleteTest() {
		System.out.println("delete test--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("삭제할 도서번호를 입력하세요.>> ");
		Long no = scanner.nextLong();
		
		BookDao dao = new BookDao();
		dao.delete(no);
		
		scanner.close();
	}

	private static void updateTest() {
		System.out.println("update test--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("변경할 사항을 입력하세요.(도서번호,항목,변경내용)>> ");
		String changeInfo = scanner.nextLine();
		
		String[] bookInfo = changeInfo.split(",");
		Long no = Long.parseLong(bookInfo[0]);
		String select = bookInfo[1];
		String changeBookInfo = bookInfo[2];
		
		BookDao dao = new BookDao();
		dao.update(no, select, changeBookInfo);
		
		scanner.close();
	}

	private static void selectTest() {
		System.out.println("select test--------------------------");
		
		BookDao dao = new BookDao();
		
		List<BookVo> list = dao.getList();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
		
	}

	private static void insertTest() {
		System.out.println("insert test--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("추가할 도서 정보를 입력하세요.(카테고리 번호, 이름, 가격, 재고수량)>> ");
		String book = scanner.nextLine();
		
		BookDao dao = new BookDao();
		
		String[] bookArray = book.split(",");
		Long category_no = Long.parseLong(bookArray[0]);
		String name = bookArray[1];
		int price = Integer.parseInt(bookArray[2]);
		int stock = Integer.parseInt(bookArray[3]);
		
		BookVo vo = new BookVo();
		vo.setCategory_no(category_no);
		vo.setName(name);
		vo.setPrice(price);
		vo.setStock(stock);
		dao.insert(vo);
		System.out.println(vo);
		
		scanner.close();
	}

}
