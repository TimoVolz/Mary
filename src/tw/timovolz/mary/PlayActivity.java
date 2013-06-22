package tw.timovolz.mary;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends Activity {
	private MyCountDownTimer countDownTimer;
	private static long startTime = 2000 * 60;
	private static long interval = 100;
	private TextView tvTime;
	private TextView tvCalcQuestion;
	private TextView tvAnswer;
	private calcQuestion question;
	private String answer;
	private long score;
	private long errors;
	public final static String EXTRA_SCORE = "tw.timovolz.myfirstapp.SCORE";
	public final static String EXTRA_ERRORS = "tw.timovolz.myfirstapp.ERRORS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		// Show the Up button in the action bar.
		setupActionBar();
		tvTime = (TextView) findViewById(R.id.textView_time);
		tvCalcQuestion = (TextView) findViewById(R.id.textView_calcQuestion);
		question = new calcQuestion(0);
		tvCalcQuestion.setText(question.asText);
		tvAnswer = (TextView) findViewById(R.id.textView_answer);
		countDownTimer = new MyCountDownTimer(startTime, interval, this);
		countDownTimer.start();
		answer = "";
		score = 0;
		errors = 0;
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void button_numberClick(View view) {
		answer = answer + ((Button) view).getText();
		if (question.isCorrectAnswer(answer) == true) {
			question = new calcQuestion(0);
			tvCalcQuestion.setText(question.asText);
			answer = "";
			score = score + 1;
		} else {
			if (question.isCorrectStartOfAnswer(answer) == false) {
				answer = "";
				errors = errors + 1;
			}
		}
		tvAnswer.setText(answer);
	}

	public class MyCountDownTimer extends CountDownTimer {

		private Activity parentActivity;

		public MyCountDownTimer(long aStartTime, long aInterval,
				Activity aParent) {
			super(startTime, interval);
			parentActivity = aParent;
		}

		@Override
		public void onFinish() {
			Intent intent = new Intent(parentActivity, YourScore.class);
			intent.putExtra(EXTRA_SCORE, score);
			intent.putExtra(EXTRA_ERRORS, errors);
			startActivity(intent);
			finish();
		}

		@Override
		public void onTick(long millisUntilFinished) {
			tvTime.setText(tvUtils
					.milisecondsToMinuteString(millisUntilFinished));
		}
	}

}
