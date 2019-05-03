package dev.rdunaway.spring5jpafirst.repositories;

import dev.rdunaway.spring5jpafirst.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
