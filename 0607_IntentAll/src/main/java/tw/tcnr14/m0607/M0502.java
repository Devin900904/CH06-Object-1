package tw.tcnr14.m0607;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0502 extends AppCompatActivity {


    private EditText e001;
    //private String strsug;
    private Spinner s001;
    private TextView ans01;
    private Button b001;
    private AlertDialog.Builder s002;

    private RadioGroup rb001;
    private RadioGroup rb002;
    private RadioButton rb021;
    private RadioButton rb022;
    private RadioButton rb023;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0502);
        setupViewconponent();


//        }
    }

    private void setupViewconponent() {
        //        =========================
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("classtitle");
        this.setTitle(mode_title);
//        =========================
        ans01 = (TextView) findViewById(R.id.m0502_f000);
        b001 = (Button) findViewById(R.id.m0500_b001);
        rb001 = (RadioGroup) findViewById(R.id.m0502_r001);
        rb002 = (RadioGroup) findViewById(R.id.m0502_r002);
        rb021 = (RadioButton) findViewById(R.id.m0502_r002a);
        rb022 = (RadioButton) findViewById(R.id.m0502_r002b);
        rb023 = (RadioButton) findViewById(R.id.m0502_r002c);
        rb001.setOnCheckedChangeListener(rb001on);
        b001.setOnClickListener(b001ON);


    }

    private RadioGroup.OnCheckedChangeListener rb001on = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.m0502_r001a:
                    rb021.setText(R.string.m0502_r002aa);
                    rb022.setText(R.string.m0502_r002ab);
                    rb023.setText(R.string.m0502_r002ac);
                    break;
                case R.id.m0502_r001b:
                    rb021.setText(R.string.m0502_r002ba);
                    rb022.setText(R.string.m0502_r002bb);
                    rb023.setText(R.string.m0502_r002bc);
                    break;


            }

        }
    };


    private View.OnClickListener b001ON = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String strsug =getString(R.string.m0502_f000);
            int ichkses = rb001.getCheckedRadioButtonId();
            switch (ichkses) {
                case R.id.m0502_r001a:

                    switch (rb002.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strsug += getString(R.string.m0502_f001);
                            break;
                        case R.id.m0502_r002b:
                            strsug += getString(R.string.m0502_f002);
                            break;
                        case R.id.m0502_r002c:
                            strsug += getString(R.string.m0502_f003);
                            break;
                    }
                    break;
                case R.id.m0502_r001b:


                    switch (rb002.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strsug += getString(R.string.m0502_f004);
                            break;
                        case R.id.m0502_r002b:
                            strsug += getString(R.string.m0502_f005);
                            break;
                        case R.id.m0502_r002c:
                            strsug += getString(R.string.m0502_f006);
                            break;

                    }
                    break;


            }
            ans01.setText(strsug);
        }


    };


}

