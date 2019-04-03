package davidkm2.finalenergy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestAddress {
    @EmbeddedId
    private AddressIdentity addressIdentity;
    private int addrid;
    @Column(insertable = false, updatable = false)
    private String country;
    @Column(insertable = false, updatable = false)
    private int postcode;
    @Column(insertable = false, updatable = false)
    private String city;
    @Column(insertable = false, updatable = false)
    private String street;
    @Column(insertable = false, updatable = false)
    private int number;
    @Column(insertable = false, updatable = false)
    private String otherinfo;
}
