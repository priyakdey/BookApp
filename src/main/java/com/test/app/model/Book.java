package com.test.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books", indexes = {
		@Index(name = "index_title", columnList = "title", unique = true)
})
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Long id;
	
	@Column(name = "title", unique = true, length = 100)
	private String title;
	
	@Column(name = "description", length = 140)
	private String description;
	
	@Column(name = "author", length = 140)
	private String author;
	
	@Column(name = "price", length = 10)
	private String price;
}
