package io.project.exchangeproject.service;

import io.project.exchangeproject.model.Valute;
import io.project.exchangeproject.repository.ValuteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ValuteService {

    @Autowired
    private ValuteRepository valuteRepository;

    public Valute crateValute(Valute valute){
        return valuteRepository.createValute(valute);
    }

    public List<String> getValuteCodes(){
        return valuteRepository.getValutesCode();
    }

    public Valute getValuteByCode(String code){
        return valuteRepository.getValuteByCode(code);
    }
}
