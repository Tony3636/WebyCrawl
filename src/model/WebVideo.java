package model;

public class WebVideo
{
	
	private String video_url;
	private String pic_url;
	private String description;
	private String time;
	private boolean favorit;
	
	/**
	 * 
	 * @param video_url
	 * @param pic_url
	 * @param description
	 * @param time
	 * @param favorit
	 * 
	 */
	public WebVideo(String video_url, String pic_url, String description, String time, boolean favorit)
	{
		super();
		this.video_url = video_url;
		this.pic_url = pic_url;
		this.description = description;
		this.time = time;
		this.favorit = favorit;
	}
	
	public String getVideo_url()
	{
		return video_url;
	}

	public String getPic_url()
	{
		return pic_url;
	}

	public String getDescription()
	{
		return description;
	}
	
	public String getTime()
	{
		return time;
	}

	public boolean isFavorit()
	{
		return favorit;
	}

	public void setFavorit(boolean favorit)
	{
		this.favorit = favorit;
	}
	
	@Override
	public String toString()
	{
		return "WebVideo [" + description + "]";
	}
	
}
