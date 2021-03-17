package io.project.exchangeproject.service;

import io.project.exchangeproject.model.ExchangeRequest;
import io.project.exchangeproject.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.List;

@Service
@Transactional
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ValuteService valuteService;

    public ExchangeRequest createRecord(ExchangeRequest exchangeRequest) {
        return historyRepository.createRecord(exchangeRequest);
    }

    public List<ExchangeRequest> getRecords(){
        return  historyRepository.getRecords();
    }

    public double calculateCurrency(ExchangeRequest request) {
        double base = Double.parseDouble(valuteService.getValuteByCode(request.getSourceValute().substring(0, 3)).getValue().replace(",", "."));
        double target = Double.parseDouble(valuteService.getValuteByCode(request.getTargetValute().substring(0, 3)).getValue().replace(",", "."));
        return Math.round(request.getSourceAmount() * base * 100 / target) / 100.0;
    }
}
