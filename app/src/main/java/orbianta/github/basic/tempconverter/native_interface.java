package orbianta.github.basic.tempconverter;

import android.content.Context;

public class native_interface {

/*    private Context in_native_context;

    public native_interface(Context context){
        in_native_context = context;
    }*/

    public native float celsius2fahrenheit(float value);
    public native float celsius2kelvin(float value);

    public native float fahrenheit2celsius(float value);
    public native float fahrenheit2kelvin(float value);

    public native float kelvin2celsius(float value);
    public native float kelvin2fahrenheit(float value);




}
