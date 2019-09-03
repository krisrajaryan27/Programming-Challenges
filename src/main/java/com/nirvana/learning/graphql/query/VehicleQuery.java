package com.nirvana.learning.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nirvana.learning.graphql.entity.Vehicle;
import com.nirvana.learning.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author krishnaV
 */
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService vehicleService;
    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleService.getVehicle(id);
    }
}
