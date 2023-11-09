package nedioit.dione.ms_achat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchatRequest {

    private LocalDate date;
    private List<Long> products;
    private String currency;
    private double total;

}
