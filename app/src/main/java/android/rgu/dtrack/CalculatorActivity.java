package android.rgu.dtrack;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


public class CalculatorActivity extends AppCompatActivity {
    // defining global variables
    // variable targetNum, bloodTestNum, sensitivityNum for input numbers
    private EditText targetNum, bloodTestNum, sensitivityNum;
    private TextView moreInfo, result;
    private Button calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // add toolbar to calculator screen
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get edit text
        targetNum = findViewById(R.id.etTargetGlucose);
        bloodTestNum = findViewById(R.id.etGlucoseTestResult);
        sensitivityNum = findViewById(R.id.etSensitivityFactor);
        moreInfo = findViewById(R.id.tvMoreInfo);
        result = findViewById(R.id.tvCalcResult);

        // set TextChange listener for all edit text fields
        targetNum.addTextChangedListener(inputWatcher);
        bloodTestNum.addTextChangedListener(inputWatcher);
        sensitivityNum.addTextChangedListener(inputWatcher);


        // assigning link URL to linText variable
        String linkText = "More info <a href='https://www.digibete.org/essentials/'>here</a>";

        // making text clickable
        moreInfo.setText(Html.fromHtml(linkText));
        // launch URL when clicked on text
        moreInfo.setMovementMethod(LinkMovementMethod.getInstance());

        // get the Calculate button
        calcButton = findViewById(R.id.btnCalculate);

        // set the click listener to Calculate button
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try
                {
                    // convert to Integer type
                    int num1 = Integer.parseInt(targetNum.getText().toString());
                    int num2 = Integer.parseInt(bloodTestNum.getText().toString());
                    int num3 = Integer.parseInt(sensitivityNum.getText().toString());

                    // perform calculation store it in corrDose variable
                    double corrDose = (num2 - num1) / num3;

                    // creating string from calculation result and insulin unit
                    String s = Double.toString(corrDose) + " " + getString(R.string.unit);

                    // setting calculation result string to result Text View
                    result.setText(s);
                }
                catch (NumberFormatException ex)
                {
                    Toast.makeText(getApplicationContext(), getString(R.string.toastText), Toast.LENGTH_LONG).show();

                }

            }

        });
    }

    //
    private TextWatcher inputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        // method is called when text input added or removed from edit text views
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String targetNumInput = targetNum.getText().toString().trim();
            String bloodTestNumInput = bloodTestNum.getText().toString().trim();
            String sensitivityNumInput = sensitivityNum.getText().toString().trim();

            // enable calculate button only if edit texts are not empty,
            calcButton.setEnabled(!targetNumInput.isEmpty() && !bloodTestNumInput.isEmpty() && !sensitivityNumInput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}


