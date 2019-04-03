package davidkm2.finalenergy.model;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "year", "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"})
public class SecondResponse {
    private int year;
    private Double January;
    private Double February;
    private Double March;
    private Double April;
    private Double May;
    private Double June;
    private Double July;
    private Double August;
    private Double September;
    private Double October;
    private Double November;
    private Double December;
}
