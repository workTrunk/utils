package com.github.chenlijia1111.utils.image;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * 二维码工具类
 *
 * @author chenlijia
 * @version 1.0
 * @since 2019/7/12 0012 下午 3:25
 **/
public class QRCodeUtil {

    private static final String format = "png";

    private BitMatrix bitMatrix;

    /**
     * 生成二维码
     *
     * @param msg 信息
     */
    private void createQRCode(String msg) throws WriterException {
        int width = 300;
        int height = 300;
        HashMap<EncodeHintType, Object> hashMap = new HashMap<>();
        hashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //纠错等级
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //图片边距
        hashMap.put(EncodeHintType.MARGIN, 2);
        bitMatrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE, width, height, hashMap);
    }

    /**
     * 将二维码输出到文件
     *
     * @param content 二维码内容
     * @param file    输出文件
     * @return
     */
    public boolean output(String content, File file) {
        try {
            createQRCode(content);
            MatrixToImageWriter.writeToPath(bitMatrix, format, file.toPath());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将二维码输出到输出流
     *
     * @param content 二维码内容
     * @param output  输出流
     */
    public void output(String content, OutputStream output) {
        try {
            createQRCode(content);
            MatrixToImageWriter.writeToStream(bitMatrix, format, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
