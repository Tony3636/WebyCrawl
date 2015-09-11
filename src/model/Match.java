package model;

public enum Match
{
	NONE(""), ID(""), CONTENT("");
	
	private String value = "";
	private Match(String value)
	{
		this.value = value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}
}
