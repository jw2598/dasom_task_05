package com.dasom.dasom_tutoring_05.controller;


import com.dasom.dasom_tutoring_05.dto.BookReqDTO;
import com.dasom.dasom_tutoring_05.dto.BookResDTO;
import com.dasom.dasom_tutoring_05.dto.MessageResDTO;
import com.dasom.dasom_tutoring_05.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public  BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<MessageResDTO> createBook(@RequestBody BookReqDTO reqDTO) {
        MessageResDTO response = bookService.registerBook(reqDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BookResDTO>> findAll() {
        List<BookResDTO> response = bookService.getAllBooks();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResDTO> findById(@PathVariable Long id) {
        BookResDTO response = bookService.getBookById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResDTO> update(@PathVariable Long id, @RequestBody BookReqDTO reqDTO) {
        MessageResDTO response = bookService.updateBook(id, reqDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResDTO> delete(@PathVariable Long id) {
        MessageResDTO response = bookService.deleteBook(id);
        return ResponseEntity.ok(response);
    }
}
