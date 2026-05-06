package com.dasom.dasom_tutoring_05.service;

import com.dasom.dasom_tutoring_05.dto.BookReqDTO;
import com.dasom.dasom_tutoring_05.dto.BookResDTO;
import com.dasom.dasom_tutoring_05.dto.MessageResDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookServiceImpl implements BookService {

    private final List<BookResDTO> bookStorage = new ArrayList<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public MessageResDTO registerBook(BookReqDTO reqDTO) {
        Long newId = idGenerator.getAndIncrement();

        BookResDTO newBook = new BookResDTO(
                newId,
                reqDTO.getTitle(),
                reqDTO.getAuthor(),
                reqDTO.getPrice(),
                LocalDateTime.now()
        );
        bookStorage.add(newBook);

        return new MessageResDTO("도서 등록 완료", LocalDateTime.now());
    }

    @Override
    public List<BookResDTO> getAllBooks() {
        return bookStorage;
    }

    @Override
    public BookResDTO getBookById(Long id) {
        return bookStorage.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public MessageResDTO updateBook(Long id, BookReqDTO reqDTO) {
        BookResDTO book = getBookById(id);

        if (book != null) {
            book.setTitle(reqDTO.getTitle());
            book.setAuthor(reqDTO.getAuthor());
            book.setPrice(reqDTO.getPrice());
            return new MessageResDTO("도서 수정 완료", LocalDateTime.now());
        }

        return new MessageResDTO("해당 도서를 찾을 수 없습니다.", LocalDateTime.now());
    }

    @Override
    public MessageResDTO deleteBook(Long id) {
        boolean removed = bookStorage.removeIf(book -> book.getId().equals(id));

        if (removed) {
            return new MessageResDTO("도서 삭제 완료", LocalDateTime.now());
        }
        return new MessageResDTO("삭제 실패: 도서가 없습니다.", LocalDateTime.now());
    }
}