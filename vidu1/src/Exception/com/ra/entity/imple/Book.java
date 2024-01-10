package Exception.com.ra.entity.imple;

import Exception.com.ra.exception.BookInputException;
import Exception.com.ra.service.impl.BookServiceIpm;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book implements IBook, Serializable {
    private static int autoincrementId = 1;
    private int bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private Date created = new Date(); // Ngày nhập
    private String description;

    public Book() {
    }

    public Book(int bookId, String bookName, float importPrice, float exportPrice, String author, String description) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;

        this.description = description;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) throws Exception {
        if(bookName == null || bookName.length() < 4 || bookName.length() > 50){
            throw new BookInputException("Tên sách phải có độ dài từ 4 đến 50 ký tự");
        }
        if(!bookName.startsWith("B"))
            throw new Exception("Tên sách phải bắt đầu bằng chữ B");
        BookServiceIpm bookServiceIpm = new BookServiceIpm();
        if(this.bookId == 0){
            if(bookServiceIpm.findAny(b -> b.getBookName().equals(bookName)))
                throw new Exception("Tên sách đã tồn tại ");
        }else{
            if(bookServiceIpm.findAny(b -> b.getBookName().equals(bookName) && b.bookId != this.bookId))
                throw new Exception("Tên sách đã tồn tại ");
        }
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) throws Exception {
        if(importPrice < 0)
            throw new BookInputException("Giá nhập phải lớn hơn 0");
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) throws Exception {
        if(exportPrice < importPrice)
            throw new BookInputException("Giá bán phải lớn hơn giá nhập : " + this.importPrice);
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author)  throws Exception{
        if(author==null || author.length() < 6 || author.length() > 50)
            throw new BookInputException("Tên tác giả phải có độ dài từ 6 đến 50 ký tự");
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws Exception {
        if(description.length() < 10 || description.length() > 100)
            throw new BookInputException("Mô tả phải có độ dài từ 10 đến 100 ký tự");
        this.description = description;
    }

    @Override
    public void inputData(Scanner scanner) {
        boolean flag = true;
        do {
            try{
                System.out.println("Nhập t sách: ");
                setBookName(scanner.nextLine());
                flag = false;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                flag = true;
            }
        }while (flag);

        do {
            try{
                System.out.println("Nhập giá nhập: ");
                setImportPrice(Float.parseFloat(scanner.nextLine()));
                flag = false;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                flag = true;
            }
        }while (flag);

        do {
            try{
                System.out.println("Nhập giá bán: ");
                setExportPrice(Float.parseFloat(scanner.nextLine()));
                flag = false;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                flag = true;
            }
        }while (flag);

        do {
            try{
                System.out.println("Nhập tác giả: ");
                setAuthor(scanner.nextLine());
                flag = false;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                flag = true;
            }
        }while (flag);

        do {
            try{
                System.out.println("Nhập mô tả: ");
                setDescription(scanner.nextLine());
                flag = false;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                flag = true;
            }
        }while (flag);
        if(this.bookId == 0){
            this.bookId = autoincrementId++;
        }

    }

    @Override
    public void displayData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Mã sách: " + this.bookId);
        System.out.println("Tên sách: " + this.bookName);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá bán: " + this.exportPrice);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Ngày nhập: " + this.created);
        System.out.println("Mô tả: " + simpleDateFormat.format(this.created));


    }
}
