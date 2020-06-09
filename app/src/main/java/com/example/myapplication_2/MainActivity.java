package com.example.myapplication_2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioButton, radioButton4,radioButton2,radioButton3;//选择按钮
    private Button button;//计算按钮
    private List<RadioButton> radioButtons = new ArrayList<RadioButton>();
    private EditText editText,editText2;//两个输入框
    private RadioGroup radioGroup;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        button = (Button) findViewById(R.id.button);
        radioButtons.add(radioButton);
        radioButtons.add(radioButton2);
        radioButtons.add(radioButton3);
        radioButtons.add(radioButton4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float x = Float.valueOf(editText.getText().toString());
                float y = Float.valueOf(editText2.getText().toString());
                float z=0;
                if(radioButton.isChecked()){
                    z=x+y;
                }
                else if(radioButton2.isChecked()){
                    z=x-y;
                }
                else if(radioButton3.isChecked()){
                    z=x*y;
                }
                else if(radioButton4.isChecked()){
                    z=x/y;
                }

                DecimalFormat format = new DecimalFormat("###.##");
                String formatted = format.format(z);
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                Bundle b = new Bundle();
                b.putString("text",""+formatted);
                intent.putExtras(b);
                startActivityForResult(intent,1);

            }
        });



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case RESULT_OK:
            editText.setText(data.getExtras().getString("data"));
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
