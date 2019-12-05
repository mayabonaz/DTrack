package android.rgu.dtrack;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.rgu.dtrack.adapters.ReadingsAdapter;
import android.rgu.dtrack.model.Readings;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;


public class RecordTestActivity extends AppCompatActivity {

    private static final String TAG = "RecordTestActivity";
    private RecyclerView recyclerView;
    private ArrayList<Readings> readings;
    private ReadingsAdapter adapter;
    private int checkedCount = 0;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_test);

        // add toolbar to screen
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // initialise recyclerView
        recyclerView = findViewById(R.id.readings_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // initialise floating button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void loadReadings() {
        this.readings = new ArrayList<>();
        for (int i=0; i<12; i++) {
            readings.add(new Readings("this is a demo output", new Date().getTime()));
        }
        //adapter = new ReadingsAdapter(readings);
        //recyclerView.setAdapter(adapter);
    }


    // on resume state load the blood test readings
    @Override
    protected void onResume() {
        super.onResume();
        loadReadings();
    }


}
