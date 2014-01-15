package co.e2m.pcma;

import co.e2m.pcma.content.ChatContentFragment;
import co.e2m.pcma.content.ConnectContentFragment;
import co.e2m.pcma.content.EventsContentFragment;
import co.e2m.pcma.content.HomeContentFragment;
import co.e2m.pcma.content.ProfileContentFragment;
import co.e2m.pcma.menu.ItemID;
import co.e2m.pcma.menu.MenuItem;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrawerActivity extends FragmentActivity implements AdapterView.OnItemClickListener
{
	private ArrayAdapter<MenuItem> adapter;
	private ItemID screen;
	private ListView drawerList;
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle drawerToggle;
	
	public void setScreen(ItemID screen)
	{
		if (screen == this.screen)
		{
			return;
		}
		
		final Fragment fragment;
		
		switch (screen)
		{
		case CONNECT:
			fragment = new ConnectContentFragment();
			break;
			
		case PROFILE:
			fragment = new ProfileContentFragment();
			break;
			
		case CHAT:
			fragment = new ChatContentFragment();
			break;
			
		case EVENTS:
			fragment = new EventsContentFragment();
			break;
			
		case HOME:
		default:
			fragment = new HomeContentFragment();
			break;
		}
		
		getFragmentManager().beginTransaction().replace(R.id.content_placeholder, fragment).commit();
		getActionBar().setTitle(screen.getMenuItem().getText());
		
		if (this.screen != null && this.screen != screen)
		{
			drawerList.setItemChecked(this.screen.getPosition(), false);
		}
		drawerList.setItemChecked(screen.getPosition(), true);
		
		this.screen = screen;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer);
		
		drawerList = (ListView)findViewById(R.id.drawer_list);
		drawerList.setAdapter(adapter = new ArrayAdapter<MenuItem>(this, android.R.layout.simple_list_item_activated_1, android.R.id.text1, MenuItem.getMenuItems()));
		drawerList.setOnItemClickListener(this);
		
		drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		drawerLayout.setDrawerListener(drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close)
		{
			@Override
			public void onDrawerOpened(View drawerView)
			{
				getActionBar().setTitle(R.string.drawer_title);
				invalidateOptionsMenu();
				super.onDrawerOpened(drawerView);
			}
			
			@Override
			public void onDrawerClosed(View drawerView)
			{
				getActionBar().setTitle(getScreen().getMenuItem().getTitle());
				invalidateOptionsMenu();
				super.onDrawerClosed(drawerView);
			}
		});
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		setScreen(ItemID.HOME);
		drawerLayout.openDrawer(drawerList);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onOptionsItemSelected(android.view.MenuItem item)
	{
		return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		// If we had actionbar buttons:
		/*
		boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
		menu.findItem(R.id._____).setVisible(!drawerOpen);
		*/
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		if (adapter != parent.getAdapter())
		{
			return;
		}

		setScreen(adapter.getItem(position).getID());
		drawerLayout.closeDrawer(drawerList);
	}
	
	public ItemID getScreen()
	{
		return screen;
	}
}
