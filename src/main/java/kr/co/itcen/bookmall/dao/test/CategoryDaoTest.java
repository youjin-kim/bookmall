package kr.co.itcen.bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		updateTest();
		deleteTest();

	}

	private static void deleteTest() {
		System.out.println("delete test--------------------------");

		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제하고 싶은 category 번호를 입력하세요.>> ");
		Long no = scanner.nextLong();

		CategoryDao dao = new CategoryDao();
		dao.delete(no);

		scanner.close();

	}

	private static void updateTest() {
		System.out.println("update test--------------------------");

		Scanner scanner = new Scanner(System.in);
		System.out.print("변경하고 싶은 category 이름을 입력하세요>> ");
		String name = scanner.nextLine();

		System.out.print("변경될 category 이름은?>> ");
		String changeName = scanner.nextLine();

		CategoryDao dao = new CategoryDao();
		dao.update(name, changeName);

		scanner.close();

	}

	private static void selectTest() {
		System.out.println("select test--------------------------");
		CategoryDao dao = new CategoryDao();

		List<CategoryVo> list = dao.getList();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}

	}

	private static void insertTest() {
		System.out.println("insert test--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("추가할 category 이름을 입력하세요.>> ");
		String name = scanner.nextLine();
		
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		dao.insert(vo);
		System.out.println(vo);
		
		scanner.close();
	}

}
