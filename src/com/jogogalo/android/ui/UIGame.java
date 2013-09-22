package com.jogogalo.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.android.jogogalo.R;
import com.jogogalo.model.Game;

import java.util.ArrayList;
import java.util.List;

public class UIGame extends Activity {

    private Button table[];
    private SharedPreferences preferences;
    private final String prefName = "galoPref";
    private Intent intent;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_galo);

        createTable();

        intent = getIntent();

        if (intent.getStringExtra("mode").equalsIgnoreCase("computer")) {

            List<String> data = new ArrayList<String>();
            data.add(intent.getStringExtra("name_player"));
            data.add(intent.getStringExtra("symbol"));
            data.add("computer");
            data.add(intent.getStringExtra("symbol").equalsIgnoreCase("x") ? "o".toUpperCase() : "x".toUpperCase());

            savePreferences(data);

            //game = new Game(new Human(0, 'X', intent.getStringExtra("name_player")), new Computer(0,0,'O'));
            //game.start();
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

    public void savePreferences(List<String> data) {
        preferences = getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("name_player", data.get(0));
        editor.putString("symbol_player", data.get(1));
        editor.putString("name_computer", data.get(2));
        editor.putString("symbol_computer", data.get(3));
        editor.commit();
    }

    public void createTable() {

        table = new Button[Game.SIZE_TABLE];

        for (int i = 0; i < Game.SIZE_TABLE; i++) {

            final int finalI = i;

            String button_id = "button" + i;
            // Get valor into class R
            int id_res = getResources().getIdentifier(button_id, "id",
                    getPackageName());
            table[i] = (Button) findViewById(id_res);

            table[i].setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    //table[finalI].setText();

                    Toast.makeText(v.getContext(), String.valueOf(finalI),
                            Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

}
