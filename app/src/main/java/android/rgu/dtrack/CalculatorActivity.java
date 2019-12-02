package android.rgu.dtrack;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class CalculatorActivity extends AppCompatActivity {
    // defining global variables
    // variable targetNum, bloodTestNum, sensitivityNum for input numbers
    EditText targetNum, bloodTestNum, sensitivityNum;
    TextView moreInfo, result;

    int answer = 0;

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
        targetNum = (EditText) findViewById(R.id.etTargetGlucose);
        bloodTestNum = (EditText) findViewById(R.id.etGlucoseTestResult);
        sensitivityNum = (EditText) findViewById(R.id.etSensitivityFactor);
        moreInfo = (TextView) findViewById(R.id.tvMoreInfo);
        result = (TextView) findViewById(R.id.tvCalcResult);

        // open link
        String linkText = "More info <a href='https://www.digibete.org/essentials/'>here</a>";
        moreInfo.setText(Html.fromHtml(linkText));
        moreInfo.setMovementMethod(LinkMovementMethod.getInstance());



        // get the Calculate button
        Button calcButton = findViewById(R.id.btnCalculate);

        // set the click listener to Calculate button
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // get data which is in edit text, convert it to string
                // using parse Integer convert it to Integer type
                int num1 = Integer.parseInt(targetNum.getText().toString());
                int num2 = Integer.parseInt(bloodTestNum.getText().toString());
                int num3 = Integer.parseInt(sensitivityNum.getText().toString());

                // perform calculation store it in corrDose variable
                double corrDose = (num2 - num1) / num3;

                // set it to result textview
                result.setText(Double.toString(corrDose));
            }

        });
    }
}
