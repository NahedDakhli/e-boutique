package com.tn.isamm.boutiquebackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;

import com.tn.isamm.boutiquebackend.dao.CartLineDAO;
import com.tn.isamm.boutiquebackend.dao.ProductDAO;
import com.tn.isamm.boutiquebackend.dao.UserDAO;
import com.tn.isamm.boutiquebackend.dto.Cart;
import com.tn.isamm.boutiquebackend.dto.CartLine;
import com.tn.isamm.boutiquebackend.dto.Product;
import com.tn.isamm.boutiquebackend.dto.User;

public class CartLineTestCase {

private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.tn.isamm.boutiquebackend");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testAddCartLine() {
		
		User user = userDAO.getByEmail("med@gmail.com");		
		Cart cart = user.getCart();
		
		Product product = productDAO.get(2);
		
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setProductCount(1);
		
		double oldTotal = cartLine.getTotal();		
		
		cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
		
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		assertEquals("Failed to update the cart!",true, cartLineDAO.updateCart(cart));
		
	}
	
}
