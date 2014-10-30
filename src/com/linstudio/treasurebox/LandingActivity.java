package com.linstudio.treasurebox;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class LandingActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_landing);
		
		/*
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment())
			.commit();
		}
		*/
		
		//Todo 1. Initialize control of TabHost. 
		TabHost host = (TabHost) findViewById(android.R.id.tabhost);
        host.setup();
        //Todo 2. Define each tab and associate it with tabId. 
        TabHost.TabSpec TabMeSpec = host.newTabSpec("tabtapme");
        //Todo 3. First parameter is to display as title.
        TabMeSpec.setIndicator(null, getResources().getDrawable(R.drawable.tapme));
        //Todo 4. Render layout for tab 1.
        TabMeSpec.setContent(R.id.tab1);
        //Todo 5. Add tab 1 to tabHost.
        host.addTab(TabMeSpec);
        
        TabHost.TabSpec TapInsomnia = host.newTabSpec("tapinsomnia");
        TapInsomnia.setIndicator(null, getResources().getDrawable(R.drawable.insomnia));
        TapInsomnia.setContent(R.id.tab2);
        host.addTab(TapInsomnia);
        
        TabHost.TabSpec TapAbout = host.newTabSpec("tapabout");
        TapAbout.setIndicator(null, getResources().getDrawable(R.drawable.pop));
        TapAbout.setContent(R.id.tab3);
        host.addTab(TapAbout);
        
        //Todo 6. Register clicking event to tab.
        host.setOnTabChangedListener(new OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {        	
            	//Todo 7. Prompt diff msg based on the clicking event of tab.
            	
            	
            	
            	
                //Toast toast = Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT);
                //toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 50);
                //toast.show();             
                //TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
                //tabHost.getCurrentTabView().setVisibility(View.GONE);
                //Button playButton = (Button) findViewById(R.id.calculatebutton); 
                //playButton.setVisibility(View.INVISIBLE);
            }
        });
        
        //Todo 8. Default selection to the tab.
        host.setCurrentTab(0);
        
        Button playButton = (Button) this.findViewById(R.id.calculatebutton); 
        playButton.setVisibility(View.INVISIBLE);
        TextView txt222 =(TextView)findViewById(R.id.txt2222);
        txt222.clearAnimation();
        txt222.setVisibility(View.INVISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.landing, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_landing,
					container, false);
			return rootView;
		}
	}
}
