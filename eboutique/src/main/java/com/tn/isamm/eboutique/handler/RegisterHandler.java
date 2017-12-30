package com.tn.isamm.eboutique.handler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tn.isamm.boutiquebackend.dao.UserDAO;
import com.tn.isamm.boutiquebackend.dto.Address;
import com.tn.isamm.boutiquebackend.dto.Cart;
import com.tn.isamm.boutiquebackend.dto.User;
import com.tn.isamm.eboutique.model.RegisterModel;

@Component
public class RegisterHandler {
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	 @Autowired
	 private UserDAO userDAO;
	 public RegisterModel init() { 
		  return new RegisterModel();
		 }
	 
	 public void addUser(RegisterModel registerModel, User user) {
		  registerModel.setUser(user);
		 } 
	 
	 public void addBilling(RegisterModel registerModel, Address billing) {
		  registerModel.setBilling(billing);
		 }
	 
	 public String saveAll(RegisterModel registerModel) {
		  String transitionValue = "success";
		  User user = registerModel.getUser();
		  if(user.getRole().equals("USER")) {
		   Cart cart = new Cart();
		   cart.setUser(user);
		   user.setCart(cart);
		  }
		   
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
		  
		  userDAO.add(user);
		  
		  Address billing = registerModel.getBilling();
		  billing.setUserId(user.getId());
		  billing.setBilling(true);  
		  userDAO.addAddress(billing);
		  return transitionValue ;
		  }
		
	 public String validateUser(User user, MessageContext error) {
		  String transitionValue = "success";
		   if(!user.getPassword().equals(user.getConfirmPassword())) {
		    error.addMessage(new MessageBuilder().error().source(
		      "confirmPassword").defaultText("Le mot de passe ne correspond pas!").build());
		    transitionValue = "failure";    
		   }  
		   if(userDAO.getByEmail(user.getEmail())!=null) {
		    error.addMessage(new MessageBuilder().error().source(
		      "email").defaultText("L'adresse e-mail est déjà prise!").build());
		    transitionValue = "failure";
		   }
		  return transitionValue;
		 }

}
