import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class DetailsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3760990711000919290L;
	
	
	private EventListenerList listenerList = new EventListenerList();
	
	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 200;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Current Round"));
		
		JLabel nameLabel = new JLabel("Input: ");

		
		JTextField nameField = new JTextField(10);

		
		JButton addBtn = new JButton("Button");
		
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				
				String text = name+ "\n";
				
				fireDetailEvent(new DetailEvent(this, text));
			}
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		//// First column ////
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(nameLabel, gc);
		
		//// Second column ////
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(nameField, gc);
		
		/// Final row ///
		gc.weighty = 10;
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 2;
		add(addBtn, gc);
	}
	
	public void fireDetailEvent(DetailEvent event) {
		Object[] listeners = listenerList.getListenerList();
		
		for(int i=0; i < listeners.length; i += 2) {
			if(listeners[i] == DetailListener.class) {
				((DetailListener)listeners[i+1]).detailEventOccurred(event);
			}
		}
	}
	
	public void addDetailListener(DetailListener listener) {
		listenerList.add(DetailListener.class, listener);
	}
	
	public void removeDetailListener(DetailListener listener) {
		listenerList.remove(DetailListener.class, listener);
	}
}