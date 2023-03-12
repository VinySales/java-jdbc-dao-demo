package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("====== TEST 1 - SELLER - FIND BY ID ======");
		Seller seller1 = sellerDao.findById(2);
		System.out.println(seller1);
		
		System.out.println();
		
		System.out.println("====== TEST 2 - SELLER - FIND BY DEPARTMENT ======");
		List<Seller> seller2 = sellerDao.findByDepartment(new Department(2, "Eletronics"));
		for (Seller seller : seller2) {
			System.out.println(seller);
		}
		
		System.out.println();
		
		System.out.println("====== TEST 3 - SELLER - FIND ALL ======");
		List<Seller> seller3 = sellerDao.findAll();
		for (Seller seller : seller3) {
			System.out.println(seller);
		}
		
		System.out.println();
	}

}
