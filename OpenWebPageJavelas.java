import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class OpenWebPageJavelas {

    public  static void main(String [] args) {
        System.out.println("Enter your url:");
	Scanner input = new Scanner(System.in);
	String url = input.nextLine();
	JFrame jf = new JFrame("Opening with browser");
	JButton site = new JButton("Go to my site");
	jf.setBounds(0,0,800,600);
	jf.setLayout(new BorderLayout());
	jf.add(site,BorderLayout.CENTER);
	jf.setVisible(true);

	site.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	        openWebPage(url);
            }
	});
    }

    public static void openWebPage(String url) {
	    try {
	        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	    }
	    catch (java.io.IOException e) {
	        System.out.println(e.getMessage());
	    }
    }
}
