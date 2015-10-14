package ctec.stateapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;


import ctec.stateapp.R;

public class BackPage extends AppCompatActivity {

    private Button sendToOtherScreenButton;
    private EditText nameText;
    private EditText ageText;
    private CheckBox tiredBox;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_page);

        saveState = getAppliction();

        sendToOtherScreenButton = (Button) findViewById(R.id.submitButton);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText= (EditText) findViewById(R.id.ageText);
        tiredBox = (CheckBox) findViewById(R.id.isTiredBox);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_back_page, menu);
        return true;
    }
    private void setupListener()
    {
        sendToOtherScreenBuon.setOnClickListener(new View.OnClickListener()
        {
            String name = nameText.getText().toString();
           int age = Integer.parseInt(ageText.getText().toString());
            boolean tired = tiredBox.isChecked();

            saveState.setAge(age);
            saveState.setUserName(name);
            saveState.IsTired(tired);

            Intent newScreenIntent = new Intent(clickView.getContext(), BackPageActivity.class);
            startActivityForResult (newScreenIntent, 0);

        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
