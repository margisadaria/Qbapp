package e.margi.qbapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {
    EditText edname,edemail,edpass,edmobile;
    Button b2;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edname = (EditText)findViewById(R.id.edname);
        edemail = (EditText)findViewById(R.id.edemail);
        edpass = (EditText)findViewById(R.id.edpass);
        edmobile = (EditText)findViewById(R.id.edmobie);

        b2 = (Button)findViewById(R.id.button);
        firebaseAuth = FirebaseAuth.getInstance();
       // database = FirebaseDatabase.getInstance();
       // databaseReference=database.getReference("Dealer");

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hii", Toast.LENGTH_SHORT).show();
                final String ename = edname.getText().toString();
                final String econtact = edmobile.getText().toString();
                final String eemail = edemail.getText().toString();
                final String epass = edpass.getText().toString();


                firebaseAuth.createUserWithEmailAndPassword(eemail, epass)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();

                                if (task.isSuccessful()) {
                                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                    String userid = firebaseUser.getUid();
                                    databaseReference = FirebaseDatabase.getInstance().getReference("Dealer").child(userid);
                                    Dealer dealer = new Dealer(
                                            ename,
                                            econtact,
                                            eemail,
                                            epass
                                            );

                                    databaseReference.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            Dealer dealer1 = dataSnapshot.getValue(Dealer.class);

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    FirebaseDatabase.getInstance().getReference("Dealer")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(dealer).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            startActivity(new Intent(MainActivity.this, Upipayment.class));
                                            Toast.makeText(MainActivity.this, "Registration successfull----y....", Toast.LENGTH_SHORT).show();

                                            // startActivity(new Intent(Registrationpage.this, BacktoLogin.class));
                                        }
                                    });


                                } else {

                                    Toast.makeText(MainActivity.this, "Registration Failed....", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }

    });

}
    }
