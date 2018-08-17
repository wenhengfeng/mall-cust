package com.wen.mallcust.control;

import com.wen.mallcust.model.Good;
import com.wen.mallcust.service.GoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

@RestController("/good")
public class GoodController {
    private Logger logger = LoggerFactory.getLogger(GoodController.class);
    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "/findGood/{id}")
    public ResponseEntity<Good> findGood(@PathVariable int id){
        logger.info("获取商品的id:"+id);
        return  goodService.get(id);
    }
}
