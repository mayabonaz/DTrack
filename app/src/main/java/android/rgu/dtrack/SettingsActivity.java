package android.rgu.dtrack;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Implementation for the settings activity
 */

public class SettingsActivity extends AppCompatActivity {

    private static final String TAG = SettingsActivity.class.getCanonicalName();

    // Shared Preferences for storing the settings
    private EditText etSensitivityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        // add toolbar to settings screen
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // initialising views onCreate
        etSensitivityInput = findViewById(R.id.etSensitivityInput);
        Button bnSave = findViewById(R.id.bnSave);

        // setting onClick listener to Save button
        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // instantiating SharedPreferences
                SharedPreferences sharedPrefs = getSharedPreferences("MyShared", MODE_PRIVATE);

                // get the shared preference editor
                SharedPreferences.Editor myEditor = sharedPrefs.edit();

                // store input as a value of the key - factor
                myEditor.putInt("factor",Integer.parseInt(etSensitivityInput.getText().toString()));

                // apply the edits to shared preferences
                myEditor.apply();
                // Display confirmation message
                Toast.makeText(getApplicationContext(),getString(R.string.factorSavedMsg), Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    // Saving shared prefs on pause state
    @Override
    protected void onPause() {
        super.onPause();
    }

    // Loading shared prefs onResume state
    @Override
    public void onResume() {
        super.onResume();

        // loading the shared preferences data
        SharedPreferences sharedPrefs1 = getSharedPreferences("MyShared", MODE_PRIVATE);
        int myfactor = sharedPrefs1.getInt("factor", 0);

        // setting value to Sensitivity Factor
        etSensitivityInput.setText(String.valueOf(myfactor));
    }

}
