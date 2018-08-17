package com.wen.mallcust.service;

import com.wen.mallcust.model.Good;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
/**
 * @Author wqp
 * @Description 商品业务类
 * @Date 16:05 2018/7/13
 **/
@Service
public class GoodService {
    private Logger logger = LoggerFactory.getLogger(GoodService.class);
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @Method: get
     * @Description: 根据id查询指定的商品信息
     * @param id
     * @return org.springframework.http.ResponseEntity<com.wen.mallcust.model.Good>
     * @throws
     */
    public ResponseEntity<Good> get(int id){
        Map<String,Object> uriVariables = new HashMap<>();
        uriVariables.put("id",id);
        ResponseEntity<Good> responseEntity = restTemplate.getForEntity("http://192.168.0.108:8088/findGoods/{id}",Good.class,uriVariables);
        logger.info("商品信息："+responseEntity.getBody().toString());
        return responseEntity;
    }

    public ResponseEntity<Good> findGoods(){
        return  null;
    }
}
