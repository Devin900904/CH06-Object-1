package tw.tcnr14.m0607;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0501 extends AppCompatActivity {


    private EditText e001;

    private Spinner s001;
    private TextView ans01;
    private Button b001;
    private AlertDialog.Builder s002;
    private String sSex;
    private String strsug;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0501);
        setupViewcomponent();

    }

    private void setupViewcomponent() {
//        =========================
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("classtitle");
        this.setTitle(mode_title);
//        =========================
        e001 = (EditText) findViewById(R.id.m0501_e001);
        s001 = (Spinner) findViewById(R.id.m0501_s001);
        ans01 = (TextView) findViewById(R.id.m0501_f000);
        b001 = (Button) findViewById(R.id.m0500_b001);
        b001.setOnClickListener(b001ON);
//        ArrayAdapter<CharSequence> adapterSexList = ArrayAdapter.createFromResource
//                (this, R.array.m0501_a001, R.layout.support_simple_spinner_dropdown_item);
//        --------------------------------------------------------------------------------------
        ArrayAdapter adapSexList = ArrayAdapter.createFromResource
                (this, R.array.m0501_a001, R.layout.spinner_item);
        s001.setAdapter(adapSexList);
//---------------------------------------

        s001.setOnItemSelectedListener(s001ON);
        // 設定 spinner item 選項------------
////        ArrayAdapter<CharSequence> adapSexList = ArrayAdapter
//                .createFromResource(this, R.array.m0501_a001,
//                        android.R.layout.simple_spinner_item);
//        adapSexList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        s001.setAdapter(adapSexList);
//---------------------------------------
    }


    private AdapterView.OnItemSelectedListener s001ON = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  //前面兩個是物件的類別

            sSex = parent.getSelectedItem().toString();   //sSex先放在一個暫存因為等等還要輸 入歲數


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    private View.OnClickListener b001ON = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strsug = getString(R.string.m0501_f000); //輸出定義


//            -----------------------------------------------------------
            //        檢查年齡是否輸入
            if (e001.getText().toString().length() > 0) {
                int iage = Integer.parseInt(e001.getText().toString());
//-------------------------男生--------------------------------------------
                if (sSex.equals(getString(R.string.chk01))) {
                    if (iage < 28) {
                        strsug += getString(R.string.m0501_f001);
                    } else if (iage > 33) {
                        strsug += getString(R.string.m0501_f003);
                    } else {
                        strsug += getString(R.string.m0501_f002);
                    }
//---------------------女生---------------------------------------------
                } else {
                    if (iage < 25) {
                        strsug += getString(R.string.m0501_f001);
                    } else if (iage > 30) {
                        strsug += getString(R.string.m0501_f003);
                    } else {
                        strsug += getString(R.string.m0501_f002);
                    }


                }
            } else {
                strsug = getString(R.string.nospace);
            }

            ans01.setText(strsug);
        }
    };
}

