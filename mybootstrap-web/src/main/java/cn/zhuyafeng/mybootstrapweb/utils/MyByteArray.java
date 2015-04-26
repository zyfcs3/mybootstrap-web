package cn.zhuyafeng.mybootstrapweb.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class MyByteArray {

       public static byte[] getByteArray(Object obj){
           ByteArrayOutputStream bos =  new ByteArrayOutputStream();
           ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            byte[] byteArray = bos.toByteArray();
               oos.close();
               bos.close();
               return byteArray;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
          return null;
    }
       
       
       public static Map<String, Object> getObject(byte[] obj){
          
        try {
            ByteArrayInputStream bis =  new ByteArrayInputStream(obj);
            ObjectInputStream inputStream =  new ObjectInputStream(bis);
            Map<String, Object> readObject = (Map<String, Object>)inputStream.readObject();
              return readObject;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
          return null;
    }
}
