package com.wen.mallcust.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.ValidateCode;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author wqp
 * @Description
 * @Date 15:16 2018/7/12
 **/
@Controller(value = "/login")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/code")
    public void code(HttpServletRequest request, HttpServletResponse response){
        ValidateCode validateCode = new ValidateCode(160,40,5,300);
        BufferedImage bufferedImage = validateCode.getBufferedImage();
        logger.info("验证码："+validateCode.getCode());
        if (bufferedImage == null){
            throw new RuntimeException("获取验证码异常：com.wen.mallcust.control.LoginController.code(request,response)");
        }
        if (bufferedImage != null){
            try {
                ImageIO.write(bufferedImage,"JPEG",response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                logger.info("打印验证码异常：com.wen.mallcust.control.LoginController.code(request,response)");
            }
        }
    }

    @RequestMapping(value = "/login")
    public String login(){
        logger.info("进去登录页面...");
        return  "login";
    }
}
