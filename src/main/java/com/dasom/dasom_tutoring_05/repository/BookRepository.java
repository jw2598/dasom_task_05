package com.dasom.dasom_tutoring_05.repository;

import com.dasom.dasom_tutoring_05.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
