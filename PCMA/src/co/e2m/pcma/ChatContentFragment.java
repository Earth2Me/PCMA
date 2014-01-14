package co.e2m.pcma;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class ChatContentFragment extends Fragment implements ActionBar.TabListener
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getActivity().getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab;
		
		tab = actionBar.newTab().setText("All").setTabListener(this);
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
