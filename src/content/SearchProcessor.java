package content;

import java.util.LinkedList;

import model.WebVideo;
import model.Website;

public class SearchProcessor
{
	private HtmlProcessor hp = new HtmlProcessor();
	private LinkedList<Website> websiteList;
	private LinkedList<LinkedList<WebVideo>> contentList = new LinkedList<LinkedList<WebVideo>>();
	
	public SearchProcessor(LinkedList<Website> websiteList)
	{
		this.websiteList = websiteList;
	}
	
	public void createSearch(String searchText, int page)
	{
		LinkedList<WebVideo> tempList;
		for (Website w : this.websiteList)
		{
			//contentList.addAll(hp.getHtmlVideoContent(w, searchText, page));
			tempList = hp.getHtmlVideoContent(w, searchText, page);
			contentList.add(tempList);
		}
		
		
		
		
		
		
		
		
		
		//hp.getHtmlContent("http://youjizz.com/videos/delta-gets-caught-cheating-on-her-test-2192175.html");
		
	}
	
	public LinkedList<LinkedList<WebVideo>> getContentList()
	{
		return this.contentList;
	}
	
	public void lookUpHtml(String website)
	{
		hp.getHtmlContent(website);
	}
	
	/*
	public LinkedList<WebVideo> getContentList(int page, int maxElements)
	{
		int firstElement = (page - 1) * maxElements;
		int lastElement = firstElement + maxElements;
		LinkedList<WebVideo> returnList = new LinkedList<WebVideo>();
		int size = this.contentList.size();
		if (lastElement < size) size = lastElement;
		
		for (int i = firstElement; i < size; i++)
		{
			WebVideo wp = this.contentList.get(i);
			returnList.add(wp);
			
		}

		return returnList;
	}
	*/
}
