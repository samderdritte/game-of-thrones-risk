import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	
	private DetailsPanel detailsPanel;
	private MapPanel mapPanel;
	private StatisticsPanel statisticsPanel;
	
	public MainFrame(String title) {
		super(title);
		
		// Set layout manager
		setLayout(new BorderLayout());
		
		// Create Swing component
		detailsPanel = new DetailsPanel();
		mapPanel = new MapPanel();
		statisticsPanel = new StatisticsPanel();
		
		detailsPanel.addDetailListener(new DetailListener() {
			public void detailEventOccurred(DetailEvent event) {
				String text = event.getText();
				
				/// do something here when button is pressed
			}
		});
		
		// Add Swing components to content pane
		Container c = getContentPane();
		
		c.add(mapPanel, BorderLayout.CENTER);
		c.add(detailsPanel, BorderLayout.WEST);
		c.add(statisticsPanel, BorderLayout.SOUTH);
		
		// Add behavior
	}
}
