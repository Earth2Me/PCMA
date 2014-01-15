package co.e2m.pcma.menu;



public enum ItemID
{
	HOME,
	CHAT,
	;
	
	public Integer getPosition()
	{
		return MenuItem.getPosition(this);
	}
	
	public MenuItem getMenuItem()
	{
		return MenuItem.getByID(this);
	}
}
