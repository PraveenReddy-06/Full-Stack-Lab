package com.klu.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.klu.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1 Welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // 2 Count
    @GetMapping("/count")
    public int count() {
        return 150;
    }

    // 3 Price
    @GetMapping("/price")
    public double price() {
        return 499.50;
    }

    // 4 Books list
    @GetMapping("/books")
    public List<String> books() {

        List<String> list = new ArrayList<>();

        list.add("Java Programming");
        list.add("Spring Boot");
        list.add("Machine Learning");
        list.add("Data Structures");

        return list;
    }

    // 5 Book by id
    @GetMapping("/books/{id}")
    public String bookById(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    // 6 Search
    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching book with title: " + title;
    }

    // 7 Author
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 8 Add Book
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {

        bookList.add(book);

        return "Book Added Successfully";
    }

    // 9 View Books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}