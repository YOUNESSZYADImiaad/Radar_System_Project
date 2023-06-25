package ma.miaad.Immatriculationservice.web.graphql;

import ma.miaad.Immatriculationservice.entites.Owner;
import ma.miaad.Immatriculationservice.entites.OwnerRequest;
import ma.miaad.Immatriculationservice.repositories.OwnerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OwnerGraphqlController {
    private OwnerRepository ownerRepository;

    // Dependencies Injection
    public OwnerGraphqlController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    // - Get all owners
    @QueryMapping
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }

    // - Get owner by id
    @QueryMapping
    public Owner getOwnerById(@Argument Long id){
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Owner %s not found ! ", id)));
    }

    // - Save owner
    @MutationMapping
    public Owner addOwner(@Argument OwnerRequest owner){
        Owner o = new Owner();
        o.setName(owner.getName());
        o.setEmail(owner.getEmail());
        o.setBirthDate(owner.getBirthDate());
        return ownerRepository.save(o);
    }

    // - Delete owner
    @MutationMapping
    public Boolean deleteOwner(@Argument Long id){
        ownerRepository.deleteById(id);
        return true;
    }
}
