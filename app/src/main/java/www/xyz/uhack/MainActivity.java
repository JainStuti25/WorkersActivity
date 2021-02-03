package www.xyz.uhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText userName;
    EditText password;
    Button btnLogin;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currUser = mAuth.getCurrentUser();
        //Toast.makeText(this,"Already In",Toast.LENGTH_SHORT).show();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLogin = findViewById(R.id.btnLogin);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onRegister(View view) {
        final String myUser = userName.getText().toString();
        final String myPassword = password.getText().toString();
        mAuth.createUserWithEmailAndPassword(myUser, myPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "createUserWithEmail:success");
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}
