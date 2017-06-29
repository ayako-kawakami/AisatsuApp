package jp.techacademy.ayako.kawakami.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String aisatsu;
    int hour = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                        hour = hourOfDay;

                        TextView text = (TextView) findViewById(R.id.text);
                        if (hour >= 2 && hour < 10) {
                            aisatsu = "おはよう";
                        } else if (hour >= 10 && hour < 18) {
                            aisatsu = "こんにちは";
                        } else if ((hour >= 18 && hour <= 24) || (hour >= 0 && hour < 2)) {
                            aisatsu = "こんばんは";
                        } else {
                            aisatsu = "エラー";
                        }
                        text.setText(aisatsu);
                    }
                },
                0,
                0,
                true);
        timePickerDialog.show();
    }
}
