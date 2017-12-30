package com.tn.isamm.eboutique.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.boutiquebackend.dao.CartLineDAO;
import com.tn.isamm.boutiquebackend.dao.ProductDAO;
import com.tn.isamm.boutiquebackend.dto.Cart;
import com.tn.isamm.boutiquebackend.dto.CartLine;
import com.tn.isamm.eboutique.model.UserModel;

@Service("cartService")
public class CartService {

	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
		
	@Autowired
	private HttpSession session;
	
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	public List<CartLine> getCartLines() {

		return cartLineDAO.list(getCart().getId());

	}
}
