package dev.rdunaway.spring5jpafirst.repositories;

import dev.rdunaway.spring5jpafirst.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
