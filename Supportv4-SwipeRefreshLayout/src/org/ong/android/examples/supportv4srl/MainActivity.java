package org.ong.android.examples.supportv4srl;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;

/**
 * MainActivity
 * 
 * created 2014/05/23 17:20:28 GMT + 08:00
 */
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		
		setContentView( R.layout.activity_main );

		if ( null == savedInstanceState ) {
			getSupportFragmentManager()
					.beginTransaction()
					.add( R.id.container, new PlaceholderFragment() )
					.commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate( R.menu.main, menu );
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if ( id == R.id.action_settings ) {
			return true;
		}
		return super.onOptionsItemSelected( item );
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment 
			implements OnRefreshListener {
		
	    /**
	     * Our data.
	     */
	    public static final String[] DATA = 
	    {
	            "Henry IV (1)",   
	            "Henry V",
	            "Henry VIII",       
	            "Richard II",
	            "Richard III",
	            "Merchant of Venice",  
	            "Othello",
	            "King Lear"
	    };

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_main, container, false );
			
			return rootView;
		}

		@Override
		public void onViewCreated(View view, Bundle savedInstanceState) {
			super.onViewCreated( view, savedInstanceState );
		
			SwipeRefreshLayout swiper = (SwipeRefreshLayout) view.findViewById( 
					R.id.swipe_layout );
			ListView listView = (ListView) view.findViewById( 
					android.R.id.list );
			
			swiper.setColorScheme( 
					android.R.color.holo_orange_dark, 
					android.R.color.holo_green_light, 
					android.R.color.holo_blue_light, 
					android.R.color.holo_red_dark);
			
			swiper.setOnRefreshListener( this );
			
			listView.setAdapter( new ArrayAdapter<String>( 
					getActivity(), android.R.layout.simple_list_item_1, DATA ) );			
		}

		@Override
		public void onRefresh() {
		}		
	}
}