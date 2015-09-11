package gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainPanel extends JPanel
{

	private static final long serialVersionUID = -8438576029794021570L;

	//private BufferedImage image;
	
	public static int index = 1;
	public static int max_page = 50;
	public static int page = 1;
	public static String searchText = "";
	
	private static SearchPanel sp = new SearchPanel();
	private static VidPanel vp;
	private static ControlPanel cp = new ControlPanel();

	public MainPanel()
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.createGUI();
	}
	
	private void createGUI()
	{
		if (index == 1)
		{
			vp = new VidPanel("", page);
		}
		else if (index == 2)
		{
			vp = new VidPanel("", page);
		}
		else if (index == 3)
		{
			vp = new VidPanel("", page);
		}
		else if (index == 4)
		{
			vp = new VidPanel(searchText, page);
		}
		else
		{
			vp = new VidPanel("", page);
		}
		JScrollPane VidScrollPane = new JScrollPane(vp);
		
		this.add(sp);
		this.add(VidScrollPane);
		this.add(cp);
	}
	
	public void refreshGUI()
	{
		this.removeAll();
		this.repaint();
		this.updateUI();
		
		this.createGUI();
		this.repaint();
		
	}

}
