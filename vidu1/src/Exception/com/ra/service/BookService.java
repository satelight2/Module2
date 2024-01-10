package Exception.com.ra.service;

import Exception.com.ra.entity.imple.Book;

import java.util.List;
import java.util.function.Predicate;

public interface BookService {
    List<Book> getBooks();
    Book getBookById(int bookId);
    void addBook(Book book);

    void deleteBook(int bookId);
    List<Book> sortbyPrice();
    List<Book> findPriceBetween(float from,float to);
    List<Book> findByAuthor(String author);
//    Book findByName(String name);
    boolean findAny(Predicate<Book> predicate);
    void loadData();
    boolean saveData();

}
