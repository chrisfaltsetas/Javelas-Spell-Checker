import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class URLtextReader extends HTMLEditorKit.ParserCallback {
	
    private StringBuffer s;

    public URLtextReader() {
    }
    
    public String removeHTMLTags(String url) {
    	try {
	    	URL link = new URL(url);
		    BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream(), "UTF8"));
		    parse(in);
		    in.close();
		    return s.toString();
    	} catch (Exception e) {
            System.out.println("There was an error reading the URL: " + e);
            return null;
    	}
    }

    public void parse(BufferedReader in) throws IOException {
        s = new StringBuffer();
        ParserDelegator delegator = new ParserDelegator();
        delegator.parse(in, this, true);
    }

    public void handleText(char[] text, int pos) {
        s.append("\n");
        s.append(text);
    }
}
