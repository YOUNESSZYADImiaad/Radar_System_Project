package ma.miaad.infractionservice.feign;

import ma.miaad.infractionservice.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Immatriculation-service")
public interface VehicleRestClient {
    @GetMapping("api/vehicle/vehicleByRn/{rn}")
    Vehicle getByRegestrationNumber(@PathVariable String rn);
}
