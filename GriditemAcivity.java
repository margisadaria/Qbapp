package e.margi.qbapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GriditemAcivity extends AppCompatActivity
{
    TextView name;
    ImageView image;
    Button btnpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_griditem_acivity);

        name = findViewById(R.id.griddata);
        image=findViewById(R.id.imageview);

        btnpay = findViewById(R.id.btnpay);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image",0));

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),Upipayment.class);
                startActivity(intent);

            }
        });
    }
}
