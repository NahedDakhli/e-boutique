package com.tn.isamm.boutiquebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tn.isamm.boutiquebackend.dao.CategoryDAO;
import com.tn.isamm.boutiquebackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.tn.isamm.boutiquebackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
}
	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("laptopppppppppppp");
		category.setImageURL("nahed10.jpg");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
	}
}
