package co.e2m.pcma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeContentFragment extends ContentFragment
{
	@Override
	public ItemID getItemID()
	{
		return ItemID.HOME_CONTENT;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_home_content, container, false);
	}
}
