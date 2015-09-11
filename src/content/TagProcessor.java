package content;

import java.util.LinkedList;
import java.util.Stack;
import model.HTML_Tag;

public class TagProcessor
{
	public LinkedList<HTML_Tag> resultTagList;
	private Stack<String> tagStack;
	private Stack<String> tagLineStack;
	
	private String previousTag = "";
	private String previousLine = "";
	private String startTag = "";
	private String endTag = "";
	
	private String htmlLine = "";
	
	private boolean startTag_started = false;
	private boolean endTag_started = false;
	private boolean idValue_started = false;
	private boolean content_started = false;
	
	private int lineNumber = -1;
	
	public TagProcessor()
	{
		resultTagList = new LinkedList<HTML_Tag>();
		tagStack = new Stack<String>();
		tagLineStack = new Stack<String>();
	}
	
	public void putString(String line, int lineNumber)
	{
		
		this.lineNumber = lineNumber;
		if (lineNumber == 249)
		{
			System.out.println("DEBUG");
		}
		
		line = line.replace("\t", "");
		line = line.replace(" ", "___");
		
		if (!tagStack.isEmpty()) previousTag = tagStack.get(tagStack.size() - 1);
		if (!tagLineStack.isEmpty()) previousLine = tagLineStack.get(tagLineStack.size() - 1);
		
		for (int i = 0; i < line.length(); i++)
		{
			char c = line.charAt(i);
			htmlLine += c;
			
			if (startTag_started)
			{
				if (this.isSpace(c))
				{
					startTag_started = false;
					idValue_started = true;
				}
				else if (c == '/')
				{
					System.out.println("EndTag found");
					if (line.length() > (i + 1))
					{
						if (line.charAt(i + 1) == '>')
						{
							this.createHTML_Tag(htmlLine);
							startTag_started = false;
						}
						else
						{
							startTag_started = false;
							endTag_started = true;
						}
					}
					else
					{
						startTag_started = false;
						endTag_started = true;
					}	
				}
				else if (c == '>')
				{
					startTag_started = false;
					content_started = true;
				}
				else
				{
					startTag  += c;
				}
			}
			else if (endTag_started)
			{
				if (c == '>')
				{
					if (endTag.equals(startTag))
					{
						this.createHTML_Tag(htmlLine);
					}
					else
					{	
						Stack<String> tempTagStorage = new Stack<String>();
						Stack<String> tempTagLineStorage = new Stack<String>();
						String potentialContent = "";
						
						boolean found = true;
						if (!endTag.equals(previousTag)) found = false;
						
						while (!endTag.equals(previousTag))
						{
							if (!tagStack.isEmpty())
							{
								tempTagStorage.push(previousTag);
								tempTagLineStorage.push(previousLine);
								previousTag = tagStack.pop();
								previousLine = tagLineStack.pop();
								
								potentialContent += this.getContentFromTag(previousLine);
								
								found = true;
							}
							else
							{
								while (!tempTagStorage.isEmpty())
								{
									tagStack.push(tempTagStorage.pop());
									tagLineStack.push(tempTagLineStorage.pop());
								}
								break;
							}
						}
						if (found)
						{
							if (!tagStack.isEmpty())
							{
								endTag = "";
								tagStack.pop();
								tagLineStack.pop();
								this.createHTML_Tag(previousLine + potentialContent + htmlLine);
							}
							else
							{
								endTag = "";
								previousTag = "";
								previousLine = "";
								this.createHTML_Tag(previousLine + potentialContent + htmlLine);
							}
							
						}
						else
						{
							htmlLine = "";
							endTag = "";
						}
					}
					endTag_started = false;
				}
				else
				{
					endTag += c;
				}
			}
			else if (idValue_started)
			{
				if (c == '>')
				{
					if (i != 0)
					{
						if (line.charAt(i - 1) == '/')
						{
							System.out.println("EndTag found");
							this.createHTML_Tag(htmlLine);
							idValue_started = false;
							startTag = "";
						}
						else
						{
							idValue_started = false;
							content_started = true;
						}
					}
					else
					{
						if (!htmlLine.isEmpty())
						{
							if (htmlLine.endsWith(" >"))
							{
								htmlLine = htmlLine.substring(0, htmlLine.length() - 2);
								htmlLine += '>';
							}
						}
						idValue_started = false;
						content_started = true;
					}
				}
				else if (c == '/')
				{
					continue;
				}
				else
				{
					continue;
				}
			}
			else if (content_started)
			{
				if (c == '<')
				{
					i -= 1;
					htmlLine = htmlLine.substring(0, htmlLine.length() - 1);
					htmlLine = htmlLine.replace("___", " ");
					
					this.tagStack.push(startTag);
					this.tagLineStack.push(htmlLine);
					previousTag = startTag;
					previousLine = htmlLine;
					
					startTag = "";
					htmlLine = "";
					content_started = false;
					continue;
				}
			}
			else
			{
				if (c == '<')
				{
					startTag_started = true;
				}
				else
				{
					content_started = true;
				}
			}
		}
		
		
		if (!htmlLine.equals("")) 
		{
			if (startTag_started && htmlLine.charAt(htmlLine.length() - 1) != '>')
			{
				htmlLine = htmlLine.replace("___", " ") + " ";
				
				//tagStack.push(startTag);
				startTag_started = false;
				idValue_started = true;
				//startTag = "";
			}
			else if (startTag_started)
			{
				startTag_started = false;
				content_started = true;
			}
			else if (idValue_started)
			{
				htmlLine = htmlLine.replace("___", " ") + " ";
			}
		}
	}
	
	private void createHTML_Tag(String lineString)
	{
		HTML_Tag ht = new HTML_Tag(lineString, lineNumber);
		
		System.err.println("TAG FINISHED: " + ht.toString());
		
		resultTagList.add(ht);
		htmlLine = "";
	}
	
	private String getContentFromTag(String tag)
	{
		String content = "";
		boolean start = false;
		
		for (int i = 0; i < tag.length(); i++)
		{
			char c = tag.charAt(i);
			if (c == '>')
			{
				start = true;
			}
			else
			{
				if (start) content += c;
			}
		}
			
		return content;
	}
	
	/*
	private boolean isSymbol(char c)
	{
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(c + "");
		return m.find();
	}
	*/
	
	private boolean isSpace(char c)
	{
		String s = c + "";
		if (s.equals("\\s+") || s.equals("_")) return true;
		else return false;
	}
}
