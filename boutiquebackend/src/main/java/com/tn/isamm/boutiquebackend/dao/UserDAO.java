package com.tn.isamm.boutiquebackend.dao;

import java.util.List;

import com.tn.isamm.boutiquebackend.dto.Address;
import com.tn.isamm.boutiquebackend.dto.Cart;
import com.tn.isamm.boutiquebackend.dto.User;

public interface UserDAO {

	// USER
	boolean add(User user);
	User getByEmail(String email);
	User get(int id);

	// ADRESSE
	boolean addAddress(Address address);
	Address getAddress(int addressId);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	

	
}
