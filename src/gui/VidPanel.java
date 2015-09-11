package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.JPanel;

import content.SearchProcessor;
import model.WebVideo;
import model.Website;

public class VidPanel extends JPanel
{

	private static final long serialVersionUID = -9192641995286733927L;

	private SearchProcessor sp;
	private LinkedList<LinkedList<WebVideo>> vidList = new LinkedList<LinkedList<WebVideo>>();
	
	/*
	private int elements_count_width = 3;
	private int elements_count_height = 8;
	private int elements_count_max = elements_count_width * elements_count_height;
	*/
	
	public VidPanel(String search, int page)
	{
		this.setLayout(new GridLayout(0, 3, 5, 5));
		this.setSize(new Dimension(1280, 20));
		
		LinkedList<Website> websiteList = new LinkedList<Website>();
		
		//DatabaseConnector.connect();
		String url1_title = "http://www.youjizz.com";
		String url1_web1 = "/most-popular/";
		String url1_web2 = ".html";
		String url1_search1 = "/search/views_";
		String url1_search2 = "-";
		String url1_search3 = ".html";
		String url1_searchSplitter = "-";
		
		Website website1 = new Website(url1_title, url1_web1, url1_web2, url1_search1, url1_search2, url1_search3, url1_searchSplitter, 200, 1100, "a", "href", "", true, "img", "data-original", "", false, "span", "id", "title1", true, "span", "class", "thumbtime", true);
		//websiteList.add(website1);
		
		
		String url2_title = "http://www.pornhd.com";
		String url2_web1 = "/videos/mostpopular?page=";
		String url2_web2 = "";
		String url2_search1 = "/search?search=";
		String url2_search2 = "&page=";
		String url2_search3 = "";
		String url2_searchSplitter = "+";
		
		Website website2 = new Website(url2_title, url2_web1, url2_web2, url2_search1, url2_search2, url2_search3, url2_searchSplitter, 207, 1400, "a", "href", "", false, "img", "data-original", "", false, "a", "class", "title", true, "time", "", "", true);
		websiteList.add(website2);
		
		//sp.lookUpHtml("http://www.pornhd.com/");;
		
		
		
		
		
		
		
		sp = new SearchProcessor(websiteList);
		
		sp.createSearch(search, page);
		vidList = sp.getContentList();
		
		for (int i1 = 0; i1 < this.vidList.size(); i1++)
		{
			for (int i2 = 0; i2 < this.vidList.get(i1).size(); i2++)
			{
				this.add(new SingleVidPanel(vidList.get(i1).get(i2)));
			}
		}

	}
	
	public void removeAll_Videos()
	{
		vidList.clear();
	}
	
	public void add_video()
	{
		
	}
	
	

}
