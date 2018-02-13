package com.example.qq.week5casestudy3setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;


/**
 * Created by qq on 14/2/2561.
 */

public class Setting extends PreferenceActivity implements OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.setting);

        Context context = getApplicationContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.registerOnSharedPreferenceChangeListener(this);
    }

    public static boolean getCheckSetting(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("keyCheck",true);
    }

    public static String getSelectItemSetting(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString("keySelectItem","1");
    }

    public static String getEditTextSetting(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString("keyEditText","Default");
    }

    public static boolean getCheckPettyScreenSetting(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("keyCheckPettyScreen",true);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}
