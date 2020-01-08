package com.jc.microservices.currencyconversionservice.proxy;

import com.jc.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//With ribbon you only use the service's name, since the micro instances you want to call from here will be set in application.properties
//@FeignClient(name = "currency-exchange-service",
//            url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
//We just installed Zuul, so now we want to call to the other microservice using our Zuul gateway
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    //We just installed Zuul, so now we want to call to the other microservice using our Zuul gateway
    //@GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
