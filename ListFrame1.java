import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;


public class ListFrame1 extends JFrame{

    Word word = new Word(null);
    Suggestions suggestions = new Suggestions(word);

	private final JList<String> menuJList;
	private final String[] menu = {"The word doesn't exist.",
	              word.getWordStr() ,
	              "\t1) Skip this word",
	              "\t2) Skip this word every time",
	              "\t3) Add to dictionary",
				  "\tChoice: "};




	public ListFrame1() {
		super("Options");
		setLayout(new FlowLayout());

		menuJList = new JList<String>(menu);
		menuJList.setVisibleRowCount(5);

		menuJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(new JScrollPane(menuJList));


	}

}

