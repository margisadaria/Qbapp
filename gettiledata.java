package e.margi.qbapp;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
public class gettiledata extends AppCompatActivity {
  // private SearchView editsearch;
    DatabaseReference databaseReference;
    RecyclerView recyclerViewdoctor;
   // ArrayList<Tilesdata> dlist;
    TilesAdapter tilesAdapter;
    //TilesAdapter adapter;
    ArrayList<Tilesdata> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);

        recyclerViewdoctor = (RecyclerView) findViewById(R.id.recyclerviewtilesdata);
       // editsearch = findViewById(R.id.searchView);
        recyclerViewdoctor.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<Tilesdata>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Tilesdata");
    }

    @Override
    protected void onStart()
    {
        if (databaseReference != null) {
        super.onStart();
    databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                list = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    list.add(snapshot.getValue(Tilesdata.class));


                    String availabletiles = snapshot.child("availabletiles").getValue().toString();
                    String tilesno = snapshot.child("tilesno").getValue().toString();
                    // String email=snapshot.child("demail").getValue().toString();
                    //String pass=snapshot.child("dpass").getValue().toString();*/
                    Tilesdata tilesdata = new Tilesdata(availabletiles, tilesno);
                    list.add(tilesdata);
                }


                tilesAdapter = new TilesAdapter(list);
                recyclerViewdoctor.setAdapter(tilesAdapter);
            }
        @Override
        public void onCancelled(@NonNull DatabaseError databaseError)
        {

        }
    });



        }
    }
/*if (editsearch != null) {
                editsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String s) {
                        search(s);
                        return false;
                    }
                });
            }

        }
            private void search(String s) {
                ArrayList<Tilesdata> mylist = new ArrayList<>();
                for (Tilesdata object : list) {
                    if (object.getTilesno().toLowerCase().contains(s.toLowerCase())) {
                        mylist.add(object);
                    }/* else if (object.getGuide().toLowerCase().contains(s.toLowerCase())) {
                                mylist.add(object);
                            } else if (object.getClg().toLowerCase().contains(s.toLowerCase())) {
                                mylist.add(object);*/

          /*      }

                TilesAdapter adapterclass = new TilesAdapter(mylist);
                recyclerViewdoctor.setAdapter(adapterclass);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/
            }

