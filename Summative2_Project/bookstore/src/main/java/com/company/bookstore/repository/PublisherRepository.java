package com.company.bookstore.repository;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
