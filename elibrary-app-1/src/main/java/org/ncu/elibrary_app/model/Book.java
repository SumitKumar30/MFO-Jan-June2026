package org.ncu.elibrary_app.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	@Column(name = "book_name", length = 20, nullable = false)
	private String bookName;
	@Column(name = "author_name", length = 50, nullable = false)
	private String authorName;
	@Column(name = "book_price", nullable = false)
	private double bookPrice;
	@Column(name = "book_isbn", nullable = false, unique = true)
	private long bookIsbn;
	@Column(name = "publication_date", nullable = false)
	private Date publicationDate;
}
