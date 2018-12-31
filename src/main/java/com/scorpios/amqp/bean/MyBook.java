package com.scorpios.amqp.bean;

/**
 * @author Think
 * @Title: MyBook
 * @ProjectName springboot-data-amqp
 * @Description: TODO
 * @date 2018/12/1420:42
 */
public class MyBook {


    private String bookName;
    private String author;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MyBook(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "MyBook{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public MyBook() {
    }
}
