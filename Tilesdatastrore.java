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

public class Tilesdatastrore extends AppCompatActivity {
    EditText avaiproductno, productno;
    Button storedata;
    //FirebaseAuth firebaseAuth;
    DatabaseReference mDatabaseReference;
    Tilesdata tilesdata;
    //FirebaseDatabase mDatabase;
   // DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tilesdatastrore);
        avaiproductno = (EditText) findViewById(R.id.availtiles);
        productno = (EditText) findViewById(R.id.tilescode);
        storedata = (Button) findViewById(R.id.senddata);
        //firebaseAuth = FirebaseAuth.getInstance();
        tilesdata = new Tilesdata();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Tilesdata");

        storedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Tilesdatastrore.this, "hii", Toast.LENGTH_SHORT).show();
                final String tilesno = productno.getText().toString();
                final String availtiles = avaiproductno.getText().toString();
                tilesdata.setTilesno(tilesno);
                tilesdata.setAvailabletiles(availtiles);
                mDatabaseReference.push().setValue(tilesdata);
                Toast.makeText(Tilesdatastrore.this,"Data inserted",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Tilesdatastrore.this,gettiledata.class));

            }
        });
    }
}

