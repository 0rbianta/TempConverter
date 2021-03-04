package orbianta.github.basic.tempconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("temp_lib");
    }

/**
 * ids:
 * 1 : celsius
 * 2 : kelvin
 * 3 : fahrenheit
 * */

    private native_interface native_interface = new native_interface();

    private CardView celsius, fahrenheit, kelvin;
    private Button crun_btn, frun_btn, krun_btn;
    private EditText cetxt_usr, fetxt_usr, ketxt_usr;
    private TextView coutput, foutput, koutput;
    private RadioGroup ctemp_group, ftemp_group, ktemp_group;

    private void define_ui(){
        celsius = findViewById(R.id.celsius);
        fahrenheit = findViewById(R.id.fahrenheit);
        kelvin = findViewById(R.id.kelvin);

        crun_btn = findViewById(R.id.crun_btn);
        cetxt_usr = findViewById(R.id.cetxt_usr);
        coutput = findViewById(R.id.coutput);
        ctemp_group = findViewById(R.id.ctemp_group);

        frun_btn = findViewById(R.id.frun_btn);
        fetxt_usr = findViewById(R.id.fetxt_usr);
        foutput = findViewById(R.id.foutput);
        ftemp_group = findViewById(R.id.ftemp_group);

        krun_btn = findViewById(R.id.krun_btn);
        ketxt_usr = findViewById(R.id.ketxt_usr);
        koutput = findViewById(R.id.koutput);
        ktemp_group = findViewById(R.id.ktemp_group);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        define_ui();

        crun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cetxt_usr.getText().toString().isEmpty())    return;

                Float usr_entry = Float.valueOf(cetxt_usr.getText().toString());

                RadioButton selected_rad = findViewById(ctemp_group.getCheckedRadioButtonId());
                String selected = selected_rad.getText().toString();


                switch (selected){

                    case "Kelvin": {
                        coutput.setText(Float.toString(native_interface.celsius2kelvin(usr_entry)));
                        break;
                    }

                    case "Fahrenheit": {
                        coutput.setText(Float.toString(native_interface.celsius2fahrenheit(usr_entry)));
                        break;
                    }

                    default:
                        Log.d("debug", selected + " not found.");
                        System.exit(0);
                }

            }

        });

        frun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(fetxt_usr.getText().toString().isEmpty())    return;

                Float usr_entry = Float.valueOf(fetxt_usr.getText().toString());

                RadioButton selected_rad = findViewById(ftemp_group.getCheckedRadioButtonId());
                String selected = selected_rad.getText().toString();



                switch (selected){

                    case "Kelvin": {
                        foutput.setText(Float.toString(native_interface.fahrenheit2kelvin(usr_entry)));
                        break;
                    }

                    case "Celsius": {
                        foutput.setText(Float.toString(native_interface.fahrenheit2celsius(usr_entry)));
                        break;
                    }

                    default:
                        Log.d("debug", selected + " not found.");
                        System.exit(0);
                }

            }
        });

        krun_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ketxt_usr.getText().toString().isEmpty())    return;

                Float usr_entry = Float.valueOf(ketxt_usr.getText().toString());

                RadioButton selected_rad = findViewById(ktemp_group.getCheckedRadioButtonId());
                String selected = selected_rad.getText().toString();



                switch (selected){

                    case "Celsius": {
                        koutput.setText(Float.toString(native_interface.kelvin2celsius(usr_entry)));
                        break;
                    }

                    case "Fahrenheit": {
                        koutput.setText(Float.toString(native_interface.kelvin2fahrenheit(usr_entry)));
                        break;
                    }

                    default:
                        Log.d("debug", selected + " not found.");
                        System.exit(0);
                }

            }
        });


    }

    public void fahrenheit_clicked(View v){
        set_view(3);
    }

    public void kelvin_clicked(View v){
        set_view(2);
    }

    public void celsius_clicked(View v){
        set_view(1);
    }

    public void set_view(int id){
        
        koutput.setText("");
        coutput.setText("");
        foutput.setText("");
        
        switch (id){

            case 1:{
                celsius.setVisibility(View.VISIBLE);
                kelvin.setVisibility(View.GONE);
                fahrenheit.setVisibility(View.GONE);
                break;
            }

            case 2:{
                celsius.setVisibility(View.GONE);
                kelvin.setVisibility(View.VISIBLE);
                fahrenheit.setVisibility(View.GONE);
                break;
            }

            case 3:{
                celsius.setVisibility(View.GONE);
                kelvin.setVisibility(View.GONE);
                fahrenheit.setVisibility(View.VISIBLE);
                break;
            }

            default:
                Log.d("debug", id+" not found. Fatal error");
                System.exit(0);
        }
    }


}
