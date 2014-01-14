package co.e2m.pcma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MenuItem
{
	private static final List<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	private final ItemID id;
	private final String text;
	
	static
	{
		menuItems.add(new MenuItem(ItemID.HOME_MENU, "Home"));
		menuItems.add(new MenuItem(ItemID.PROFILE_MENU, "Profile"));
		menuItems.add(new MenuItem(ItemID.SPONSORS_MENU, "Sponsors"));
		menuItems.add(new MenuItem(ItemID.SPEAKERS_MENU, "Speakers"));
		menuItems.add(new MenuItem(ItemID.ATTENDEES_MENU, "Attendees"));
		menuItems.add(new MenuItem(ItemID.PLANNERS_MENU, "Planners"));
		menuItems.add(new MenuItem(ItemID.SURVEY_MENU, "Survey"));
		menuItems.add(new MenuItem(ItemID.FEEDBACK_MENU, "Feedback"));
	}
	
	public MenuItem(ItemID id, String text)
	{
		this.id = id;
		this.text = text;
	}
	
	public static List<MenuItem> getMenuItems()
	{
		return Collections.unmodifiableList(menuItems);
	}
	
	public ItemID getID()
	{
		return id;
	}
	
	public String getText()
	{
		return text;
	}
	
	@Override
	public String toString()
	{
		return text; 
	}
}
