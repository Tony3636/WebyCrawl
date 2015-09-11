package content;

import java.util.LinkedList;

import model.ContentType;
import model.HTML_MatchTag;
import model.HTML_Tag;
import model.Match;
import model.WebVideo;
import model.Website;

public class TagMatcher
{
	private Website website;
	private LinkedList<HTML_Tag> tagList;
	
	public TagMatcher(Website website, LinkedList<HTML_Tag> tagList)
	{
		this.website = website;
		this.tagList = tagList;
	}
	
	public LinkedList<WebVideo> getVideoContent()
	{
		
		LinkedList<HTML_MatchTag> matchTagList = website.getMatchTagList();
		
		String videoURL = "";
		String imgURL = "";
		String description = "";
		String time = "";
		
		for (int tagIndex = 0; tagIndex < tagList.size(); tagIndex++)
		{
			for (int matchIndex = 0; matchIndex < matchTagList.size(); matchIndex++)
			{
				HTML_Tag ht = tagList.get(tagIndex);
				HTML_MatchTag hmt = matchTagList.get(matchIndex);
				
				ContentType ct;
				if ((ct = hmt.matches(ht, matchIndex)) != ContentType.NONE)
				{
					Match m = website.getMatchFor(ct);
					switch(m)
					{
					case CONTENT:
						break;
					case ID:
						break;
					case NONE:
						break;
					default:
						break;
					}
				}
				else
				{
					videoURL = "";
					imgURL = "";
					description = "";
					time = "";
					
					break;
				}
			}
		}
		
		
		
		
		
		return null;
	}
}
