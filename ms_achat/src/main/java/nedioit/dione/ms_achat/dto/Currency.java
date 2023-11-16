package nedioit.dione.ms_achat.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {

    private String base_code;
    private String target_code;
    private double conversion_rate;
}
