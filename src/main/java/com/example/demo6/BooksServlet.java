package com.example.demo6;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "BooksServlet", value = "/BooksServlet")
public class BooksServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private BooksServlet booksServlet;

    @Override
    public void init() {
        booksServlet = (BooksServlet) getServletContext().getAttribute("booksServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(BooksServlet.getBook()));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Book book = objectMapper.readValue(request.getInputStream(), Book.class);
        BookService.addBook(book);
    }
}
