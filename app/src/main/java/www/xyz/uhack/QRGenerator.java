package www.xyz.uhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QRGenerator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrgenerator);
        Button btnQRGen;
        final EditText edttxt;
        final TextView tv;
        btnQRGen = findViewById(R.id.btnQRGen);
        edttxt = findViewById(R.id.editText10);
        tv = findViewById(R.id.textView);

        btnQRGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameValue = edttxt.getText().toString();

                Intent i = new Intent(QRGenerator.this , QRImageActivity.class);
                i.putExtra("NAME", tv.getText().toString());
                startActivity(i);
            }
        });






    }
}
