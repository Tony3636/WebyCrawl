package model;

import java.util.LinkedList;

public class Website
{
	private String title;
	private String urlString1; 
	private String urlString2; 
	private String searchString1; 
	private String searchString2; 
	private String searchString3; 
	private String searchSplitter;
	
	private int startLine;
	private int endLine;
	
	private String vidTag;
	private String vidId;
	private String vidIdContent; 
	private boolean vidTagHasEnding;
	
	private String picTag;
	private String picId;
	private String picIdContent; 
	private boolean picTagHasEnding;
	
	private String descrTag;
	private String descrId;
	private String descrIdContent; 
	private boolean descrTagHasEnding;
	
	private String timeTag;
	private String timeId;
	private String timeIdContent; 
	private boolean timeTagHasEnding;
	
	/**
	 * 
	 * @param title
	 * @param urlString1
	 * @param urlString2
	 * @param searchString1
	 * @param searchString2
	 * @param searchString3
	 * @param searchSplitter
	 * @param startLine
	 * @param endLine
	 * @param vidTag
	 * @param vidId
	 * @param vidIdContent
	 * @param vidTagHasEnding
	 * @param picTag
	 * @param picId
	 * @param picIdContent
	 * @param picTagHasEnding
	 * @param descrTag
	 * @param descrId
	 * @param descrIdContent
	 * @param descrTagHasEnding
	 * @param timeTag
	 * @param timeId
	 * @param timeIdContent
	 * @param timeTagHasEnding
	 */
	public Website(String title, String urlString1, String urlString2, String searchString1, String searchString2, String searchString3, String searchSplitter, int startLine, int endLine, String vidTag, String vidId, String vidIdContent, boolean vidTagHasEnding, String picTag, String picId, String picIdContent, boolean picTagHasEnding, String descrTag, String descrId, String descrIdContent, boolean descrTagHasEnding, String timeTag, String timeId, String timeIdContent, boolean timeTagHasEnding)
	{
		super();
		this.title = title;
		this.urlString1 = urlString1;
		this.urlString2 = urlString2;
		this.searchString1 = searchString1;
		this.searchString2 = searchString2;
		this.searchString3 = searchString3;
		this.searchSplitter = searchSplitter;
		this.startLine = startLine;
		this.endLine = endLine;
		this.vidTag = vidTag;
		this.vidId = vidId;
		this.vidIdContent = vidIdContent;
		this.vidTagHasEnding = vidTagHasEnding;
		this.picTag = picTag;
		this.picId = picId;
		this.picIdContent = picIdContent;
		this.picTagHasEnding = picTagHasEnding;
		this.descrTag = descrTag;
		this.descrId = descrId;
		this.descrIdContent = descrIdContent;
		this.descrTagHasEnding = descrTagHasEnding;
		this.timeTag = timeTag;
		this.timeId = timeId;
		this.timeIdContent = timeIdContent;
		this.timeTagHasEnding = timeTagHasEnding;
	}

	public String getTitle()
	{
		return title;
	}

	public String getUrlString1()
	{
		return urlString1;
	}
	
	public String getUrlString2()
	{
		return urlString2;
	}

	public String getSearchString1()
	{
		return searchString1;
	}
	
	public String getSearchString2()
	{
		return searchString2;
	}
	
	public String getSearchString3()
	{
		return searchString3;
	}
	
	public String getSearchSplitter()
	{
		return searchSplitter;
	}
	
	public int getStartLine()
	{
		return this.startLine;
	}
	
	public int getEndLine()
	{
		return this.endLine;
	}
	
	public LinkedList<HTML_MatchTag> getMatchTagList()
	{
		return null;
	}
	
	public Match video;
	public Match image;
	public Match time;
	public Match description;
	
	public Match getMatchFor(ContentType ct)
	{
		switch(ct)
		{
		case DESCRIPTION:
			return description;
		case IMAGEURL:
			return image;
		case TIME:
			return time;
		case VIDEOURL:
			return video;
		default:
			return Match.NONE;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public String getVidTag()
	{
		return vidTag;
	}

	public String getVidId()
	{
		return vidId;
	}

	public String getVidIdContent()
	{
		return vidIdContent;
	}

	public boolean getVidTagHasEnding()
	{
		return vidTagHasEnding;
	}

	public String getPicTag()
	{
		return picTag;
	}

	public String getPicId()
	{
		return picId;
	}

	public String getPicIdContent()
	{
		return picIdContent;
	}

	public boolean getPicTagHasEnding()
	{
		return picTagHasEnding;
	}

	public String getDescrTag()
	{
		return descrTag;
	}

	public String getDescrId()
	{
		return descrId;
	}

	public String getDescrIdContent()
	{
		return descrIdContent;
	}

	public boolean getDescrTagHasEnding()
	{
		return descrTagHasEnding;
	}

	public String getTimeTag()
	{
		return timeTag;
	}

	public String getTimeId()
	{
		return timeId;
	}

	public String getTimeIdContent()
	{
		return timeIdContent;
	}

	public boolean getTimeTagHasEnding()
	{
		return timeTagHasEnding;
	}
	
	
	
}
