package cc.openkit.common;

import java.io.*;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class KitFileUtil {
    /**
     * 获得指定文件的byte数组,根据文件路径
     * @param multfile
     * @return
     */
    public static byte[] getMultipartFileToBytes(MultipartFile multfile){
        byte[] buffer = null;
        // MultipartFile 转 filef
        CommonsMultipartFile cf = (CommonsMultipartFile)multfile;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file = fi.getStoreLocation();
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 获得指定文件的byte数组,根据文件路径
     * @param filePath 文件路径
     * @return
     */
    public static byte[] getBytesByFilePath(String filePath){
        return getBytes(filePath);
    }

    /**
     * 获得指定文件的byte数组,根据文件路径
     * @param filePath 文件路径
     * @return
     */
    @Deprecated
    public static byte[] getBytesToMultipartFile(String filePath){
        return getBytes(filePath);
    }

    private static byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 根据byte数组，生成文件
     * @param bfile 需要保存的数组
     * @param filePath 需要保存的文件路径
     * @param fileName 需要保存的文件的名称
     */
    public static void getBytesToFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath+"\\"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
