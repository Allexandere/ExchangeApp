package io.project.exchangeproject.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${exchange.feign.config.name}", url = "${exchange.feign.config.url}")
public interface ExchangeApi {

    @GetMapping(value = "/XML_daily.asp")
    String readValutes(@RequestParam String date_req);

}
