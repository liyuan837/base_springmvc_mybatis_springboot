package com.liyuan.demo;

import com.google.gson.Gson;
import com.liyuan.demo.service.impl.QiNiuServiceImpl;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private QiNiuServiceImpl qiNiuService;
	@Test
	public void uploadFile() throws QiniuException {
		String fileName = "D:/temp/badges.zip";
		File file = new File(fileName);
		assertTrue(file.exists());
		Response deleteResponse = qiNiuService.delete("badges.zip");
		assertTrue(deleteResponse.isOK());
		System.out.println(deleteResponse.bodyString());

		Response response = qiNiuService.uploadFile(file);
		assertTrue(response.isOK());
		//解析上传成功的结果
		DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		System.out.println(putRet.key);//根据 http://域名/key 就能访问文件
		System.out.println(response.bodyString());
	}

	@Test
	public void contextLoads() {
	}

}
