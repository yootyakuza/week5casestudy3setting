package com.example.qq.week5casestudy3setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bts;
    TextView tvCheck, tvSelect, tvEdit, tvCheckScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bts = (Button)findViewById(R.id.btSetting);
        tvCheck = (TextView)findViewById(R.id.txtCheck);
        tvSelect = (TextView)findViewById(R.id.txtSelect);
        tvEdit = (TextView)findViewById(R.id.txtEditText);
        tvCheckScreen = (TextView)findViewById(R.id.txtCheckPettyScreen);
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEdit();
            }
        });
    }
    public void showEdit(){
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        boolean check = Setting.getCheckSetting(getApplicationContext());
        int itemSelect = Integer.parseInt(Setting.getSelectItemSetting(getApplicationContext()));
        String editText = Setting.getEditTextSetting(getApplicationContext());
        boolean checkPettyScreen = Setting.getCheckPettyScreenSetting(getApplicationContext());

        if(check)
            tvCheck.setText("Check : True");
        else
            tvCheck.setText("Check : False");

        tvSelect.setText("Select Item: " + itemSelect);
        tvEdit.setText("Edit Text : " + editText);


        if(checkPettyScreen)
            tvCheckScreen.setText("CheckPettyScreem : True");
        else
            tvCheckScreen.setText("CheckPettyScreen : False");
    }
}
