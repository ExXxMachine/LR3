package com.example.demo6;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final ObjectOutputStream objectOutputStream;
    private List<Book> books;

    public BookService(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            books = (ArrayList<Book>) objectInputStream.readObject();
        } catch (Exception e) {
            if (!(e instanceof EOFException)) {
                throw new RuntimeException(e);
            }
            books = new ArrayList<>();
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    synchronized public void addBook(Book book) {
        books.add(book);
    }

    public void saveBook() {
        try {
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getBook() {
        return books;
    }
}