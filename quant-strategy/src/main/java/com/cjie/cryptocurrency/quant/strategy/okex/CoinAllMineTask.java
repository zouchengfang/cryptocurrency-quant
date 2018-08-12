package com.cjie.cryptocurrency.quant.strategy.okex;


import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CoinAllMineTask {

    @Autowired
    private CoinAllMineService mineService;

    @Scheduled(cron = "*/10 * * * * ?")
    public void mineCurrency1() throws JobExecutionException {
        log.info("start mining");
        try {
            mineService.mine1("cac", "usdt", 0.002);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("end mining");


    }
    //@Scheduled(cron = "*/20 * * * * ?")
    public void mineCurrency3() throws JobExecutionException {
        log.info("start mining");
        //log.info(JSON.toJSONString(spotAccountAPIService.getAccountByCurrency("btc")));
        try {
            mineService.mine3("cac", "usdt", 0.005, 0.5);
            //mineService.mine3("cac", "eth", 0.005);
        } catch (Exception e) {
            log.error("error mining", e);
        }
        log.info("end mining");


    }
}
