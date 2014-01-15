package co.e2m.pcma.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MenuItem
{
	private static final List<MenuItem> menuItems = new ArrayList<MenuItem>();
	private static final Map<ItemID, Integer> positions = new HashMap<ItemID, Integer>();
	private static final Map<ItemID, MenuItem> byID = new HashMap<ItemID, MenuItem>();
	
	private final ItemID id;
	private final String text;
	
	static
	{
		addItem(ItemID.HOME, "Home");
		addItem(ItemID.PROFILE, "Profile");
		addItem(ItemID.CONNECT, "Connect");
		addItem(ItemID.CHAT, "Chat");
		addItem(ItemID.EVENTS, "Events");
	}
	
	public MenuItem(ItemID id, String text)
	{
		this.id = id;
		this.text = text;
	}
	
	private static void addItem(ItemID id, String text)
	{
		positions.put(id, menuItems.size());
		
		final MenuItem item = new MenuItem(id, text);
		menuItems.add(item);
		byID.put(id, item);
	}
	
	public static List<MenuItem> getMenuItems()
	{
		return Collections.unmodifiableList(menuItems);
	}
	
	public static Integer getPosition(ItemID id)
	{
		return positions.get(id);
	}
	
	public static MenuItem getByID(ItemID id)
	{
		return byID.get(id);
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
	
	public String getTitle()
	{
		return text;
	}
}
