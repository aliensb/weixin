package win.ccav1.tools;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2016/11/12.
 */
public class Utiles {
    public static boolean checkwx(String timestamp, String nonce, String token, String signature) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(timestamp);
        arr.add(token);
        arr.add(nonce);
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
            System.out.println(arr.get(i));
        }
        String miwen = DigestUtils.sha1Hex(sb.toString());
        if (miwen.equals(signature)) {
            return true;
        } else {
            return false;

        }
    }
}
