package co.e2m.pcma.content;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.e2m.pcma.R;
import co.e2m.pcma.menu.ItemID;

public class EventsContentFragment extends ContentFragment
{
	@Override
	public ItemID getItemID()
	{
		return ItemID.EVENTS;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_events_content, container, false);
	}
}
