package dev.rdunaway.spring5jpafirst.repositories;

import dev.rdunaway.spring5jpafirst.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
