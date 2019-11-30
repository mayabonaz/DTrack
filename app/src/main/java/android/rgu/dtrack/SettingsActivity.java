package android.rgu.dtrack;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Implementation for the settings activity
 */

public class SettingsActivity extends AppCompatActivity {

    private static final String TAG = SettingsActivity.class.getCanonicalName();

    private static final String sharedPrefFile = "android.rgu.dtrack";
    //private SharedPreferences sharedPrefs;
    // Shared Preferences for storing the settings
    private EditText etSensitivityInput;
    private Button bnSave;

//    public static final String FACTOR = "factor";
//    private String factorOutput;


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
        bnSave = findViewById(R.id.bnSave);

        // setting onClick listener to Save button
        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // instantiating SharedPreferences
                SharedPreferences sharedPrefs = getSharedPreferences("MyShared", MODE_PRIVATE);
                SharedPreferences.Editor myEditor = sharedPrefs.edit();
                myEditor.putInt("factor",Integer.parseInt(etSensitivityInput.getText().toString()));
                myEditor.apply();

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


    // Saving shard prefs on pause state
    @Override
    protected void onPause() {
        super.onPause();

    }

    // Loading shared prefs onResume state
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPrefs1 = getSharedPreferences("MyShared", MODE_PRIVATE);
        int myfactor = sharedPrefs1.getInt("factor", 0);

        // setting value to Sensitivity Factor
        etSensitivityInput.setText(String.valueOf(myfactor));
    }

}
