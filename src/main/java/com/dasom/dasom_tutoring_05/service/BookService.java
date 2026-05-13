package com.dasom.dasom_tutoring_05.service;

import com.dasom.dasom_tutoring_05.dto.BaseDTO;
import com.dasom.dasom_tutoring_05.dto.BookReqDTO;
import com.dasom.dasom_tutoring_05.dto.BookResDTO;
import com.dasom.dasom_tutoring_05.dto.MessageResDTO;

import java.util.List;

public interface BookService {
    MessageResDTO registerBook(BookReqDTO reqDTO);
    List<BookResDTO> getAllBooks();
    BaseDTO getBookById(Long id);
    MessageResDTO updateBook(Long id, BookReqDTO reqDTO);
    MessageResDTO deleteBook(Long id);
}
