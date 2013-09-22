package com.jogogalo.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by nbento on 21-09-2013.
 */
public class Preferences {

    private SharedPreferences pref;
    private final String prefName = "galoPref";

    private Preferences(Context mContext) {
        pref = mContext.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    public static Preferences getInstance(Context mContext) {
        return new Preferences(mContext);
    }

    public void saveDataPref(HashMap<String, String> dataPref) {

        Iterator it = dataPref.entrySet().iterator();

        SharedPreferences.Editor editor = pref.edit();

        while (it.hasNext()) {
            HashMap.Entry data = (HashMap.Entry) it.next();
            editor.putString((String) data.getKey(), (String) data.getValue());
        }

        editor.commit();

    }

    public HashMap<String, String> loadDataPref() {

        // TODO create load pref

        return null;

    }
}
