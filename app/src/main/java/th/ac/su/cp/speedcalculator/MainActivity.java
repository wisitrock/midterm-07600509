package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText distancetext = findViewById(R.id.text_distance);
                distancetext.setText(null);
                EditText timetext = findViewById(R.id.text_time);
                timetext .setText(null);
                TextView result = findViewById(R.id.result_text);
                result.setText(null);
            }
        });

        Button calButton = findViewById(R.id.button_calculate);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText distancetext = findViewById(R.id.text_distance);
                String numdistance = distancetext.getText().toString();
                Log.i("MainActivity", "numdistance : " + numdistance);
                // double mydistance = Double.parseDouble(numdistance);


                EditText timetext = findViewById(R.id.text_time);
                String numtime = timetext.getText().toString();
                Log.i("MainActivity", "numtime : " + numtime);
                //  double mytime = Double.parseDouble(numtime);

                if (numdistance.length() == 0 || numtime.length() == 0) {
                    Toast t = Toast.makeText(
                            MainActivity.this,
                            R.string.disandtimerequired
                            , Toast.LENGTH_LONG
                    );
                    t.show();

                } else{
                    double mydistance = Double.parseDouble(numdistance);
                    double mytime = Double.parseDouble(numtime);
                    if (mytime == 0) {
                    Toast t = Toast.makeText(
                            MainActivity.this,
                            R.string.timethanzero
                            , Toast.LENGTH_LONG
                    );
                    t.show();
                }else{
                       double velocity = (mydistance/mytime)*18/5;
                        Log.i("MainActivity", "numdistance : " + velocity);
                        TextView result = findViewById(R.id.result_text);
                        String relultvelocity = String.format(
                                Locale.getDefault(), "%.2f", velocity
                        );
                        result.setText(relultvelocity);
                        if(velocity>80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.speedover);
                            dialog.setPositiveButton("Yes",null);
                            dialog.show();

                        }

                    }

            }
            }
        });
    }
}