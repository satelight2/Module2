package Exception.com.ra.service.impl;

import Exception.com.ra.entity.imple.Book;
import Exception.com.ra.service.BookService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookServiceIpm  implements BookService {
    private static List<Book> data = new ArrayList<>();
    @Override
    public List<Book> getBooks() {
        return data;
    }

    @Override
    public Book getBookById(int bookId) {
        for (Book b: data) {
            if(b.getBookId() == bookId)
                return b;
        }
        return null;
//        return data.stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);

    }

    @Override
    public void addBook(Book book) {
        data.add(book);


    }



    @Override
    public void deleteBook(int bookId) {
        Book book = getBookById(bookId);
        if(book != null){
            data.remove(book);

        }
        else
            System.out.println("Không tìm thấy sách có mã " + bookId);

    }

    @Override
    public List<Book> sortbyPrice() {
        List<Book> sortedList = new ArrayList<>(data);
        sortedList.sort((b1,b2) -> Float.compare(b1.getExportPrice(), b2.getExportPrice()));
        return sortedList;
    }

    @Override
    public List<Book> findPriceBetween(float from, float to) {
        return data.stream().filter(b -> b.getExportPrice() >= from && b.getExportPrice() <=to).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> listAuthor = new ArrayList<>();
        for(Book b: data) {
            if(b.getAuthor().equalsIgnoreCase(author))
                listAuthor.add(b);
        }
        return listAuthor;
    }

//    @Override
//    public Book findByName(String name) {
//
//        for(Book b: data) {
//            if(b.getBookName().equalsIgnoreCase(name))
//                return b;
//        }
//        return null;
//    }

    @Override
    public boolean findAny(Predicate<Book> predicate) {
        for(Book b: data) {
            if(predicate.test(b))
                return true;
        }
        return false;
    }

    @Override
    public void loadData() {
        try{
            File file = new File("book.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (List<Book>) ois.readObject();
            ois.close();
            fis.close();

        }
        catch (Exception e) {
            data = new ArrayList<>();
        }

    }

    @Override
    public boolean saveData() {
        try {
            File file = new File("book.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
