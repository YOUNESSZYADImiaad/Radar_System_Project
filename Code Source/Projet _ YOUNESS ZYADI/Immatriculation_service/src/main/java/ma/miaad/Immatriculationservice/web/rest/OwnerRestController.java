package ma.miaad.Immatriculationservice.web.rest;


import ma.miaad.Immatriculationservice.entites.Owner;
import ma.miaad.Immatriculationservice.repositories.OwnerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")

public class OwnerRestController {
    private final OwnerRepository ownerRepository;

    public OwnerRestController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    // Get all owners
    @GetMapping("/owners")
    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    // Get owner by id
    @GetMapping("/owners/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Owner %s not found !", id)));
    }


    // Save owner
    @PostMapping("/owners")
    public Owner saveOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    // Update owner
    @PutMapping("/owners/{id}")
    public Owner updateOwner(@PathVariable Long id, @RequestBody Owner owner) {
        Owner o = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Owner %s not found !", id)));

        if (owner.getName() != null) o.setName(owner.getName());
        if (owner.getEmail() != null) o.setEmail(owner.getEmail());
        if (owner.getBirthDate() != null) o.setBirthDate(owner.getBirthDate());
        if (owner.getVehicles() != null) o.setVehicles(owner.getVehicles());

        return ownerRepository.save(o);
    }

    // Delete owner
    @DeleteMapping("/owners/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerRepository.deleteById(id);
    }

}
