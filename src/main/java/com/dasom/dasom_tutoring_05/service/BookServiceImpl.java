package com.dasom.dasom_tutoring_05.service;

import com.dasom.dasom_tutoring_05.dto.BaseDTO;
import com.dasom.dasom_tutoring_05.dto.BookReqDTO;
import com.dasom.dasom_tutoring_05.dto.BookResDTO;
import com.dasom.dasom_tutoring_05.dto.MessageResDTO;
import com.dasom.dasom_tutoring_05.entity.Book;
import com.dasom.dasom_tutoring_05.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public MessageResDTO registerBook(BookReqDTO reqDTO) {
        Book book = new Book();
        book.setTitle(reqDTO.getTitle());
        book.setAuthor(reqDTO.getAuthor());
        book.setPrice(reqDTO.getPrice());
        book.setStatus(reqDTO.getStatus());

        bookRepository.save(book);

        return new MessageResDTO("도서 등록 완료", LocalDateTime.now());
    }

    @Override
    public List<BookResDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResDTO> responseList = new ArrayList<>();
        for (Book book : books) {
            BookResDTO dto = new BookResDTO(
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPrice(),
                    book.getStatus(),
                    book.getCreatedAt()
            );
            responseList.add(dto);
        }

        return responseList;
    }

    @Override
    public BaseDTO getBookById(Long id) { // 상황에 따라 다른 DTO를 던져야 하므로 Object 혹은 공통 부모 타입 사용
        // 1. DB에서 ID로 도서 찾기
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return new BookResDTO(
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPrice(),
                    book.getStatus(),
                    book.getCreatedAt()
            );
        }
        return new MessageResDTO("존재하지 않는 도서입니다.", LocalDateTime.now());
    }

    @Override
    public MessageResDTO updateBook(Long id, BookReqDTO reqDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();

            book.setTitle(reqDTO.getTitle());
            book.setAuthor(reqDTO.getAuthor());
            book.setPrice(reqDTO.getPrice());
            book.setStatus(reqDTO.getStatus());

            bookRepository.save(book);
            return new MessageResDTO("도서 수정 완료", LocalDateTime.now());
        }
        return new MessageResDTO("존재하지 않는 도서입니다.", LocalDateTime.now());
    }

    @Override
    public MessageResDTO deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.delete(optionalBook.get());
            return new MessageResDTO("도서 삭제 완료", LocalDateTime.now());
        }
        return new MessageResDTO("존재하지 않는 도서입니다.", LocalDateTime.now());
    }
}