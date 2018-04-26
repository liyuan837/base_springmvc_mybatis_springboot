package com.liyuan.demo.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:LiYuan
 * @description:二维码生成器
 * @Date:Create in 15:25 2018/4/23
 * @Modified By:
 * 参考:https://blog.csdn.net/shuaicihai/article/details/76795303
 */
public class CodeGenerateUtil {
    private static int width = 300;
    private static int height = 300;

    public static String createCode( String content, String targetPath) {
        String format = "png";
        //定义二维码的参数
        HashMap map = new HashMap();
        //设置编码
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置纠错等级
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //白边大小0~4
        map.put(EncodeHintType.MARGIN, 1);

        try {
            //生成二维码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,map);

           // bitMatrix = deleteWhite(bitMatrix);//删除白边

            Path file = new File(targetPath).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return targetPath;
    }

    /**
     * 删除白边
     * */
    private static BitMatrix deleteWhite(BitMatrix matrix) {
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (matrix.get(i + rec[0], j + rec[1]))
                    resMatrix.set(i, j);
            }
        }
        return resMatrix;
    }

    public static String decodeCode(String codeUrl) {
        try {
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            File file = new File(codeUrl);
            BufferedImage image = ImageIO.read(file);
            //定义二维码参数
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

            //获取读取二维码结果
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Result result = multiFormatReader.decode(binaryBitmap, hints);

            System.out.println("读取二维码： " + result.toString());
            System.out.println("二维码格式： " + result.getBarcodeFormat());
            System.out.println("二维码内容： " + result.getText());
            return result.toString();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
