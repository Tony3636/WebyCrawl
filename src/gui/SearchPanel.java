package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPanel extends JPanel
{

	private static final long serialVersionUID = 8616419179529913184L;
	private JTextField textField;
	private JButton HomeButton;
	private JButton FavoritesButton;
	private JButton StarButton;
	private JButton SearchButton;

	public SearchPanel()
	{
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(1280, 20));
		this.setBackground(new Color(0, 0, 0));

		HomeButton = new JButton("Home");
		HomeButton.setPreferredSize(new Dimension(200, 20));
		HomeButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setSelected(1);
			}
		});
		this.add(HomeButton);
		
		StarButton = new JButton("Stars");
		StarButton.setPreferredSize(new Dimension(200, 20));
		StarButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setSelected(2);
			}
		});
		this.add(StarButton);
		
		FavoritesButton = new JButton("Favorites");
		FavoritesButton.setPreferredSize(new Dimension(200, 20));
		FavoritesButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setSelected(3);
			}
		});
		this.add(FavoritesButton);

		textField = new JTextField();
		textField.setColumns(10);
		textField.addKeyListener(new KeyListener()
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
					setSelected(4);
				}
			}
		});
		this.add(textField);

		SearchButton = new JButton("Search");
		SearchButton.setPreferredSize(new Dimension(100, 20));
		SearchButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setSelected(4);
			}
		});
		this.add(SearchButton);
		
		HomeButton.setEnabled(false);
	}
	
	public void setSelected(int i)
	{
		MainPanel.page = 1;
		ControlPanel.refreshPage();
		if (i == 1)
		{
			MainPanel.index = 1;
			MainPanel.searchText = "";
			textField.setText("");
			MainFrame.refreshContent();
			HomeButton.setEnabled(false);
			StarButton.setEnabled(true);
			FavoritesButton.setEnabled(true);
		}
		else if(i == 2)
		{
			MainPanel.index = 2;
			MainPanel.searchText = "";
			textField.setText("");
			MainFrame.refreshContent();
			HomeButton.setEnabled(true);
			StarButton.setEnabled(false);
			FavoritesButton.setEnabled(true);
		}
		else if(i == 3)
		{
			MainPanel.index = 3;
			MainPanel.searchText = "";
			textField.setText("");
			MainFrame.refreshContent();
			HomeButton.setEnabled(true);
			StarButton.setEnabled(true);
			FavoritesButton.setEnabled(false);
		}
		else
		{
			MainPanel.index = 4;
			MainPanel.searchText = textField.getText();
			MainFrame.refreshContent();
			HomeButton.setEnabled(true);
			StarButton.setEnabled(true);
			FavoritesButton.setEnabled(true);
		}
	}

}
