package davidkm2.finalenergy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"addrid", "country", "postcode", "city", "street", "number", "otherinfo"})
)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addrid;
    private String country;
    private int postcode;
    private String city;
    private String street;
    private int number;
    private String otherinfo;
    @OneToOne(mappedBy = "addr")
    private Data data;

    public String getfullAddr(){
        return country + " " + postcode + " " + city + " " + number + " " + otherinfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Address))
            return false;

        Address other = (Address) o;

        return other.getCountry().equals(this.getCountry()) &&
                other.getPostcode()==this.getPostcode() &&
                other.getCity().equals(this.getCity()) &&
                other.getStreet().equals(this.getStreet()) &&
                other.getNumber()==this.getNumber() &&
                other.getOtherinfo().equals(this.getOtherinfo());
    }

    @Override
    public int hashCode(){
        int result = 3;
        result = result * addrid * country.hashCode() * postcode * city.hashCode() * street.hashCode() * number;
        if(otherinfo != null)
            result *= otherinfo.hashCode();
        return result;
    }
}
