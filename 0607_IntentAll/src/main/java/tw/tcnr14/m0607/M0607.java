package tw.tcnr14.m0607;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class M0607 extends AppCompatActivity {

    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;
    private Button b005;
    private Intent intent = new Intent();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0607);
        setComponent();
    }

    private void setComponent() {
        b001 = (Button)findViewById(R.id.m0607_b001);
        b002 = (Button)findViewById(R.id.m0607_b002);
        b003 = (Button)findViewById(R.id.m0607_b003);
        b004 = (Button)findViewById(R.id.m0607_b004);
        b005 = (Button)findViewById(R.id.m0607_b005);

        b001.setOnClickListener(b001On);
        b002.setOnClickListener(b001On);
        b003.setOnClickListener(b001On);
        b004.setOnClickListener(b001On);
        b005.setOnClickListener(b001On);



    }


    private View.OnClickListener b001On=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.m0607_b001:
                    intent.putExtra("classtitle", getString(R.string.m0000_b0500));
                    intent.setClass(M0607.this,M0500.class);
                    break;

                case R.id.m0607_b002:
                    intent.putExtra("classtitle", getString(R.string.m0000_b0501));
                    intent.setClass(M0607.this,M0501.class);
                    break;
                case R.id.m0607_b003:
                    intent.putExtra("classtitle", getString(R.string.m0000_b0502));
                    intent.setClass(M0607.this,M0502.class);
                    break;
            }
            startActivity(intent);

        }
    };
}