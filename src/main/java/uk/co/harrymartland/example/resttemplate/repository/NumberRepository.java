package uk.co.harrymartland.example.resttemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<NumberEntity, Integer> {

    @Query(nativeQuery = true, value = "select :theNumber as number")
    NumberEntity findNumber(@Param("theNumber") Integer theNumber);
}
