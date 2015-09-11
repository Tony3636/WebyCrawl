package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 2292455670620751734L;
	private static MainPanel mainPanel;
	public static boolean debug = false;
	//private JPanel contentPane;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(100, 100, 450, 300);
		this.setSize(new Dimension(1280, 1000));
		this.setResizable(false);
		
		mainPanel = new MainPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(mainPanel);
		
		//this.pack();
	}
	
	public static void refreshContent()
	{
		mainPanel.refreshGUI();
	}

}
