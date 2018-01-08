import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;

public class GridLayoutJavelas {
	
    public void showList() {
        JFrame jf = new JFrame("Javelas Spelling");
	jf.setBounds(200,100,250,200);	
	jf.setLayout(new GridLayout(3,1));
        jf.add(new JButton("Skip this word"));
	jf.add(new JButton("Skip this word every time"));
	jf.add(new JButton("Add to dictionary"));
	jf.setVisible(true);
    }
}
