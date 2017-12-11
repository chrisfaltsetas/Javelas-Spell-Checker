import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLconnection{
	public static void main(String[] args) throws Exception{
		URL oracle = new URL("https://www.mikrosapoplous.gr/prometheus/prom.htm");//put the URL
	    BufferedReader in = new BufferedReader(
	    new InputStreamReader(oracle.openStream(),"UTF8"));

	    String inputLine;
	    while ((inputLine = in.readLine()) != null)
	        System.out.println(inputLine);
	    in.close();
	}
	 


	
}
