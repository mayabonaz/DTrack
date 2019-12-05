package android.rgu.dtrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView cvAddReadings, correction_calculator;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // defining card views
        cvAddReadings = findViewById(R.id.add_readings);
        correction_calculator = findViewById(R.id.correction_calculator);

        // define button
        myButton = findViewById(R.id.button);

        // adding Click listeners to the cards
        cvAddReadings.setOnClickListener(this);
        correction_calculator.setOnClickListener(this);
        myButton.setOnClickListener(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    // on click listener for menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();
        if (id == R.id.item_settings) {
            // create intent
            Intent intent = new Intent(this, SettingsActivity.class);
            // start settings activity
            this.startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_readings) {
            // create an Intent to start AddReadingActivity
            Intent intent = new Intent(getApplicationContext(), RecordTestActivity.class);
            // start the activity
            startActivity(intent);
        } else if (view.getId() == R.id.correction_calculator) {
            Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
            // start the activity
            startActivity(intent);
        } else if (view.getId() == R.id.button) {
            // create and intent to start Permissions Activity to launch MapActivity
            Intent intent = new Intent(getApplicationContext(), GetPermissionsActivity.class);
            startActivity(intent);
        }

    }
}