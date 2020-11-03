package com.balaji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.balaji.config.SpringConfig;
import com.balaji.dao.ProductDAO;
import com.balaji.model.Product;

public class ProductDAOTest {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		ProductDAO productDAO = (ProductDAO) applicationContext.getBean("productDAO");
		
//		Product product = new Product();
//		product.setPid(1003);
//		product.setPname("AC");
//		product.setPcost(20000.00);
//		System.out.println(productDAO.saveWithPSC(product));
		
		System.out.println(productDAO.callIncrementFunction(12));
	}

}
