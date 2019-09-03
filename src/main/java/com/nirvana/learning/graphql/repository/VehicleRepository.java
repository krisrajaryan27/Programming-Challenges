package com.nirvana.learning.graphql.repository;

import com.nirvana.learning.graphql.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author krishnaV
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
