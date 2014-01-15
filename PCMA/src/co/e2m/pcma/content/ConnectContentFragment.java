package co.e2m.pcma.content;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import co.e2m.pcma.R;
import co.e2m.pcma.menu.ItemID;

public class ConnectContentFragment extends ContentFragment implements ActionBar.TabListener
{
	@Override
	public ItemID getItemID()
	{
		return ItemID.CONNECT;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_connect_content, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		final ListView listView = (ListView)view.findViewById(R.id.connect_list);
		listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, new String[]
		{
			"Person Alpha",
			"Person Beta",
			"Person Gamma",
			"Person Delta",
			"Person Epsilon",
			"Person Zeta",
			"Person Eta",
			"Person Theta",
			"Person Iota",
			"Person Kappa",
			"Person Lambda",
			"Person Mu",
			"Person Nu",
			"Person Xi",
			"Person Omicron",
			"Person Pi",
			"Person Rho",
			"Person Sigma",
			"Person Tau",
			"Person Upsilon",
			"Person Phi",
			"Person Chi",
			"Person Psi",
			"Person Omega",
		}));
		
		super.onViewCreated(view, savedInstanceState);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		final ActionBar actionBar = getActivity().getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.addTab(actionBar.newTab().setText("Speakers").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Attendees").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Sponsors").setTabListener(this));
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
