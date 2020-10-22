package com.zwl.learn.futurTask;

import cn.hutool.core.codec.Base64;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName FutureTaskTest @Description @Author 二师兄 @Date 2020-08-18 15:52 @Version V1.0
 */
public class FutureTaskTest {
    //  @Override
    //  public String call() throws Exception {
    //
    //    return "测试线程";
    //  }
//
//  public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//    //    FutureTask futureTask = new FutureTask<>(new FutureTaskTest());
//    //    new Thread(futureTask).start();
//    //    String s = (String) futureTask.get();
//    //    System.out.println(s);
//
//    ZwlFutureTask<String> zwlFutureTask = new ZwlFutureTask(new Test001());
//    new Thread(zwlFutureTask).start();
//    String s = zwlFutureTask.get();
//    System.out.println(s);
//
//
//  }

    public static void main(String[] args) throws InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        String key = "wbqEgW0znRL95nv0";
        String content = "15258284159";
        //构建
        if (key == null) {
            System.out.print("Key为空null");
        }
        // 判断Key是否为16位
        if (key.length() != 16) {
            System.out.print("Key长度不是16位");
        }
        byte[] raw = key.getBytes("gb2312");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");//设置密钥规范为AES
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        //CBC模式需要配置偏移量，设置一个向量，达到密码唯一性，增加加密算法的强度
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes());

        String encode = new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能
        System.out.println(encode);
//    DateTime lastWeek = DateUtil.lastWeek();
//    System.out.println(lastWeek);
    }
}
