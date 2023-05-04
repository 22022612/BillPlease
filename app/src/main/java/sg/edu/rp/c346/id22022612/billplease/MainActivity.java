package sg.edu.rp.c346.id22022612.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText Pax;
    EditText Amt;
    EditText Discount;
    ToggleButton NoSvs;
    ToggleButton Gst;
    RadioGroup paymentType;
    TextView Pay;
    TextView Bill;
    Button Split;
    Button reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pax =findViewById(R.id.Pax);
        Amt =findViewById(R.id.amt);
        Discount =findViewById(Discount);
        NoSvs =findViewById(R.id.NoSVS);
        Gst =findViewById(R.id.GST);
        paymentType =findViewById(R.id.paymentType);
        Pay =findViewById(R.id.Pays);
        Bill =findViewById(R.id.Bill);
        Split =findViewById(R.id.split);
        reset =findViewById(R.id.reset);
        double newamt = 0.0;

        Split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                if ((Integer.parseInt(Amt.getText().toString()) >= 0) && (Integer.parseInt(Pax.getText().toString()) > 1)) {
                    if (!NoSvs.isChecked() && !Gst.isChecked()) {
                        newamt = Amt.getText().toString() +
                    }
                }
            }
        });


    }
}