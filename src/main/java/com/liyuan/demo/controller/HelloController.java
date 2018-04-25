package com.liyuan.demo.controller;

import com.liyuan.demo.utils.CodeGenerateUtil;
import com.liyuan.demo.utils.HtmlToImageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 11:03 2018/2/8
 * @Modified By:
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public void hello(HttpServletResponse response) throws Exception {
        String[] names = new String[]{"斑马","花千骨"};
        String[] headerUrls = new String[]{"https://img.1000.com/ehome/dev/00001/1524622911124.jpg@279w_273h_1e_1c_200-2ci.png","https://img.1000.com/ehome/dev/1234/1524640419025.jpg?x-oss-process=image/resize,w_279,h_273/circle,r_200"};
        String[] codeUrls = new String[]{"http://www.dyjkglass.com/erweima.png","http://www.dyjkglass.com/erweima.png"};

        String baseUrl = this.getClass().getClassLoader().getResource("template/img/code/erweima.png").getPath();

        //[1]生成二维码
        String[] codeImgUrls = new String[codeUrls.length];
        for(int i=0;i<codeUrls.length;i++){
            System.out.println(baseUrl + "/../code" + i + ".png");
            CodeGenerateUtil.createCode(codeUrls[i],baseUrl+"/../code"+i+".png");
            codeImgUrls[i] = baseUrl + "/../code" + i + ".png";
        }

        String inputFilename = this.getClass().getClassLoader().getResource("template/new.html").getPath();

        //生成模板图片
        HtmlToImageUtil util = new HtmlToImageUtil();
        for (int i = 0; i < names.length; i++) {

            util.setSize(1087,660);
            util.setInputFilename(inputFilename);

            util.setOutputFilename("out" + i + ".png");

            util.dealTemplate(headerUrls[i], names[i], codeImgUrls[i]);
            util.convertToImage();
        }
        util = null;

    }
}
