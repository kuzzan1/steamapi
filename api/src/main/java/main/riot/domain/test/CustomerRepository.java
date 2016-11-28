package main.riot.domain.test;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by jonas on 2016-11-28.
 */


public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName( String lastName);

}