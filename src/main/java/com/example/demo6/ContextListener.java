package com.example.demo6;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    private final BookService bookService;

    public ContextListener() {
        this.bookService = new BookService("Z:\\Работа\\прога\\Java\\demo6\\src\\main\\webapp\\books.txt");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("bookService", bookService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        bookService.saveBook();
    }
}