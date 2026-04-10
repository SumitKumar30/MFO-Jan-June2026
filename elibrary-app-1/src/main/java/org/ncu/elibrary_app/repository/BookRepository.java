package org.ncu.elibrary_app.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ncu.elibrary_app.model.Book;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManagerFactory;

@Repository
public class BookRepository {
	private final SessionFactory sessionFactory;
	
	public BookRepository(EntityManagerFactory entityManagerFactory) {
		this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
	}
	
	// CREATE
    public String saveBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(book);
            transaction.commit();
            return "Book saved successfully";
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    // READ ALL
    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();

        try {
            return session.createQuery("from Book", Book.class).list();
        } finally {
            session.close();
        }
    }
    
    // READ BY ID
    public Book getBookById(int bookId) {
        Session session = sessionFactory.openSession();

        try {
            return session.get(Book.class, bookId);
        } finally {
            session.close();
        }
    }
    
    // UPDATE
    public String updateBook(int bookId, Book updatedBook) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Book existingBook = session.get(Book.class, bookId);

            if (existingBook == null) {
                return "Book not found";
            }

            existingBook.setBookName(updatedBook.getBookName());
            existingBook.setAuthorName(updatedBook.getAuthorName());
            existingBook.setBookPrice(updatedBook.getBookPrice());
            existingBook.setBookIsbn(updatedBook.getBookIsbn());
            existingBook.setPublicationDate(updatedBook.getPublicationDate());

            session.merge(existingBook);
            transaction.commit();

            return "Book updated successfully";
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    // DELETE
    public String deleteBook(int bookId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Book existingBook = session.get(Book.class, bookId);

            if (existingBook == null) {
                return "Book not found";
            }

            session.remove(existingBook);
            transaction.commit();

            return "Book deleted successfully";
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
