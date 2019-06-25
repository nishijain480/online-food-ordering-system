
package thefood;

import java.io.IOException;
import java.net.*;

public class SendSMS {

    public static String send(String to, String msg) throws MalformedURLException, IOException {
        //String url="http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=thefoodindore@gmail.com:9893303390&senderID=TEST SMS&receipientno="+to+"&dcs=0&msgtxt="+msg+"&state=4";
        //auth key made in indor is used just below( 227757AYbpqoqTDH5b560e4a )
        String url = "http://api.msg91.com/api/sendhttp.php?sender=MSGIND&route=4&mobiles="+to+"&authkey=270408A5HhP2QSPgkj5ca2e6c1&country=91&message="+msg;
       //auth key of nancy id is used just below (270408A5HhP2QSPgkj5ca2e6c1)
     // String url= "http://api.msg91.com/api/sendhttp.php?route=4&mobiles="+to+"&authkey=270408A5HhP2QSPgkj5ca2e6c1&sender=TESTIN&message="+msg+"&country=91";
       
       URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        String res = con.getResponseMessage();
        con.disconnect();

        return res;
    }
}
