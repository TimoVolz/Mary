package tw.timovolz.mary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MaryMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mary_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mary_main, menu);
		return true;
	}
	
    /** Called when the user clicks the Play button */
    public void button_playClick(View view) {
    	Intent intent = new Intent(this, PlayActivity.class);
    	startActivity(intent);
    }

}
