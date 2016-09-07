package test.urlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class UrlEncode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(URLEncoder.encode("Business Intelligence & Research Services", "UTF-8"));
		System.out.println(Charset.forName("UTF-8").encode("Business Intelligence & Research Services"));
	}

}
