package io.project.exchangeproject.config;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.project.exchangeproject.client.ExchangeApi;
import io.project.exchangeproject.model.ValCurs;
import io.project.exchangeproject.model.Valute;
import io.project.exchangeproject.service.ValuteService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ValuteConfig implements InitializingBean {

    @Autowired
    private ExchangeApi exchangeApi;
    @Autowired
    private ValuteService valuteService;

    @Override
    public void afterPropertiesSet() throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String today = dtf.format(now);
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
        ValCurs valCurs = xmlMapper.readValue(exchangeApi.readValutes(today), ValCurs.class);
        for (Valute valute : valCurs.getValute()){
            valuteService.crateValute(valute);
        }
    }
}
