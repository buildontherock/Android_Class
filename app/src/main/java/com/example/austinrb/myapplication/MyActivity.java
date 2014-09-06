package com.example.austinrb.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {

    private int total;
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //allows you to pick up where you left off
        super.onCreate(savedInstanceState);
        //calling the xml file
        setContentView(R.layout.activity_my);

        if(savedInstanceState != null){
            CharSequence ans = savedInstanceState.getCharSequence("ansText");
            myTextView.setText(ans);
            total = Integer.parseInt(ans.toString());
        }
    }

    public void onCLick(View v) {
        Button myButton = (Button) v;
        String bText = (String) myButton.getText();
        int value = Integer.parseInt(bText);
        total += value;

        myTextView = (TextView) findViewById(R.id.myTextView);
        myTextView.setText(Integer.toString(total));
    }

    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.getCharSequence("ansText", myTextView.getText());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
