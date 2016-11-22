package win.ccav1.test;

import java.io.IOException;

/**
 * Created by paul on 2016/11/22.
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        String cellValue = "我的家在1东北\"淞沪2江上\"";
        System.out.println(cellValue.replaceAll("\"", "\\\\\\\\\""));
        System.out.println(cellValue.replace("\"", "\\\\\""));
    }
}
