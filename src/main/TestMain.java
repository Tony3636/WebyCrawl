package main;

import java.util.LinkedList;
import java.util.List;

import content.SearchProcessor;
import model.HTML_Tag;
import model.WebVideo;
import model.Website;

public class TestMain
{

	public static void main(String[] args)
	{
		/*
		//DatabaseConnector.connect();
		String url1_web = "http://youjizz.com";
		String url1_search1 = "/search/views_";
		String url1_search2 = "-1.html";
		String searchText = "test";
		//int url1_page = 1;
		
		String searchUrl = url1_web + url1_search1 + searchText + url1_search2;
		
		
		Website website = new Website("Youjizz.com", url1_web, searchUrl, 361, 719, "a", "href", "", true, "img", "data-original", "", false, "span", "id", "title1", true);
		LinkedList<Website> websiteList = new LinkedList<Website>();
		websiteList.add(website);
		
		SearchProcessor sp = new SearchProcessor(websiteList);
		sp.createSearch("", 1);
		List<WebVideo> list = sp.getContentList(1, 8);
		
		int i = 0;
		i++;
		
		//SearchProcessor.createSearch("Test");
		 
		*/
		
		String s = "<time>11:00</time>";
		
		HTML_Tag tag = new HTML_Tag(s, -1);
		
		
		int i = 0;
		i++;
		if (i == 0) i++;
	}

}
