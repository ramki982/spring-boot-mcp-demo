package com.example.spring_boot_mcp_demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;
import java.io.InputStream;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Map<Long, Book> bookStore = new HashMap<>();
    private long currentId = 1;

    private final ResourceLoader resourceLoader;

    public BookController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void loadBooksFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Resource resource = resourceLoader.getResource("classpath:books.json");
            InputStream inputStream = resource.getInputStream();
            List<Book> books = objectMapper.readValue(inputStream, new TypeReference<List<Book>>() {});
            for (Book book : books) {
                book.setId(currentId++);
                bookStore.put(book.getId(), book);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load books from file", e);
        }
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookStore.values());
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookStore.get(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId(currentId++);
        bookStore.put(book.getId(), book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (!bookStore.containsKey(id)) {
            throw new RuntimeException("Book not found");
        }
        book.setId(id);
        bookStore.put(id, book);
        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookStore.remove(id);
    }
}