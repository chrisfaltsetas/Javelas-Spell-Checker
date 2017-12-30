import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class  URLtextReader extends HTMLEditorKit.ParserCallback {
	
	private StringBuffer s;

    public URLtextReader() {
    }

    public void parse(BufferedReader in) throws IOException {
        s = new StringBuffer();
        ParserDelegator delegator = new ParserDelegator();
        // the third parameter is TRUE to ignore charset directive
        delegator.parse(in, this, Boolean.TRUE);
    }

    public void handleText(char[] text, int pos) {
        s.append("\n");
        s.append(text);
    }

    public String getText() {
        return s.toString();
    }
    
    public void removeHTMLTags(String url) {
    	try {
    	URL link = new URL(url);//put the URL
	    BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream(),"UTF8"));
        //FileReader in = new FileReader("java-new.html");
	    parse(in);
	    in.close();
	   // System.out.println(getText());
    	} catch (Exception e) {
    		 System.out.println("THIS IS NOT A FUCKING URL OR CHANGE WIND PUT VODAFONE");
    	}
	    
    }

    public static void main( String args[]) {
    	System.out.println("PUT THE FUCKING URL MO111111!!!!!1111!1!1!!!!1ENA");
    	Scanner readUrl = new Scanner(System.in);
    	String url = readUrl.nextLine();
    	readUrl.close();
    	URLtextReader test = new URLtextReader();
    	test.removeHTMLTags(url);
    	System.out.println(test.getText());
    }
}