package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTML_Tag
{
	private String completeTag;

	private String tag = "";
	private Map<String, String> idMap = new HashMap<String, String>();
	private String content = "";
	private int line = -1;

	public HTML_Tag(String completeTag, int line)
	{
		this.completeTag = completeTag.replace(" ", "___");
		this.processTag();
		this.completeTag = completeTag.replace("___", " ");
		this.line = line;
	}

	private void processTag()
	{
		if (completeTag.charAt(0) != '<' || completeTag.charAt(completeTag.length() - 1) != '>')
		{
			throw new IllegalArgumentException("HTML Tag is not processable: " + completeTag);
		}
		
		String id = "";
		String value = "";
		boolean tag_started = true;
		boolean id_started = false;
		boolean value_started = false;
		boolean content_started = false;
		
		for (int i = 1; i < this.completeTag.length() - 1; i++)
		{
			char c = this.completeTag.charAt(i);
			
			
			if (tag_started)
			{
				if (this.isSpace(c))
				{
					tag_started = false;
				}
				else if (c == '>')
				{
					tag_started = false;
					content_started = true;
				}
				else
				{
					tag += c;
				}
			}
			else if (id_started)
			{
				if (c == '=')
				{
					id_started = false;
				}
				else
				{
					id += c;
				}
			}
			else if (value_started)
			{
				if (c == '\"' || c == '\'')
				{
					value = value.replace("___", " ");
					this.idMap.put(id, value);
					id = "";
					value = "";
					
					value_started = false;
				}
				else
				{
					value += c;
				}
			}
			else if (content_started)
			{
				if (c == '<')
				{
					content = content.replace("___", " ");
					
					content_started = false;
					
					break;
				}
				else
				{
					content += c;
				}
			}
			else
			{
				if (this.isSpace(c))
				{
					continue;
				}
				else if (c == '=')
				{
					System.out.println("HTML_Tag parsing may fail: Case not covered: " + c);
				}
				else if (c == '\"' || c == '\'')
				{
					value_started = true;
				}
				else if (c == '>')
				{
					content_started = true;
				}
				else if (c == '<')
				{
					break;
				}
				else if (c == '/')
				{
					break;
				}
				else if (!this.isSymbol(c))
				{
					if (id.equals(""))
					{
						id += c;
						id_started = true;
					}
					else if (value.equals(""))
					{
						System.out.println("HTML_Tag parsing may fail: Case not covered: value.equals(\"\") with " + c);
					}
				}
				else
				{
					System.out.println("HTML_Tag parsing may fail: Unsupported char: " + c);
				}
			}
		}
	}

	private boolean isSpace(char c)
	{
		String s = c + "";
		if (s.equals("\\s+") || s.equals("_")) return true;
		else return false;
	} 
	
	private boolean isSymbol(char c)
	{
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(c + "");
		return m.find();
	}

	public String getCompleteTag()
	{
		return completeTag;
	}

	public String getTag()
	{
		return tag;
	}

	public Map<String, String> getIdMap()
	{
		return idMap;
	}

	public String getContent()
	{
		return content;
	}

	public boolean matches(String tag, LinkedList<String> ids, String content)
	{
		return false;
	}
	
	@Override
	public String toString()
	{
		return "HTML_Tag [tag=" + tag + ", idMap=" + idMap + ", content=" + content + "]" + " --- " + "Line " + line + " : " + completeTag;
	}
}
