package com.android.ui;

import com.android.jogogalo.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class JogoGalo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogo_galo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jogo_galo, menu);
		return true;
	}

}