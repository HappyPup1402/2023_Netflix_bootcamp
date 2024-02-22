package com.company.bookstore.repository;

import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PublisherRepositoryTest {
    @Autowired
    PublisherRepository publisherRepository;

    @BeforeEach
    void setUp(){
        publisherRepository.deleteAll();
    }

    @Test
    public void createNewPublisherTest(){
        Publisher publisher = new Publisher();
        publisher.setName("Izaac Ramirez");
        publisher.setStreet("Elmcroft");
        publisher.setCity("Norwalk");
        publisher.setState("CA");
        publisher.setPostal_code("90650");
        publisher.setPhone("(562)846-8623");
        publisher.setEmail("izaacramirez1402@gmail.com");
        publisher = publisherRepository.save(publisher);

        Optional<Publisher> newPublisher = publisherRepository.findById(publisher.getId());

        assertEquals(newPublisher.get(), publisher);
    }

    @Test
    public void getPublisherByIdTest(){
        Publisher publisher = new Publisher();
        publisher.setName("Izaac Ramirez");
        publisher.setStreet("Elmcroft");
        publisher.setCity("Norwalk");
        publisher.setState("CA");
        publisher.setPostal_code("90650");
        publisher.setPhone("(562)846-8623");
        publisher.setEmail("izaacramirez1402@gmail.com");
        publisher = publisherRepository.save(publisher);

        Optional<Publisher> retrievedPublisher = publisherRepository.findById(publisher.getId());

        assertTrue(retrievedPublisher.isPresent());
        assertEquals(retrievedPublisher.get(), publisher);
    }

    @Test
    public void getAllPublishersTest(){
        Publisher publisher = new Publisher();
        publisher.setName("Izaac Ramirez");
        publisher.setStreet("Elmcroft");
        publisher.setCity("Norwalk");
        publisher.setState("CA");
        publisher.setPostal_code("90650");
        publisher.setPhone("(562)846-8623");
        publisher.setEmail("izaacramirez1402@gmail.com");
        publisher = publisherRepository.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Eduardo Ramirez");
        publisher2.setStreet("Elmcroft");
        publisher2.setCity("Norwalk");
        publisher2.setState("CA");
        publisher2.setPostal_code("90650");
        publisher2.setPhone("(522)846-8623");
        publisher2.setEmail("santo12@gmail.com");
        publisher2 = publisherRepository.save(publisher2);

        List<Publisher> allPublishers = publisherRepository.findAll();

        assertEquals(allPublishers.size(), 2);
    }

    @Test
    public void updatePublisherTest(){
        Publisher publisher = new Publisher();
        publisher.setName("Izaac Ramirez");
        publisher.setStreet("Elmcroft");
        publisher.setCity("Norwalk");
        publisher.setState("CA");
        publisher.setPostal_code("90650");
        publisher.setPhone("(562)846-8623");
        publisher.setEmail("izaacramirez1402@gmail.com");
        publisher = publisherRepository.save(publisher);

        publisher.setCity("Downey");

        publisherRepository.save(publisher);

        Optional<Publisher> newPublisher = publisherRepository.findById(publisher.getId());

        assertEquals(newPublisher.get(), publisher);
    }

    @Test
    public void deletePublisherTest(){
        Publisher publisher = new Publisher();
        publisher.setName("Izaac Ramirez");
        publisher.setStreet("Elmcroft");
        publisher.setCity("Norwalk");
        publisher.setState("CA");
        publisher.setPostal_code("90650");
        publisher.setPhone("(562)846-8623");
        publisher.setEmail("izaacramirez1402@gmail.com");
        publisher = publisherRepository.save(publisher);

        publisherRepository.delete(publisher);

        Publisher deletedPublisher = publisherRepository.findById(publisher.getId()).orElse(null);

        assertNull(deletedPublisher);
    }

}