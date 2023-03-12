package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		SellerDao obj = DaoFactory.createSellerDao();
		Seller seller = obj.findById(2);
		
		System.out.println(seller);
		
	}

}
