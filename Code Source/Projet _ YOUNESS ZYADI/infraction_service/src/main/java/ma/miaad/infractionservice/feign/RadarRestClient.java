package ma.miaad.infractionservice.feign;

import ma.miaad.infractionservice.models.Radar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "radar-service")
public interface RadarRestClient {
    @GetMapping("radars/{id}")
    Radar getByRadarById(@PathVariable Long id);
}
