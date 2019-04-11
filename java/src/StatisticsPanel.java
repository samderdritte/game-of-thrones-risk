import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class StatisticsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4613217513873281426L;

	public StatisticsPanel() {
		Dimension size = getPreferredSize();
		size.width = 400;
		size.height = 100;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Statistics"));
		
		setLayout(new GridBagLayout());
	}
}
