package com.electron.electron.repository;

import com.electron.electron.entity.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor,Long> {

    List<BookAuthor> findAllByBookId(Long bookId);
}
