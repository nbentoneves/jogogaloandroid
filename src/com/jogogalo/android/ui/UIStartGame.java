package com.jogogalo.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.android.jogogalo.R;
import com.jogogalo.android.ui.dialogs.DialogName;
import com.jogogalo.android.ui.dialogs.DialogSymbol;

public class UIStartGame extends Activity {

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
                DialogName dialog = new DialogName(UIStartGame.this);
                dialog.create().show();
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


    public void onFinishDialogName(String name) {
        DialogSymbol symbol = new DialogSymbol(UIStartGame.this);
        symbol.create().show();
        intent.putExtra("mode", "computer");
        intent.putExtra("name_player", name);
    }

    public void onFinishDialogSymbol(String symbol) {
        intent.putExtra("symbol", symbol);
        startActivity(intent);
    }

}
