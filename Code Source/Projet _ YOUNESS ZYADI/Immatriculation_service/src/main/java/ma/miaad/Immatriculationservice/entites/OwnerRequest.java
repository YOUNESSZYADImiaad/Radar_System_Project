package ma.miaad.Immatriculationservice.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRequest {
    // GraphQL
    private String name;
    private Date birthDate;
    private String email;

}
