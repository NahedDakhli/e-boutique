package com.tn.isamm.boutiquebackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;
import com.tn.isamm.boutiquebackend.dao.UserDAO;
import com.tn.isamm.boutiquebackend.dto.Address;
import com.tn.isamm.boutiquebackend.dto.Cart;
import com.tn.isamm.boutiquebackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.tn.isamm.boutiquebackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	/*@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Dakhli");
		user.setLastName("Nahed");
		user.setEmail("nahed@gmail.com");
		user.setContactNumber("24463667");
		user.setRole("CLIENT");
		user.setPassword("12345");
		
		assertEquals("Failed to add the user!", true, userDAO.add(user));	
		
		address = new Address();
		address.setAddressLineOne("07 rue abd allah ben houdhefa");
		address.setCity("Oued ellil");
		address.setCountry("Tunis");
		address.setPostalCode("2021");
		address.setBilling(true);
		address.setUserId(user.getId());
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("CLIENT")) {
			cart = new Cart();
			cart.setUser(user);
			assertEquals("Failed to add the cart!", true, userDAO.addCart(cart));
			
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setCity("Mumbai");
			address.setCountry("India");
			address.setPostalCode("400001");
			address.setShipping(true);
			address.setUserId(user.getId());

			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
			
		}
	}*/
	/*@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Dakhli");
		user.setLastName("Nahed");
		user.setEmail("nahed@gmail.com");
		user.setContactNumber("24463667");
		user.setRole("CLIENT");
		user.setPassword("12345");		
		
		if(user.getRole().equals("CLIENT")) {
			cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			
		}
		assertEquals("Failed to add the user!", true, userDAO.add(user));	

	}*/
	
	/*@Test
	public void testUpdateCart() {
		//user = userDAO.get(1);
		user = userDAO.getByEmail("nahed@gmail.com");
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	} */
	
	/*@Test
	public void testAddAddress() {
		user = userDAO.get(1);
		
		address = new Address();
		address.setAddressLineOne("301/B Jadoo Society, King Uncle Nagar");
		address.setCity("Mumbai");
		address.setCountry("India");
		address.setPostalCode("400001");
				
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));	
	}*/
}
