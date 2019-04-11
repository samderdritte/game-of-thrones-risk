import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MapPanel extends JPanel {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4727595370439989946L;

	public MapPanel() {
		Dimension size = getPreferredSize();
		size.width = 1000;
		setPreferredSize(size);
		
		setLayout(new GridLayout(1, 1, 5, 5));
		
		ImageIcon mapImageIcon = new ImageIcon("Westeros_Map.jpg");
		JScrollPane mapScrollPane = new JScrollPane(new JLabel(mapImageIcon));
		mapScrollPane.setPreferredSize(new Dimension(1000, 1488));
		add(mapScrollPane);
		
		
	}

	
}
