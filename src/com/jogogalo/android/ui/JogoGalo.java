package com.jogogalo.android.ui;

import com.android.jogogalo.R;
import com.jogogalo.model.Game;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class JogoGalo extends Activity {

	private Button table[];
	private SharedPreferences preferences;
	private final String prefName = "galoPref";
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogo_galo);

		createTable();

		intent = getIntent();

		if (intent.getStringExtra("mode").equalsIgnoreCase("player")) {
			savePreferences(intent.getStringExtra("name_player"));
		} else {
			// TODO create code if mode = player
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jogo_galo, menu);
		return true;
	}

	public void loadPreferences() {
		preferences = getSharedPreferences(prefName, MODE_PRIVATE);

	}

	public void savePreferences(String name) {
		preferences = getSharedPreferences(prefName, MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();

		editor.putString("name_player", name);
		editor.commit();
	}

	public void createTable() {

		table = new Button[Game.SIZE_TABLE];

		for (int i = 0; i < Game.SIZE_TABLE; i++) {

			String button_id = "button" + i;
			// Get valor into class R
			int id_res = getResources().getIdentifier(button_id, "id",
					getPackageName());
			table[i] = (Button) findViewById(id_res);

			table[i].setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(v.getContext(), String.valueOf("test"),
							Toast.LENGTH_SHORT).show();
				}
			});

		}
	}

}
