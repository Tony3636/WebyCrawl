package model;

import java.util.LinkedList;
import java.util.Map;

public class HTML_MatchTag
{
	private String tag;
	private Map<String, String> idValue;
	private String content;
	private LinkedList<ContentType> typeList;

	public HTML_MatchTag(String tag, Map<String, String> idValue, String content, LinkedList<ContentType> typeList)
	{
		super();
		this.tag = tag;
		this.idValue = idValue;
		this.content = content;
		this.typeList = typeList;
	}

	public ContentType matches(HTML_Tag ht, int index)
	{
		if (!this.tag.equals(ht.getTag()))
		{
			return ContentType.NONE;
		}
		if (!this.content.equals(""))
		{
			if (!this.content.equals(ht.getContent()))
			{
				return ContentType.NONE;
			}
		}
		for (String key : this.idValue.keySet())
		{
			String value = this.idValue.get(key);
			if (value.equals(""))
			{
				if (!ht.getIdMap().containsKey(key))
				{
					return ContentType.NONE;
				}
			}
			else
			{
				if (ht.getIdMap().containsKey(key))
				{
					if (!ht.getIdMap().get(key).equals(value))
					{
						return ContentType.NONE;
					}
				}
				else
				{
					return ContentType.NONE;
				}
			}
		}
		
		return typeList.get(index);
		
	}
}
