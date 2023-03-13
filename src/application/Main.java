package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		System.out.println("\n====== TEST 2 - SELLER - FIND BY DEPARTMENT ======");
		List<Seller> seller2 = sellerDao.findByDepartment(new Department(2, null));
		for (Seller seller : seller2) {
			System.out.println(seller);
		}
		
		System.out.println("\n====== TEST 3 - SELLER - FIND ALL ======");
		List<Seller> seller3 = sellerDao.findAll();
		for (Seller seller : seller3) {
			System.out.println(seller);
		}
		
		System.out.println("\n====== TEST 4 - SELLER - INSERT ======");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Seller seller4 = new Seller(null, "Chelsea", "chelsea@mail.com", sdf.parse("29/05/1987"), 5300.0, new Department(1, null));
			sellerDao.insert(seller4);
			System.out.println(seller4);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n====== TEST 5 - SELLER - UPDATE ======");
		Seller seller5 = sellerDao.findById(1);
		seller5.setBaseSalary(2500.0);
		sellerDao.update(seller5);
		System.out.println(seller5);
		
		System.out.println("\n====== TEST 6 - SELLER - DELETE ======");
		sellerDao.deleteById(11);
		sellerDao.deleteById(12);
		System.out.println("Delete completed");
		
	}

}
