package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for {@link Compensation}
 *
 * @author Anthony Galea
 */
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    List<Compensation> findCompensationByEmployee(Employee employee);
}
