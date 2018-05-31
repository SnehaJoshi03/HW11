package edu.gvsu.cis.geocalculator;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.data;



public class Calculate extends AppCompatActivity {

    public double dist = 0.0;
    public double bear = 0.0;
    double lat1,long1,lat2,long2;

    private Button Calculatedis, Clear;
    private EditText latp1, longp1, latp2, longp2, distance, bearing;
    public static final int DUNITS_SELECTION = 1;
    public static final int BUNITS_SELECTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        Calculatedis = (Button) findViewById(R.id.calculatebutton);
        Clear = (Button) findViewById(R.id.clearbutton);
        Button settings = (Button) findViewById(R.id.settingsButton);
        latp1 = (EditText) findViewById(R.id.latp1);
        longp1 = (EditText) findViewById(R.id.longp1);
        latp2 = (EditText) findViewById(R.id.latp2);
        longp2 = (EditText) findViewById(R.id.longp2);
        distance = (EditText) findViewById(R.id.distance);
        bearing = (EditText) findViewById(R.id.bearing);

        settings.setOnClickListener(view -> {
            Intent intent = new Intent(this, Selection.class);
            intent.putExtra("flag",1);
            startActivityForResult(intent,1);
        });

        Calculatedis.setOnClickListener(v -> {
            /*String l1 = latp1.getText().toString();
            if(l1.length()==0){
                Snackbar.make(latp1,"Enter a value", Snackbar.LENGTH_LONG).show();
            }*/
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(Calculatedis.getWindowToken(),0);

            lat1 = Double.parseDouble(latp1.getText().toString());
            long1 = Double.parseDouble(longp1.getText().toString());
            lat2 = Double.parseDouble(latp2.getText().toString());
            long2 = Double.parseDouble(longp2.getText().toString());

            Location loc1 = new Location("location1");

            loc1.setLatitude(lat1);
            loc1.setLongitude(long1);

            Location loc2 = new Location("location2");

            loc2.setLatitude(lat2);
            loc2.setLongitude(long2);

            dist = loc1.distanceTo(loc2);
            dist = dist/1000;

            bear = loc1.bearingTo(loc2);
            distance.setText(""+dist);
            bearing.setText(""+bear);


        });


        Clear.setOnClickListener(v-> {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(Clear.getWindowToken(),0);
                latp1.setText("");
                latp2.setText("");
                longp1.setText("");
                longp2.setText("");
                distance.setText("");
                bearing.setText("");

        });


    }



      /*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }



      @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item:
                Intent intent = new Intent(this, Selection.class);
                /*Intent intent = new Intent(this, Selection.class);
                startActivityForResult(intent,1);
                Intent intent = new Intent(Calculate.this, Selection.class);
                startActivityForResult(intent, DUNITS_SELECTION);
                Intent intent1 = new Intent(Calculate.this, Selection.class);
                startActivityForResult(intent1, BUNITS_SELECTION);*/
       /*         return true;

       }
       return super.onOptionsItemSelected(item);
    }*/




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK) {

        if ( resultCode  == 1) {

            bearing.setText("" +bear);
            distance.setText("" +dist);

        } else if (resultCode == 2) {

            bear = bear * 17.777;
            bearing.setText("" + bear);
            distance.setText("check" + dist);

        } else if (resultCode == 3) {
            dist = dist * 0.621371;
            bearing.setText("" + bear);
            distance.setText("" + dist);
        } else if(resultCode == 4){
            bear = bear * 17.777;
            dist = dist * 0.621371;
            bearing.setText("" + bear);
            distance.setText("" + dist);

        }

        super.onActivityResult(requestCode, resultCode, data);
        }

    }
}

