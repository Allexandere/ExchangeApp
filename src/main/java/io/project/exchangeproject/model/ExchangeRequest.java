package io.project.exchangeproject.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ExchangeRequest")
public class ExchangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "source_valute")
    private String SourceValute;
    @Column(name = "target_valute")
    private String TargetValute;
    @Column(name = "source_amount")
    private double SourceAmount;
    @Column(name = "target_amount")
    private double TargetAmount;
    @Column(name = "date")
    private LocalDateTime Date;

    public ExchangeRequest(String sourceValute, String targetValute, double sourceAmount) {
        this.SourceValute = sourceValute;
        this.TargetValute = targetValute;
        this.SourceAmount = sourceAmount;
    }

    public ExchangeRequest() {
    }
}
