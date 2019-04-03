package davidkm2.finalenergy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressIdentity implements Serializable {


    @NotNull
    @Size(max = 25)
    private String country;

    @NotNull
    private int postcode;

    @NotNull
    @Size(max = 25)
    private String city;

    @NotNull
    @Size(max = 25)
    private String street;

    @NotNull
    private int housenumber;

    @Size(max = 25)
    private String otherinfo;
}
