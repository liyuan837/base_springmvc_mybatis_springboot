package com.liyuan.demo.utils;

import org.xhtmlrenderer.swing.Java2DRenderer;
import org.xhtmlrenderer.util.FSImageWriter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Author:LiYuan
 * @description:操作模板网页并将模板网页转成图片
 * @Date:Create in 14:50 2018/4/23
 * @Modified By:
 */
public class HtmlToImageUtil {
    /**
     * 源模板网页路径
     */
    private String inputFilename;
    /**
     * 输出目标图片路径
     */
    private String outputFilename;

    /**
     * 生成目标图片大小
     */
    private int widthImage = 620;
    private int heightImage = 380;

    public void setInputFilename(String inputFilename){
        this.inputFilename = inputFilename;
    }

    public void setOutputFilename(String outputFilename){
        this.outputFilename = outputFilename;
    }

    public void setSize(int widthImage,int heightImage){
        this.widthImage = widthImage;
        this.heightImage = heightImage;
    }

    /**
     * 参考https://www.cnblogs.com/shihuc/p/5515766.html
     * description:填充网页模板
     * @param headerUrl
     * @param name
     * @param codeUrl
     * @throws Exception
     */
    public void dealTemplate(String headerUrl, String name, String codeUrl) throws Exception {
//        File input = new File(inputFilename);
//        Document doc = Jsoup.parse(input, "UTF-8");
//
//        Element headerImg = doc.getElementById("header");
//        headerImg.attr("src", headerUrl);
//
//        Element nameSpan = doc.getElementById("name");
//        nameSpan.html(name);
//
//        Element codeImg = doc.getElementById("code");
//        codeImg.attr("src", codeUrl);

        //得到系统默认的encoding码
        String fileEncode = System.getProperty("file.encoding");

        FileOutputStream fos = new FileOutputStream(inputFilename, false);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        String html = "<html>\n" +
                " <head> \n" +
                "  <meta charset=\"UTF-8\"/> \n" +
                "  <title>工作证</title> \n" +
                " </head> \n" +
                " <body> \n" +
                "  <div class=\"employeecard\" style=\"background: url('http://pic.qianmi.com/ejz/ejz2.0/static/images/ggz-bg.jpg') no-repeat center;width: 1087px;height: 660px;position: relative\"> \n" +
                "   <h3 class=\"title\" style=\"font-family:'PingFangSC-Medium';font-size: 100px;font-weight: 500;position: absolute;right: 100px;top: 40px;margin: 0;letter-spacing: 20px\">工作证</h3> \n" +
                "   <img id=\"code\" class=\"ewm\" src=\""+codeUrl+"\" width=\"178\" height=\"178\" alt=\"\" style=\"position: absolute;right: 113px;bottom: 145px\"/> \n" +
                "   <span id=\"name\" class=\"name\" style=\"font-family:SimSun;font-size: 62.5px;position: absolute;bottom: 263px;left: 480px;font-weight: bold;letter-spacing: 20px\">"+name+"</span> \n" +
                "   <div class=\"tx\" style=\"width: 279px;height: 273px;overflow: hidden;position: absolute;left: 107px;bottom: 196px\"> \n" +
                "    <img id=\"header\" src=\""+headerUrl+"\" alt=\"\" style=\"width: 100%;display: block\"/> \n" +
                "   </div> \n" +
                "  </div>  \n" +
                " </body>\n" +
                "</html>";
        System.out.println(fileEncode);
//        String html = "<!DOCTYPE html>\n" +
//                "<html>\n" +
//                " <head> \n" +
//                "  <meta charset=\"utf-8\" /> \n" +
//                " </head> \n" +
//                " <body> \n" +
//                "  <div class=\"layout\" style=\"width:620px;height:380px;position:relative;\"> \n" +
//                "   <img src=\"img/model.png\" style=\"width:620px;height:380px;\" /> \n" +
//                "   <img id=\"header\" style=\"width:164px;height:164px;position:absolute;top:106px;left: 60px;\" src='"+headerUrl+"' />\n" +
//                "   <img src=\"img/log_box.png\" style=\"height:380px;position:absolute;top:0px;left:0px;\" /> \n" +
//                "   <img id=\"code\" style=\"position:absolute;width:120px;height:120px;bottom:90px;right:40px;\" src='"+codeUrl+"' />\n" +
//                "   <span id=\"name\" style=\"position:absolute;top:170px;left:290px;color:#999;font-size:32px;font-weight:bold;\">"+name+"</span>\n" +
//                "  </div>  \n" +
//                " </body>\n" +
//                "</html>";
        osw.write(new String(html.getBytes("UTF-8"),fileEncode));
        osw.close();
    }

    /***
     * description:将网页转成图片
     * @throws IOException
     */
    public void convertToImage() throws IOException {
        final File f = new File(inputFilename);
        final Java2DRenderer renderer = new Java2DRenderer(f, widthImage, heightImage);
        final BufferedImage img = renderer.getImage();
        final FSImageWriter imageWriter = new FSImageWriter();
        imageWriter.setWriteCompressionQuality(0.9f);
        imageWriter.write(img, outputFilename);

    }
}
