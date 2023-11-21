package com.example.sistemaventassid2.repository;

import com.example.sistemaventassid2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c.customerId FROM Customer c WHERE c.firstName = :firstName AND c.lastName = :lastName " +
            "AND c.address = :address AND c.dateOfBirth = :dateOfBirth AND c.email = :email " +
            "AND c.homePhone = :homePhone AND c.cellPhone = :cellPhone")
    Optional<Long> findIdByCustomerInfo(@Param("firstName") String firstName, @Param("lastName") String lastName,
                                        @Param("address") String address, @Param("dateOfBirth") String dateOfBirth,
                                        @Param("email") String email, @Param("homePhone") String homePhone,
                                        @Param("cellPhone") String cellPhone);
}
