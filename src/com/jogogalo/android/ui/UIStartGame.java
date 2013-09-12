package com.jogogalo.android.ui;

import com.android.jogogalo.R;
import com.jogogalo.android.ui.dialogs.DialogName;
import com.jogogalo.android.ui.dialogs.EditNameDialog;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UIStartGame extends FragmentActivity implements EditNameDialog {

	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrada);

		intent = new Intent(this, UIGame.class);

		Button player = (Button) findViewById(R.id.button1v1);
		Button computer = (Button) findViewById(R.id.button1vc);

		OnClickListener playerListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				intent.putExtra("mode", "player");
			}
		};

		OnClickListener computerListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogName fragment_dialog = DialogName.getInstance();
				fragment_dialog.show(getSupportFragmentManager(),
						"fragment_dialog_name");
				intent.putExtra("mode", "computer");
			}
		};

		player.setOnClickListener(playerListener);

		computer.setOnClickListener(computerListener);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.entrada, menu);
		return true;
	}

	public void startActivityUsingTime() {
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(getApplicationContext(),
						UIGame.class);
				startActivity(intent);
			}
		}, 2000);
	}

	/**
	 * Help -
	 * http://www.yousaytoo.com/dialogfragment-with-interface-to-pass-data
	 * -back-to-activity/3059669
	 */
	@Override
	public void onFinishDialog(String name) {
		intent.putExtra("name_player", name);
		startActivity(intent);
	}

}
