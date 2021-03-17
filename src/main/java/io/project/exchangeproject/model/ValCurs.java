package io.project.exchangeproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ValCurs implements Serializable {
    @JacksonXmlProperty(localName = "Valute")
    private List<Valute> valute;
    @JacksonXmlProperty(localName = "Date")
    private String date;
    @JacksonXmlProperty
    private String name;

    public ValCurs(List<Valute> valute, String date, String name) {
        this.valute = valute;
        this.date = date;
        this.name = name;
    }

    public ValCurs() {
    }
}
