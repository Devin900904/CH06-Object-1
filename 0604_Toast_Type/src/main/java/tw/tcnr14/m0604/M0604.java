package tw.tcnr14.m0604;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class M0604 extends AppCompatActivity {

    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;
    private Toast toast;
    private LinearLayout toastView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0604);
        setupConent();
    }

    private void setupConent() {
        b001 = (Button)findViewById(R.id.m0604_b001);
        b002 = (Button)findViewById(R.id.m0604_b002);
        b003 = (Button)findViewById(R.id.m0604_b003);
        b004 = (Button)findViewById(R.id.m0604_b004);

        b001.setOnClickListener(b001On);
        b002.setOnClickListener(b001On);
        b003.setOnClickListener(b001On);
        b004.setOnClickListener(b001On);




    }


    private ImageView ImageCodeProject;
    private View.OnClickListener b001On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            toast = null;
            switch (v.getId()){

                case R.id.m0604_b001:  //默認toast
                    Toast.makeText(getApplicationContext(), getText(R.string.m0604_t001), Toast.LENGTH_LONG).show(); //誰用   顯示的內容  顯示時間長短

                break;
                case R.id.m0604_b002:  // 自訂義顯示位置
                    toast =Toast.makeText(getApplicationContext(), getText(R.string.m0604_t002), Toast.LENGTH_LONG);
                     toast.setGravity(Gravity.CENTER| Gravity.START , 0, 0);
                     toast.show();
                    break;
                case R.id.m0604_b003:
                    toast =Toast.makeText(getApplicationContext(), getText(R.string.m0604_t003), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP| Gravity.END , 0, 0);

                    toastView = (LinearLayout) toast.getView();
                ImageView imageViewCodeProject = new ImageView(getApplicationContext());
                ImageCodeProject.setImageResource(R.drawable.stone);
                toastView.addView(imageViewCodeProject,0);
                toast.show();





                    break;
                case R.id.m0604_b004:
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = ((LayoutInflater) inflater).inflate(R.layout.custom, (ViewGroup) findViewById(R.id.llToast));

                    ImageView image = (ImageView) layout.findViewById(R.id.tvImageToast);
                    TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                    TextView text = (TextView) layout.findViewById(R.id.tvTextToast);

                    image.setImageResource(R.drawable.net);
                    title.setText(getString(R.string.m0604_t001).toString());
                    text.setText(getString(R.string.m0604_t003).toString());
//-----------------------------------
                    toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.START|Gravity.TOP, 20, 0);
                    toast.setView(layout);
                    toast.show();
                    break;









//                toastView = (LinearLayout) toast.getView();
//                ImageView imageCodeProject = new ImageView(getApplicationContext());
//                imageCodeProject.setImageResource(R.drawable.ic_sample);
//                toastView.addView(imageCodeProject, 0);


            }

        }
    };
}