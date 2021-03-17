package io.project.exchangeproject.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "valute")
@JacksonXmlRootElement(localName = "Valute")
public class Valute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JacksonXmlProperty
    @Column(name = "num_code")
    private int NumCode;
    @JacksonXmlProperty
    @Column(name = "char_code")
    private String CharCode;
    @JacksonXmlProperty
    @Column(name = "nominal")
    private int Nominal;
    @JacksonXmlProperty
    @Column(name = "name")
    private String Name;
    @JacksonXmlProperty
    @Column(name = "value")
    private String Value;
    @JacksonXmlProperty(localName = "ID")
    @Column(name = "string_id")
    public String StringID;

    public Valute(int NumCode, String CharCode, int Nominal, String Name, String Value, String StirngID) {
        this.NumCode = NumCode;
        this.CharCode = CharCode;
        this.Nominal = Nominal;
        this.Name = Name;
        this.Value = Value;
        this.StringID = StirngID;
    }

    public Valute() {
    }
}
