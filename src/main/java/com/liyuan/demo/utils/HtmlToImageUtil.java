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

        FileOutputStream fos = new FileOutputStream(inputFilename, false);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write("<html>\n" +
                " <head> \n" +
                "  <meta charset=\"UTF-8\"/> \n" +
                "  <title>工作证</title> \n" +
                " </head> \n" +
                " <body> \n" +
                "  <div class=\"employeecard\" style=\"background: url('http://pic.qianmi.com/ejz/ejz2.0/static/images/ggz-bg.jpg') no-repeat center;width: 1087px;height: 660px;position: relative\"> \n" +
                "   <h3 class=\"title\" style=\"font-size: 100px;font-weight: 500;position: absolute;right: 100px;top: 40px;margin: 0;letter-spacing: 20px\">工作证</h3> \n" +
                "   <img id=\"code\" class=\"ewm\" src=\""+codeUrl+"\" width=\"178\" height=\"178\" alt=\"\" style=\"position: absolute;right: 113px;bottom: 145px\"/> \n" +
                "   <span id=\"name\" class=\"name\" style=\"font-size: 62.5px;position: absolute;bottom: 263px;left: 480px;font-weight: bold;letter-spacing: 20px\">"+name+"</span> \n" +
                "   <div class=\"tx\" style=\"width: 279px;height: 273px;overflow: hidden;position: absolute;left: 107px;bottom: 196px\"> \n" +
                "    <img id=\"header\" src=\""+headerUrl+"\" alt=\"\" style=\"width: 100%;display: block\"/> \n" +
                "   </div> \n" +
                "  </div>  \n" +
                " </body>\n" +
                "</html>");
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
