package sg.edu.rp.c346.id18004536.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText number;
    EditText pax;
    DatePicker dp;
    TimePicker tp;
    CheckBox smoke;
    Button submit;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        number = findViewById(R.id.etMobile);
        pax = findViewById(R.id.etpax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        smoke = findViewById(R.id.checkBox);
        submit = findViewById(R.id.submit);
        clear = findViewById(R.id.clear);

        dp.updateDate(2020,5,1);
        tp.setIs24HourView(true);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String nameInput = name.getText().toString().trim();
                String numberInput = number.getText().toString().trim();
                String paxInput = pax.getText().toString().trim();


                if(TextUtils.isEmpty(numberInput) || TextUtils.isEmpty(nameInput) || TextUtils.isEmpty(paxInput)) {
                    Toast.makeText(MainActivity.this,"All input items cannot be empty!",Toast.LENGTH_LONG).show();
                    return;
                }


                if (smoke.isChecked()) {

                    String Output=String.format("Reservation made on %02d:%02d %02d/%02d/%02d for %s with mobile no. %s for total of %s peoples with smoking area selected",tp.getCurrentHour(),tp.getCurrentMinute(),dp.getDayOfMonth(),dp.getMonth()+1,dp.getYear(),nameInput,numberInput,paxInput);

                    Toast.makeText(MainActivity.this,Output,Toast.LENGTH_LONG).show();
                }

                else{
                    String Output=String.format("Reservation made on %02d:%02d %02d/%02d/%02d for %s with mobile no. %s for total of %s peoples",tp.getCurrentHour(),tp.getCurrentMinute(),dp.getDayOfMonth(),dp.getMonth()+1,dp.getYear(),nameInput,numberInput,paxInput);

                    Toast.makeText(MainActivity.this,Output,Toast.LENGTH_LONG).show();
                }

            }
        });


        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                dp.updateDate(2020,5,1);
                tp.setIs24HourView(true);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                name.setText("");
                number.setText("");
                pax.setText("");
                smoke.setChecked(false);
            }
        });


    }


}
