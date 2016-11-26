import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
public class SendSMS {
	
	public static void main(String args[])
	{
		String message = sendSms();
		
		System.out.println("Status "+ message);
	}
	
	
	public static String sendSms() 
	{	
		try 
		{
			// Construct data
			String user = "username=" + "arun.naagarajan@gmail.com";
			String hash = "&hash=" + "70f10147403cb244c720fc71f5c65b92ae6193d5";
			String message = "&message=" + "Message is sent from Arun through Java code";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "919791826428";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.textlocal.in/send/").openConnection();
			String data = user + hash + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}