package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.RecursiveTask;
/**
 * @Author wqp
 * @Description 验证码生成器
 * @Date 10:52 2018/7/12
 **/
public class ValidateCode {
    /**
     * 图片的宽度
     */
    private int width = 160;
    /**
     * 图拍的高度
     */
    private int height = 40;
    /**
     * 验证码字符个数
     */
    private int codeCount = 5;
    /**
     *  验证码干扰线数
     */
    private int lineCount = 150;
    /**
     * 验证码
     */
    private String code = null;
    /**
     * 验证码图片buffer
     */
    private BufferedImage bufferedImage = null;
    /**
     * 验证码范围。去掉0（数字）和o（字母）容易混淆。去掉小写的i和1；
     */
    private char[] codeSequence = {'A','B','C','D','E','F','G','H','I'
            ,'J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','1'
            ,'2','3','4','5','6','7','8','9'};


    public ValidateCode() {
        this.createCode();
    }

    /**
     * @param width 宽
     * @param height 高
     */
    public ValidateCode(int width, int height) {
        this.width = width;
        this.height = height;
        this.createCode();
    }

    /**
     * @param width         宽
     * @param height        高
     * @param codeCount     字符个数
     * @param lineCount     干扰线条数
     */
    public ValidateCode(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createCode();
    }

    public void createCode(){
        int x=0, fontHeight = 0, codeY = 0;
        int red = 0, green = 0,blue = 0;

        //每个字符的宽度（左右各空出一个字符）
        x = width/(codeCount+2);
        //字体的高度
        fontHeight = height - 2;
        codeY = height - 4;

        //图像的buffer
        bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g=bufferedImage.createGraphics();

        Random random = new Random();

        g.setColor(Color.white);
        g.fillRect(0,0,width,height);

        //创建字体，可以修改为其他的
        Font font = new Font("Fixedsys",Font.PLAIN,fontHeight);
        g.setFont(font);

        for (int i = 0;i <lineCount; i++){
            //设置随机开始和结束坐标
            //x坐标开始
            int xs = random.nextInt(width);
            //y坐标开始
            int ys = random.nextInt((height));
            //x坐标结束
            int xe = xs + random.nextInt(width/8);
            //y坐标结束
            int ye = ys + random.nextInt(height/8);
            //产生随机的颜色值，让输出的每个字符的颜色值都将不同
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red,green,blue));
            g.drawLine(xs,ys,xe,ye);
        }
        //randomCode记录随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        //随机产生codeCount个字符的验证码
        for (int i = 0;i<codeCount;i++){
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            //产生随机的颜色值，让输出的每个字符的颜色值都将不同
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red,green,blue));
            g.drawString(strRand,(i+1)*x,codeY);
            //将产生的四个随机数组合在一起
            randomCode.append(strRand);
        }
        //将四位数的验证码保存到session中
        code = randomCode.toString();
    }

    public void write(String path) throws IOException {
        OutputStream sos = new FileOutputStream(path);
        this.write(sos);
    }

    public void write(OutputStream sos) throws IOException{
        ImageIO.write(bufferedImage,"png",sos);
        sos.close();
    }

    public BufferedImage getBufferedImage(){
        return  bufferedImage;
    }

    public String getCode() {
        return code;
    }
    public static void main(String[] args) throws IOException {
        ValidateCode validateCode = new ValidateCode(160,40,5,300);
        String path = "D:/"+System.currentTimeMillis() +".png";
        System.out.println(validateCode.getCode()+" >"+path);
        validateCode.write(path);
    }
}
