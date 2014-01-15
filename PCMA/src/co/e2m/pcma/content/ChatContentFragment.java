package co.e2m.pcma.content;

import co.e2m.pcma.R;
import co.e2m.pcma.menu.ItemID;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChatContentFragment extends ContentFragment implements ActionBar.TabListener
{
	@Override
	public ItemID getItemID()
	{
		return ItemID.CHAT;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_chat_content, container, false);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		final ActionBar actionBar = getActivity().getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.addTab(actionBar.newTab().setText("All").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Sponsors").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Me").setTabListener(this));
	}
	
	@Override
	public void onDestroy()
	{
		getActivity().getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		getActivity().getActionBar().removeAllTabs();
		
		super.onDestroy();
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft)
	{
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft)
	{
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft)
	{
	}
}
