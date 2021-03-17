package io.project.exchangeproject.controller;

import io.project.exchangeproject.model.ExchangeRequest;
import io.project.exchangeproject.service.HistoryService;
import io.project.exchangeproject.service.ValuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ExchangeController {

    @Autowired
    private ValuteService valuteService;
    @Autowired
    private HistoryService historyService;

    @GetMapping("/exchange")
    public String start(Model model)
    {
        List<String> codes = valuteService.getValuteCodes();

        model.addAttribute("codes", codes);
        model.addAttribute("exchangeRequest", new ExchangeRequest());

        return "exchange";
    }

    @PostMapping("/exchange")
    public String exchange(@ModelAttribute ExchangeRequest exchangeRequest, Model model)
    {
        exchangeRequest.setTargetAmount(historyService.calculateCurrency(exchangeRequest));
        exchangeRequest.setDate(LocalDateTime.now());
        historyService.createRecord(exchangeRequest);
        List<ExchangeRequest> history = historyService.getRecords();
        List<String> codes = valuteService.getValuteCodes();

        model.addAttribute("codes", codes);
        model.addAttribute("exchangeRequest", exchangeRequest);
        model.addAttribute("history", history);

        return "exchange";
    }
}
