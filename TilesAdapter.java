package e.margi.qbapp;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public  class TilesAdapter extends RecyclerView.Adapter<TilesAdapter.viewholder>
{
    //Context mcontext;
    ArrayList<Tilesdata> tileslist;

    public TilesAdapter( ArrayList<Tilesdata> tileslist)
    {

        this.tileslist = tileslist;
        //this.mcontext=mcontext;
    }
    @NonNull
    @Override
    public TilesAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tiles_item,viewGroup,false);
        return new TilesAdapter.viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TilesAdapter.viewholder viewholder, int i) {

        Tilesdata tilesdata = tileslist.get(i);
        viewholder.tname.setText(tilesdata.getTilesno());
        viewholder.avtilesname.setText(tilesdata.getAvailabletiles());


        viewholder.itemView.setOnClickListener(
                new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //.startActivity(new Intent(mcontext,Logindealer.class));

            }
        });


    }



    @Override
    public int getItemCount() {
        return tileslist.size();
    }
    public  class viewholder extends RecyclerView.ViewHolder
    {
        public TextView tname,avtilesname;
        // public ImageView profile_image;

        public viewholder(@NonNull View itemView)
        {
            super(itemView);
            tname = itemView.findViewById(R.id.tilesname);
            avtilesname = itemView.findViewById(R.id.availtilesdata);

            // profile_image=itemView.findViewById(R.id.profile_image);
        }

    }
}
