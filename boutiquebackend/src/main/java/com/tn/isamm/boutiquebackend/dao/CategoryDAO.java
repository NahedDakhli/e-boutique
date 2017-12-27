package com.tn.isamm.boutiquebackend.dao;

import java.util.List;

import com.tn.isamm.boutiquebackend.dto.Category;

public interface CategoryDAO {
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

}
