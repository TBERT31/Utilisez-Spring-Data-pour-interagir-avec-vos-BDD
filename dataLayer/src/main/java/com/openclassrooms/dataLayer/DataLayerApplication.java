package com.openclassrooms.dataLayer;

import java.util.Optional;

import com.openclassrooms.dataLayer.model.Category;
import com.openclassrooms.dataLayer.model.Comment;
import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.service.CategoryService;
import com.openclassrooms.dataLayer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.dataLayer.service.ProductService;

import javax.transaction.Transactional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Iterable<Product> searchResults = productService.getProductsByName("AssuranceTousRisques");
		searchResults.forEach(product -> System.out.println(product.getProductId()));

		searchResults = productService.getProductsByCategoryName("Standard");
		searchResults.forEach(product -> System.out.println(product.getName()));

		searchResults = productService.getProductsByCostLessThan(1000);
		searchResults.forEach(product -> System.out.println(product.getName()));

		Iterable<Category> searchCategory = categoryService.getCategoryByName("Standard");
		searchCategory.forEach(category -> System.out.println(category.getCategoryId()));

		searchCategory = categoryService.getCategoriesByProductName("AssuranceTousRisques");
		searchCategory.forEach(category -> System.out.println(category.getName()));

		Iterable<Comment> searchComments = commentService.getCommentContaining("deçu");
		searchComments.forEach(comment -> System.out.println(comment.getContent()));

	}

}

