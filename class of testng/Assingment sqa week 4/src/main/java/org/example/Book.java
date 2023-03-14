package org.example;

public class Book {
    String bookname;
    int Pages;

    public Book(String name, int page){
        bookname=name;
        Pages=page;
    }

    static void Geetings(){
        System.out.println("Hello we are going to create the Book class");
    }
    public void AuthorName(String auth_name){
        System.out.println("Author name is: " +auth_name);
    }
    public void BookName(){
        System.out.println("Book name is: " +bookname);
    }
    public void Pagecount(){
        System.out.println("Book has  " +Pages+" pages");
    }

    public static void main(String[] args){
        Geetings();
        Book mybook=new Book("Invisible Man", 500);
        mybook.BookName();
        mybook.AuthorName("Ralph Ellison");
        mybook.Pagecount();
    }
}
