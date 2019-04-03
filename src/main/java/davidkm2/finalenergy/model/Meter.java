package davidkm2.finalenergy.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mtrid;
    private double consumption;
    private Date meterdate;
    @OneToOne(mappedBy = "meter")
    private Data data;
}
