package dev.rdunaway.spring5jpafirst.bootstrap;

import dev.rdunaway.spring5jpafirst.model.Address;
import dev.rdunaway.spring5jpafirst.model.Author;
import dev.rdunaway.spring5jpafirst.model.Book;
import dev.rdunaway.spring5jpafirst.model.Publisher;
import dev.rdunaway.spring5jpafirst.repositories.AuthorRepo;
import dev.rdunaway.spring5jpafirst.repositories.BookRepo;
import dev.rdunaway.spring5jpafirst.repositories.PublisherRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PublisherRepo publisherRepo;

    private AuthorRepo authorRepo;

    private BookRepo bookRepo;

    public DevBootstrap(PublisherRepo publisherRepo, AuthorRepo authorRepo, BookRepo bookRepo) {
        this.publisherRepo = publisherRepo;
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // Eric
        final Author eric = new Author("John", "Smith");
        final Publisher harperC = new Publisher("Harper Collins", new Address("195 Broadway", "New York", "NY", "10007"));
        // Harper Collins 195 Broadway, New York, NY 10007
        final Book ddd = new Book("Domain Driven Design", "1234567", harperC);
        eric.getBooks().add(ddd);
        ddd.getAuthorsSet().add(eric);

        publisherRepo.save(harperC);
        authorRepo.save(eric);
        bookRepo.save(ddd);
        // Rod
        final Author rod = new Author("Rod", "Johnson");
        final Publisher wrox = new Publisher("Wrox", new Address("Birmingham B15", "Birmingham", "UK", "2TT"));
        // Wrox Birmingham B15, Birmingham, UK 2TT
        final Book noEJB = new Book("J2EE Development without EJB", "234444", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthorsSet().add(rod);

        publisherRepo.save(wrox);
        authorRepo.save(rod);
        bookRepo.save(noEJB);
    }
}
