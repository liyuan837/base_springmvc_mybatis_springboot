package com.liyuan.demo.utils;

import org.xhtmlrenderer.swing.Java2DRenderer;
import org.xhtmlrenderer.util.FSImageWriter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 参考http://bugyun.iteye.com/blog/2280336
 */
public class XHTMLToImage {

    private String inputFilename = "source.xhtml";
    private String outputFilename = "output.png";

    private int widthImage = 620;
    private int heightImage = 380;

    public void convertToImage() throws IOException {
        System.out.println("Calling convertToImage inputFilename=" + inputFilename + " outputFilename=" + outputFilename);
        final File f = new File(inputFilename);
        final Java2DRenderer renderer = new Java2DRenderer(f, widthImage, heightImage);
        final BufferedImage img = renderer.getImage();
        final FSImageWriter imageWriter = new FSImageWriter();
        imageWriter.setWriteCompressionQuality(0.9f);
        imageWriter.write(img, outputFilename);
        System.out.println("Done with rendering");

    }

    /**
     * 参考https://www.cnblogs.com/shihuc/p/5515766.html
     *
     * @throws Exception
     */
    public static void dealTemplate(String sourcePath, String targetPath, String headerUrl, String name, String codeUrl) throws Exception {
        File input = new File(sourcePath);
      /*  Document doc = Jsoup.parse(input, "UTF-8");

        Element headerImg = doc.getElementById("header");
        headerImg.attr("src", headerUrl);

        Element nameSpan = doc.getElementById("name");
        nameSpan.html(name);

        Element codeImg = doc.getElementById("code");
        codeImg.attr("src", codeUrl);

        FileOutputStream fos = new FileOutputStream(targetPath, false);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write(doc.html());
*/
//        osw.close();
//        fos.close();
    }

    public static void main(final String[] args) throws Exception {
        String[] names = new String[]{"斑马","花千骨"};
        String[] headerUrls = new String[]{"https://img.1000.com/ehome/dev/00001/1524622911124.jpg@279w_273h_1e_1c_200-2ci.png","https://img.1000.com/ehome/dev/1234/1524640419025.jpg?x-oss-process=image/resize,w_279,h_273/circle,r_200"};
        String[] codeUrls = new String[]{"http://www.dyjkglass.com/erweima.png","http://www.dyjkglass.com/erweima.png"};

       for(int i=0;i<names.length;i++){
           HtmlToImageUtil util = new HtmlToImageUtil();
           util.setSize(1087,660);
           util.setInputFilename("d:/template/new.html");

           util.setOutputFilename("out"+i+".png");

           util.dealTemplate(headerUrls[i],names[i],codeUrls[i]);
           util.convertToImage();
//           dealTemplate("d:/pic/jiazheng/index.html", "d:/pic/jiazheng/index.html", headerUrls[i], names[i], "http://www.dyjkglass.com/erweima.png");
//
//           final XHTMLToImage renderer = new XHTMLToImage();
//
//           renderer.inputFilename = "d:/pic/jiazheng/index.html";
//           renderer.outputFilename = "out"+i+".png";
//           renderer.convertToImage();
       }
    }
}   