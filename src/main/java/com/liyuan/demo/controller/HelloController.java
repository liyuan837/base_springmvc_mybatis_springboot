package com.liyuan.demo.controller;

import com.liyuan.demo.controller.base.BaseController;
import com.liyuan.demo.entity.exception.DemoException;
import com.liyuan.demo.entity.response.ResponseEntity;
import com.liyuan.demo.utils.CodeGenerateUtil;
import com.liyuan.demo.utils.HtmlToImageUtil;
import com.liyuan.demo.utils.ZipUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author:LiYuan
 * @description:生成二维码、工牌模板
 * @Date:Create in 11:03 2018/2/8
 * @Modified By:
 */
@RestController
public class HelloController extends BaseController{
    @GetMapping("/hello")
    public void hello(HttpServletResponse response) throws Exception {
        String[] names = new String[]{"斑马","花千骨"};
        String[] headerUrls = new String[]{"https://img.1000.com/ehome/dev/00001/1524622911124.jpg@279w_273h_1e_1c_200-2ci.png","https://img.1000.com/ehome/dev/1234/1524640419025.jpg?x-oss-process=image/resize,w_279,h_273/circle,r_200"};
        String[] codeUrls = new String[]{"http://www.dyjkglass.com/erweima.png","http://www.dyjkglass.com/erweima.png"};

//       String baseUrl = this.getClass().getClassLoader().getResource("template/img/code/erweima.png").getPath();
        //String baseUrl = this.getClass().getClassLoader().getResource("template/").getPath();
        String baseUrl = "";
        if(('\\'+"").equals(File.separator)){
            //windwo系统下
            baseUrl = "D:\\temp\\";
        }else{
            baseUrl = "/root/temp/";
        }

        File isExistFile = new File(baseUrl);
        if(!isExistFile.exists()){
            isExistFile.mkdir();
            File codeFile = new File(baseUrl + "code");
            codeFile.mkdir();
            File badgeFile = new File(baseUrl + "badge");
            badgeFile.mkdir();
        }

        //[1]生成二维码
        String[] codeImgUrls = new String[codeUrls.length];
        for(int i=0;i<codeUrls.length;i++){
            String codeUrl = baseUrl+"code"+ File.separator+"code"+i+".png";
            System.out.println(codeUrl);
            CodeGenerateUtil.createCode(codeUrls[i],codeUrl);
            codeImgUrls[i] = codeUrl;
        }

        String inputFilename = baseUrl + "new.html";
        //生成模板图片
        HtmlToImageUtil util = new HtmlToImageUtil();
        for (int i = 0; i < names.length; i++) {

            util.setSize(1087,660);
            util.setInputFilename(inputFilename);

            util.setOutputFilename("out" + i + ".png");

            util.dealTemplate(headerUrls[i], names[i], "code"+ File.separator+"code"+i+".png");
            util.convertToImage();
        }
        util = null;
    }

    /*
   * 上传多个文件:produces属性防止乱码
   */
    @RequestMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity uploadFiles(@RequestParam("file_upload") MultipartFile[] files) throws Exception {
        String realPath;
        for(int i=0;i<files.length;i++){
            if (!files[i].isEmpty()) {
                String uniqueName=files[i].getOriginalFilename();//得到文件名

                realPath="E:"+ File.separator+uniqueName;//文件上传的路径这里为E盘
                files[i].transferTo(new File(realPath));  // 转存文件
            }
        }
        return getSuccessResult();
    }

    /*
   * 下载多个文件
   */
    @RequestMapping(value = "/download")
    public ResponseEntity downloadFiles(HttpServletResponse response) {
        //定义目标文件的完整路径
        String[] paths = new String[]{"E:/pic/1.png", "E:/img/2.png"};

        //定义压缩后文件的临时路径
        String uri = "d:" + File.separator + "download.zip";//临时文件存储路径
        ZipUtil.compress(uri, paths);

        File zipFile = new File(uri);
        try {
            // 以流的形式下载文件
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(zipFile));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-Disposition", "attachment;filename=" + zipFile.getName());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            zipFile.delete();    //将生成的服务器端文件删除
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return getSuccessResult();
    }
}
