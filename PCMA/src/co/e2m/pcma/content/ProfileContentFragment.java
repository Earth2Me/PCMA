package co.e2m.pcma.content;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.e2m.pcma.R;
import co.e2m.pcma.menu.ItemID;

public class ProfileContentFragment extends ContentFragment
{
	@Override
	public ItemID getItemID()
	{
		return ItemID.PROFILE;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_profile_content, container, false);
	}
}
