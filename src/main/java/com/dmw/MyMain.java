package com.dmw;

import com.utils.FastDFSClient;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.UUID;

public class MyMain {
    @Test
    public void testUpload(){
        try {
            File file = new File("D:/a.png");
            InputStream is = new FileInputStream(file);
            String fileName = UUID.randomUUID().toString()+".png";
            String[] result = FastDFSClient.uploadFile(is, fileName);
            // [group1, M00/00/00/wKhIyWNrjeKARJ-qAABgCDOzGCI022.png]
            System.out.println(Arrays.toString(result));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDownload(){
        try {
            InputStream is = FastDFSClient.downloadFile("group1", "M00/00/00/wKhIyWNrjeKARJ-qAABgCDOzGCI022.png");
            OutputStream os = new FileOutputStream(new File("D:/jqk.png"));
            int index = 0 ;
            while((index = is.read())!=-1){
                os.write(index);
            }
            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
