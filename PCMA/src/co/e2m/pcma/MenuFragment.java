package co.e2m.pcma;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MenuFragment extends ListFragment
{
	private static final String STATE_ACTIVATED_POSITION = "activated_position";
	private Callbacks callbacks = emptyCallback;
	private int activatedPosition = ListView.INVALID_POSITION;

	public interface Callbacks
	{
		public void onItemSelected(ItemID id);
	}

	private static Callbacks emptyCallback = new Callbacks()
	{
		@Override
		public void onItemSelected(ItemID id)
		{
		}
	};

	public MenuFragment()
	{
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<MenuItem>(getActivity(), android.R.layout.simple_list_item_activated_1, android.R.id.text1, MenuItem.getMenuItems()));
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		if (savedInstanceState != null && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION))
		{
			setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
		}
	}

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);

		if (!(activity instanceof Callbacks))
		{
			throw new IllegalStateException("Activity must implement fragment's callbacks.");
		}
		callbacks = (Callbacks)activity;
	}

	@Override
	public void onDetach()
	{
		super.onDetach();

		callbacks = emptyCallback;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position, long id)
	{
		super.onListItemClick(listView, view, position, id);

		callbacks.onItemSelected(MenuItem.getMenuItems().get(position).getID());
	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		if (activatedPosition != ListView.INVALID_POSITION)
		{
			outState.putInt(STATE_ACTIVATED_POSITION, activatedPosition);
		}
	}

	public void setActivateOnItemClick(boolean activateOnItemClick)
	{
		getListView().setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
	}

	private void setActivatedPosition(int position)
	{
		if (position == ListView.INVALID_POSITION)
		{
			getListView().setItemChecked(activatedPosition, false);
		}
		else
		{
			getListView().setItemChecked(position, true);
		}
		
		activatedPosition = position;
	}
}
