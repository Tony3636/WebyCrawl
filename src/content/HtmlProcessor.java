package content;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

import gui.MainFrame;
import model.HTML_Tag;
import model.WebVideo;
import model.Website;

public class HtmlProcessor
{
	public HtmlProcessor()
	{
	}

	public LinkedList<WebVideo> getHtmlVideoContent(Website website, String search, int page)
	{
		LinkedList<WebVideo> contentList = new LinkedList<WebVideo>();

		URL url;
		String inputLine = "";

		try
		{
			//Generate URL
			if (search.equals(""))
			{
				String urlString = website.getTitle() + website.getUrlString1() + page + website.getUrlString2();
				url = new URL(urlString);
			}
			else
			{
				String urlString = website.getTitle() + website.getSearchString1() + search + website.getSearchString2() + page + website.getSearchString3();
				urlString = urlString.replaceAll("\\s+", website.getSearchSplitter());
				url = new URL(urlString);
			}
			System.out.println("URL: " + url.toString());
			
			//Get html text for url
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			TagProcessor tp = new TagProcessor();
			
			int currentLine = 1;
			while ((inputLine = br.readLine()) != null && currentLine <= website.getEndLine())
			{
				if (currentLine < website.getStartLine()) 
				{
					currentLine++;
					continue;
				}
				if (MainFrame.debug) System.out.println(currentLine +  ": " + inputLine);
				tp.putString(inputLine, currentLine);	
				
				currentLine++;
			}
			if (MainFrame.debug) System.err.println("---------------------------------------------------------------------------------");
			br.close();
			
			//Get tag list
			LinkedList<HTML_Tag> tagList = tp.resultTagList;
			//Get video list
			TagMatcher tm = new TagMatcher(website, tagList);
			LinkedList<WebVideo> videoList = tm.getVideoContent();
			
			
			
			
			
			
			
			
			
			
			
			/*
			for (HTML_Tag ht : tagList)
			{
				System.out.println(ht.toString());
			}
			 */
			
			
			
			/*
			if (!video.equals("") && !picture.equals("") && !description.equals("") && !time.equals(""))
			{
				WebVideo webVideo = new WebVideo(website.getTitle() + video, picture, description, time, false);
				contentList.add(webVideo);
				
				video = ""; 
				picture = ""; 
				description = "";
				time = "";
			}
			*/
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return contentList;
	}

	public void getHtmlContent(String urlString)
	{
		URL url;
		String inputLine = "";

		int line = 0;
		
		try
		{
			url = new URL(urlString);
			URLConnection conn = url.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			while ((inputLine = br.readLine()) != null)
			{
				line++;
				System.out.println(line + ": " + inputLine);
			}
			br.close();
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
