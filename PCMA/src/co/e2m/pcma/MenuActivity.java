package co.e2m.pcma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class MenuActivity extends FragmentActivity implements MenuFragment.Callbacks
{
	private boolean twoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		if (findViewById(R.id.tool_detail_container) != null)
		{
			twoPane = true;
			((MenuFragment)getSupportFragmentManager().findFragmentById(R.id.tool_list)).setActivateOnItemClick(true);
		}
	}

	@Override
	public void onItemSelected(ItemID menuItemID)
	{
		final ContentFragment fragment;
		switch (menuItemID)
		{
		case HOME_MENU:
		case HOME_CONTENT:
			fragment = new HomeContentFragment();
			break;
		
		default:
			throw new RuntimeException("Invalid onItemSelected argument");
		}
		
		if (twoPane)
		{
			Bundle arguments = new Bundle();
			arguments.putString(fragment.getItemID().name(), menuItemID.name());
			fragment.setArguments(arguments);
			
			getSupportFragmentManager().beginTransaction().replace(R.id.tool_detail_container, fragment).commit();
		}
		else
		{
			Intent intent = new Intent(this, ContentActivity.class);
			intent.putExtra(fragment.getItemID().name(), menuItemID.name());
			startActivity(intent);
		}
	}
}
