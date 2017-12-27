package com.tn.isamm.boutiquebackend.dao;

import java.util.List;

import com.tn.isamm.boutiquebackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();

	Category get(int id);


}
