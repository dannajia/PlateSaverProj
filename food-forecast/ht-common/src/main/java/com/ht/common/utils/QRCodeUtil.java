package com.ht.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class QRCodeUtil {
    /**
     * create QR code
     *
     * @param content 
     * @param width   
     * @param height  
     * @return
     */
    public String createQRCode(String content, int width, int height) throws IOException {
        String resultImage = "";
        
        if (!StringUtils.isEmpty(content)) {
            ServletOutputStream stream = null;
            ByteArrayOutputStream os = new ByteArrayOutputStream();
          
            @SuppressWarnings("rawtypes")
            HashMap<EncodeHintType, Comparable> hints = new HashMap<>();
            
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
       
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
           
            hints.put(EncodeHintType.MARGIN, 1);

            try {
                
                QRCodeWriter writer = new QRCodeWriter();
                
                BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
                
                BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
                
                ImageIO.write(bufferedImage, "png", os);
        
                resultImage = new String("data:image/png;base64," + EncryptUtil.encodeBase64(os.toByteArray()));
                return resultImage;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("error in QR code creation");
            } finally {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        QRCodeUtil qrCodeUtil = new QRCodeUtil();
        System.out.println(qrCodeUtil.createQRCode("http://192.168.101.1:63030/orders/alipaytest", 200, 200));
    }
}