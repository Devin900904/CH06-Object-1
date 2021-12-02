package tw.tcnr14.m0701;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;




public class M0701 extends AppCompatActivity implements
        ViewSwitcher.ViewFactory, AdapterView.OnItemClickListener {

    private Integer[] imgArr = {
            R.drawable.img01, R.drawable.img02,
            R.drawable.img03, R.drawable.img04,
            R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08,
            R.drawable.img09, R.drawable.img10,
            R.drawable.img11, R.drawable.img12,
            R.drawable.img13,R.drawable.img14,
            R.drawable.img15,R.drawable.img16,
    };    private Integer[] thumbImgArr = {
            R.drawable.img01th, R.drawable.img02th,
            R.drawable.img03th, R.drawable.img04th,
            R.drawable.img05th, R.drawable.img06th,
            R.drawable.img07th, R.drawable.img08th,
            R.drawable.img09th, R.drawable.img10th,
            R.drawable.img11th, R.drawable.img12th,
            R.drawable.img13th,R.drawable.img14th,
            R.drawable.img15th,R.drawable.img16th,
    };

    private final String TAG = "tcnr14=>";
    private GridView gridview;
    private ImageSwitcher imgSwi;

 private void setupViewcomponent() {
        // 從資源類別R中取得介面元件
        gridview = (GridView) findViewById(R.id.m0701_g001);
        imgSwi = (ImageSwitcher) findViewById(R.id.m0701_im01);
        imgSwi.setFactory((ViewSwitcher.ViewFactory)this);
        //將縮圖填入 GridView
//        gridview.setAdapter(new GridAdapter(this, thumbImgArr));
     gridview.setAdapter(new GridAdapter(this, thumbImgArr));
     gridview.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0701);
        Log.d(TAG, "onCreat()");
        setupViewcomponent();
    }

    // 圖庫的圖片資源索引


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0701, menu);
        return true;
    }

//    public boolean onOptionsItemSelected(MenuItem item) {
////         Handle action bar item clicks here. The action bar will
////         automatically handle clicks on the Home/Up button, so long
////         as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        switch (item.getItemId()) {
////            case R.id.action_settings:
////                break;
////            case R.id.m_about:
////                this.finish();
////                break;
//
//        }
//
//        if (id == R.id.action_settings) {
//            this.finish();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "進用返回建", Toast.LENGTH_LONG).show();
//        super.onBackPressed();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      imgSwi.setImageResource(imgArr[position]);
    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;

    }
}