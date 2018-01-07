import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;

public class GridLayoutDemo {
	public static void main(String[] args) {
		JFrame jf = new JFrame("Javelas Spelling");
		jf.setBounds(800,400,1000,800);
		jf.setLayout(new GridLayout(3,1));
		jf.add(new JButton("Skip this word"));
		jf.add(new JButton("Skip this word every time"));
		jf.add(new JButton("Add to dictionary"));


		jf.setVisible(true);

	}
}