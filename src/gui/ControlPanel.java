package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ControlPanel extends JPanel
{

	private static final long serialVersionUID = -4096249866634543665L;

	private JButton PreviousButton;
	private JButton NextButton;
	private static JTextField pageTextField;
	
	public ControlPanel()
	{
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(1280, 20));
		this.setBackground(new Color(0, 0, 0));

		PreviousButton = new JButton("Previous");
		PreviousButton.setPreferredSize(new Dimension(200, 20));
		PreviousButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				MainPanel.page--;
				MainFrame.refreshContent();
				checkButtons();
			}
		});
		this.add(PreviousButton);

		
		
		pageTextField = new JTextField();
		pageTextField.setText(MainPanel.page + "");
		pageTextField.addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				try
				{
					MainPanel.page = Integer.parseInt(pageTextField.getText());
					MainFrame.refreshContent();
					checkButtons();
				}
				catch(Exception exception)
				{
					System.err.println("No valid int: " + pageTextField.getText());
					checkButtons();
				}
			}
			
			@Override
			public void focusGained(FocusEvent e)
			{
				
			}
		});
		pageTextField.addKeyListener(new KeyListener()
		{
			
			@Override
			public void keyTyped(KeyEvent e)
			{
				
			}
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				
			}
			
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					try
					{
						MainPanel.page = Integer.parseInt(pageTextField.getText());
						MainFrame.refreshContent();
						checkButtons();
					}
					catch(Exception exception)
					{
						System.err.println("No valid int: " + pageTextField.getText());
						checkButtons();
					}
				}
			}
		});
		pageTextField.setColumns(10);
		pageTextField.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(pageTextField);
		
		
		
		
		NextButton = new JButton("Next");
		NextButton.setPreferredSize(new Dimension(200, 20));
		NextButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				MainPanel.page++;
				MainFrame.refreshContent();
				checkButtons();
			}
		});
		this.add(NextButton);
		
		
		checkButtons();
	}
	
	public static void refreshPage()
	{
		pageTextField.setText(MainPanel.page + "");
	}
	
	private void checkButtons()
	{
		PreviousButton.setEnabled(true);
		NextButton.setEnabled(true);
		
		if (MainPanel.page == 1)
		{
			PreviousButton.setEnabled(false);
		}
		if (MainPanel.page == MainPanel.max_page)
		{
			NextButton.setEnabled(false);
		}
		
		pageTextField.setText(MainPanel.page + "");
	}

}
