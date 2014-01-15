package co.e2m.pcma.content;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.e2m.pcma.R;
import co.e2m.pcma.menu.ItemID;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class HomeContentFragment extends ContentFragment
{
	private MapFragment map;
	
	@Override
	public ItemID getItemID()
	{
		return ItemID.HOME;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		final View root = inflater.inflate(R.layout.fragment_home_content, container, false);
		
		try
		{
			MapsInitializer.initialize(getActivity());
			
			map = MapFragment.newInstance(new GoogleMapOptions()
				.camera(CameraPosition.fromLatLngZoom(new LatLng(42.34807, -71.08362), 17f))
				.compassEnabled(false)
				.rotateGesturesEnabled(false)
				.scrollGesturesEnabled(false)
				.tiltGesturesEnabled(false)
				.zoomControlsEnabled(false)
				.zoomGesturesEnabled(false)
				.mapType(GoogleMap.MAP_TYPE_NORMAL));
		}
		catch (GooglePlayServicesNotAvailableException exception)
		{
			map = null;
			Log.d("PCMA", "Google Play service is unavailable; maps will not work.");
		}
		
		return root;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		if (map != null)
		{
			getFragmentManager().beginTransaction().replace(R.id.map_placeholder, map).commit();
		}
		
		super.onViewCreated(view, savedInstanceState);
	}
}
