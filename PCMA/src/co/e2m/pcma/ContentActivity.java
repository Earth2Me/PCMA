package co.e2m.pcma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;


/**
 * An activity representing a single Tool detail screen. This activity is only used on handset
 * devices. On tablet-size devices, item details are presented side-by-side with a list of items in
 * a {@link MenuActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than a
 * {@link ContentFragment}.
 */
public class ContentActivity extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);

		if (savedInstanceState == null)
		{
			Bundle arguments = new Bundle();
			ContentFragment fragment = new HomeContentFragment();
			arguments.putString(fragment.getItemID().name(), getIntent().getStringExtra(fragment.getItemID().name()));
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().add(R.id.tool_detail_container, fragment).commit();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpTo(this, new Intent(this, MenuActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
