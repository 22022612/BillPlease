package sg.edu.rp.c346.id22022612.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
    RadioButton Cash;
    RadioButton paynow;
    EditText Phone;
    TextView Pay;
    TextView Bill;
    Button Split;
    Button reset;
    TextView perPax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pax =findViewById(R.id.Pax);
        Amt =findViewById(R.id.amt);
        Discount =findViewById(R.id.Discount);
        NoSvs =findViewById(R.id.NoSVS);
        Gst =findViewById(R.id.GST);
        paymentType =findViewById(R.id.paymentType);
        Pay =findViewById(R.id.Pays);
        Bill =findViewById(R.id.Bill);
        Split =findViewById(R.id.split);
        reset =findViewById(R.id.reset);
        Cash =findViewById(R.id.Cash);
        paynow =findViewById(R.id.paynow);
        perPax =findViewById(R.id.Pax);
        Phone =findViewById(R.id.phone);
        double newamt = 0.0;

        Split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                if (Amt.getText().toString().trim().length() != 0 && Pax.getText().toString().trim().length() != 0) {
                    double newamt = 0.0;
                    if (!NoSvs.isChecked()) {
                        double Amount = Double.parseDouble(Amt.getText().toString());
                    } else if (NoSvs.isChecked() && Gst.isChecked()) {
                        newamt = Double.parseDouble(Amt.getText().toString()) * 1.18;


                    }
                    if (Discount.getText().toString().trim().length() != 0) {
                        newamt *= 1 - Double.parseDouble(Discount.getText().toString()) / 100;
                    }
                    if (paymentType.getCheckedRadioButtonId() == R.id.Cash) {
                        String mode = "In Cash";
                    } else {
                        String mode = "Via PayNow to" + Phone;

                    }
                    Bill.setText("Total Bill: $" + String.format("%.2f", newamt));
                    int totalpax = Integer.parseInt(Pax.getText().toString());
                    if (totalpax != 1) {
                        Pay.setText("Each Pays: $" + String.format("%.2f", newamt / totalpax));

                    } else {
                        perPax.setText("Each Pays: $" + newamt);
                    }
                    reset.setOnClickListener((new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Amt.setText("");
                            Pax.setText("");
                            NoSvs.setChecked(false);
                            Gst.setChecked(false);
                            Discount.setText("");
                        }

                }));
            }
        }
    });

}
}