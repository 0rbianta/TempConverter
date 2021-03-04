package orbianta.github.basic.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class celsius extends AppCompatActivity {

    private EditText etxt_usr;
    private TextView output;
    private Button run_btn;
    private RadioGroup temp_group;
    private native_interface native_interface = new native_interface();


    private void define_ui(){

        etxt_usr = findViewById(R.id.etxt_usr);
        output = findViewById(R.id.output);
        run_btn = findViewById(R.id.run_btn);
        temp_group = findViewById(R.id.temp_group);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celsius);

        define_ui();


        run_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Float usr_entry = Float.valueOf(etxt_usr.getText().toString());

                RadioButton selected_rad = findViewById(temp_group.getCheckedRadioButtonId());
                String selected = selected_rad.getText().toString();



                switch (selected){

                    case "Kelvin": {
                        output.setText(Float.toString(native_interface.celsius2kelvin(usr_entry)));
                        break;
                    }

                    case "Fahrenheit": {
                        output.setText(Float.toString(native_interface.celsius2fahrenheit(usr_entry)));
                        break;
                    }

                    default:
                        Log.d("debug", selected + " not found.");
                        System.exit(0);
                }

            }
        });



    }
}