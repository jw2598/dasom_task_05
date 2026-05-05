package com.dasom.dasom_tutoring_05.service;

import com.dasom.dasom_tutoring_05.dto.BookReqDTO;
import com.dasom.dasom_tutoring_05.dto.BookResDTO;
import com.dasom.dasom_tutoring_05.dto.MessageResDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Override
    public MessageResDTO registerBook(BookReqDTO reqDTO) {
        // 실제로는 여기서 DB에 저장하는 로직(repository.save)이 들어갑니다.
        // 지금은 응답 예시대로 리턴하는 코드를 작성합니다.
        return new MessageResDTO("도서 등록 완료", LocalDateTime.now());
    }

    @Override
    public List<BookResDTO> getAllBooks() {
        // 실제로는 repository.findAll()을 호출하여 DB 데이터를 가져옵니다.
        // 예시 데이터를 리스트에 담아 반환하는 흐름은 다음과 같습니다.
        List<BookResDTO> books = new ArrayList<>();
        books.add(new BookResDTO(1L, "도서1", "작가1", 10000, LocalDateTime.parse("2026-04-29T12:00:00")));
        books.add(new BookResDTO(2L, "도서2", "작가2", 20000, LocalDateTime.parse("2026-04-29T12:00:00")));

        return books;
    }

    @Override
    public BookResDTO getBookById(Long id) {
        // 실제 구현 시에는 repository.findById(id)를 사용합니다.
        // 예시 응답 데이터 구조에 맞춰 객체를 생성해 반환합니다.
        return new BookResDTO(1L, "조회된 도서", "홍길동", 15000, LocalDateTime.parse("2026-04-29T12:00:00"));
    }

    @Override
    public MessageResDTO updateBook(Long id, BookReqDTO reqDTO) {
        // 실제 로직:
        // 1. repository.findById(id)로 기존 도서 조회
        // 2. 조회된 도서의 필드(title, author, price)를 reqDTO의 값으로 변경
        // 3. 변경 사항 저장 (Dirty Checking 혹은 repository.save)

        return new MessageResDTO("도서 수정 완료", LocalDateTime.now());
    }

    @Override
    public MessageResDTO deleteBook(Long id) {
        // 실제 로직:
        // 1. repository.existsById(id) 등으로 데이터 존재 여부 확인
        // 2. repository.deleteById(id) 호출하여 삭제

        return new MessageResDTO("도서 삭제 완료", LocalDateTime.now());
    }
}
