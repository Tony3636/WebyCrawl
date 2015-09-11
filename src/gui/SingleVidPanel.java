package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import model.WebVideo;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class SingleVidPanel extends JPanel
{

	private static final long serialVersionUID = -2726461403489974561L;
	
	public SingleVidPanel(WebVideo webVideo)
	{
		this.setLayout(new BorderLayout());
		//this.setSize(new Dimension(400, 400));
		this.setPreferredSize(new Dimension(200, 300));
		this.setMinimumSize(new Dimension(200, 300));
		TitledBorder titled = new TitledBorder(webVideo.getDescription());
		this.setBorder(titled);
		//this.setBackground(new Color(50, 50, 50));
		
		JCheckBox favoritCheckbox = new JCheckBox("Favorit");
		favoritCheckbox.setHorizontalAlignment(SwingConstants.CENTER);
		favoritCheckbox.setSelected(webVideo.isFavorit());
		favoritCheckbox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == 1)
				{
					webVideo.setFavorit(true);
				}
				else
				{
					webVideo.setFavorit(false);
				}
			}
		});
		this.add(favoritCheckbox, BorderLayout.SOUTH);
		
		/*
		JLabel descriptionLabel = new JLabel(webVideo.getDescription());
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(descriptionLabel, BorderLayout.NORTH);
		*/
		
		this.manageURLs(webVideo);
	}
	
	private void manageURLs(WebVideo webVideo)
	{
		URL url;
		try
		{
			url = new URL(webVideo.getPic_url());
			// URLConnection connection = url.openConnection();
			// connection.setRequestProperty("User-Agent", "xxxxxx");

			BufferedImage image = ImageIO.read(url);
			ImageIcon icon = new ImageIcon(image);
			JLabel vidLabel = new JLabel(icon);
			vidLabel.addMouseListener(new MouseListener()
			{

				@Override
				public void mouseClicked(MouseEvent arg0)
				{
					try
					{
						Desktop.getDesktop().browse(new URL(webVideo.getVideo_url()).toURI());
					}
					catch (IOException | URISyntaxException e)
					{
						e.printStackTrace();
					}
				}

				@Override
				public void mouseEntered(MouseEvent arg0) 
				{
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent arg0) 
				{
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent arg0) {}

				@Override
				public void mouseReleased(MouseEvent arg0) {}

			});

			
			this.add(vidLabel, BorderLayout.CENTER);
			
			JLabel timelabel = new JLabel(webVideo.getTime());
			timelabel.setHorizontalAlignment(SwingConstants.CENTER);
			this.add(timelabel, BorderLayout.NORTH);

		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
