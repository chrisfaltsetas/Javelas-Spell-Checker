import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class FlowLayoutJavelas {
	
    public static void main(String[] args) {
	    
        JFrame jf = new JFrame("Javelas Spelling");
	jf.setBounds(800,400,800,600); // 800: left- right , 400: up-down

	jf.setLayout(new FlowLayout());
	jf.add(new JButton("Skip this word"));
	jf.add(new JButton("Skip this word every time"));
	jf.add(new JButton("Add to dictionary"));
	jf.setVisible(true);
    }   

}
