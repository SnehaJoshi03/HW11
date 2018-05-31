package edu.gvsu.cis.geocalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Selection extends AppCompatActivity {
    int flag =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Spinner dist_spinner = (Spinner) findViewById(R.id.chooseDistUnit);
        Spinner bear_spinner = (Spinner) findViewById(R.id.chooseBearingUnit);

        // Adding options for selecting distance units
        List<String> dist_list = new ArrayList<String>();

        dist_list.add("Kilometers");
        dist_list.add("Miles");

        ArrayAdapter<String> dataAdapter_dist = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, dist_list);
        dataAdapter_dist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dist_spinner.setAdapter(dataAdapter_dist);

        // Adding options for selecting bearing units
        List<String> bear_list = new ArrayList<String>();

        bear_list.add("Degrees");
        bear_list.add("Mils");

        ArrayAdapter<String> dataAdapter_bear = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bear_list);
        dataAdapter_bear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bear_spinner.setAdapter(dataAdapter_bear);

        Intent payload = getIntent();
        if (payload.hasExtra("flag")) {


            if (dist_spinner.getSelectedItem() == "Kilometers" && bear_spinner.getSelectedItem() == "Degrees") {
                flag = 1;
            } else if (dist_spinner.getSelectedItem() == "Kilometers" && bear_spinner.getSelectedItem() == "Mils") {
                flag = 2;

            } else if (dist_spinner.getSelectedItem() == "Miles" && bear_spinner.getSelectedItem() == "Degrees") {
                flag = 3;

            } else if (dist_spinner.getSelectedItem() == "Miles" && bear_spinner.getSelectedItem() == "Mils") {
                flag = 4;

            }
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection.this, Calculate.class);
                Intent i = new Intent();

                setResult(flag, i);
                finish();
                startActivity(intent);
                finish();

            }
        });

    }

   /* private String selection = "Kilometers";
    private String selection1 = "Degrees";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                Intent intent = new Intent();
                intent.putExtra("dist", selection);
                setResult(Calculate.DUNITS_SELECTION,intent);
                finish();
            }
        });

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                Intent intent1 = new Intent();
                intent1.putExtra("bear", selection1);
                setResult(Calculate.BUNITS_SELECTION,intent1);
                finish();
            }
        });

        Spinner spinner1 = (Spinner) findViewById(R.id.chooseBearingUnit);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.bunits, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selection1 = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.chooseDistUnit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dunits, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }*/


}
