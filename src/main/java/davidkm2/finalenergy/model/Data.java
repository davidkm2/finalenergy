package davidkm2.finalenergy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataid;

    @Column(unique = true)
    private String client;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addrid")
    @MapsId
    private Address addr;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meter_id", referencedColumnName = "mtrid")
    @MapsId
    private Meter meter;
}
