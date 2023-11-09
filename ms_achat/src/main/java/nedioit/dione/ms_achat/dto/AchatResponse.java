package nedioit.dione.ms_achat.dto;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nedioit.dione.ms_achat.entities.Achat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchatResponse {

    private Long id;
    private LocalDate date;
    private List<Long> products;
    private String currency;
    private double total;


    public AchatResponse(Achat achat) {
        this.id = achat.getId();
        this.date = achat.getDate();
        this.currency = achat.getCurrency();
        this.total = achat.getTotal();
    }
}

