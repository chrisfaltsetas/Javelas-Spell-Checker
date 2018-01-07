import javax.swing.JFrame;

public class ListTest {
	public static void main(String[] args) {
		GridLayoutDemo gd = new GridLayoutDemo();
		gd.showList();

		ListFrame1 listFrame = new ListFrame1();
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.setSize(450, 250);
		listFrame.setVisible(true);
	}

}