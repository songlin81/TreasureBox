package com.linstudio.treasurebox;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent; 

public class SplashActivity extends Activity {

	//Todo 1. Simulate time-consuming check-up, delay for 3 secs.
	private final int SPLASH_DELAY = 3000;
	
	//Todo 2. Handler to open a new thread to close up current activity and redirect to landing page.
	private Handler handler = new Handler();  
    private Runnable runnable;  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
				
		super.onCreate(savedInstanceState);
		
		//Todo 3. FullScreen removal of title.
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(	WindowManager.LayoutParams.FLAG_FULLSCREEN, 
									WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//Todo 4. Ref to layout of Splash activity.
		setContentView(R.layout.activity_splash);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		//Todo 5. Attached event to render Splash window for 3 secs.
		handler.postDelayed(runnable = new Runnable(){			 
		         @Override
		         public void run() {
		        	 //Todo 6. Intent created to glue two activities.
		             Intent Splash2LandingIntent = new Intent(SplashActivity.this, LandingActivity.class);
		             //Todo 7. Initiate landing activity.
		             SplashActivity.this.startActivity(Splash2LandingIntent);
		             //Todo 8. Terminate execution of Splash activity.
		             SplashActivity.this.finish();
		         }
	        }, SPLASH_DELAY); 
	}

	//Todo 9. Detach event of rendering Splash window once touching the screen.
	@Override  
    public boolean onTouchEvent(MotionEvent event)  
    {  
        if(event.getAction()==MotionEvent.ACTION_UP)  
        {  
            Intent intent = new Intent(SplashActivity.this, LandingActivity.class);  
            startActivity(intent);  
            finish();  
            if (runnable != null)  
                handler.removeCallbacks(runnable);  
        }         
        return super.onTouchEvent(event);  
    }  
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_splash,
					container, false);
			return rootView;
		}
	}
}
