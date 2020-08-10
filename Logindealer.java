package e.margi.qbapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Logindealer extends AppCompatActivity
{
    EditText et_email, et_pass;
    Button btn_login;
    //TextView tv_forgot;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindealer);
        et_email = findViewById(R.id.loginemail);
        et_pass = findViewById(R.id.loginpass);
        btn_login = findViewById(R.id.lgnbtn);
       // tv_forgot = findViewById(R.id.tv_forgot);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString().trim();
                String pass = et_pass.getText().toString().trim();




                firebaseAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(Logindealer.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    startActivity(new Intent(Logindealer.this, Upipayment.class));
                                    Toast.makeText(Logindealer.this, "Login Successfully....", Toast.LENGTH_SHORT).show();
                                    //startActivity(new Intent(Login_form.this,Backtologin.class));


                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Logindealer.this, "Login Failed or User not Available ", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });

    }
}
