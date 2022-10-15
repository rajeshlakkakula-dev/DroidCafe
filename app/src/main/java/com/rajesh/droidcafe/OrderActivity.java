package com.rajesh.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        if(spinner != null){
            spinner.setAdapter(adapter);
        }

    }


    public  void displayToast(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){

            case R.id.sameDay: if(checked) displayToast("Same Day messenger Service");
            break;
            case R.id.nextDay: if(checked) displayToast("Next day ground delivery");
            break;
            case R.id.pickup: if(checked) displayToast("Pick Up");
            break;

            default: break;


        }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}