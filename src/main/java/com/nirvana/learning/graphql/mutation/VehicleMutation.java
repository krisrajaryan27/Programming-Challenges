package com.nirvana.learning.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.nirvana.learning.graphql.entity.Vehicle;
import com.nirvana.learning.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author krishnaV
 */
public class VehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private VehicleService vehicleService;

    private Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }
}
