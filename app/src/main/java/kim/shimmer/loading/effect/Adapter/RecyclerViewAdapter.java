package kim.shimmer.loading.effect.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.List;
import kim.shimmer.loading.effect.Model.Students;
import kim.shimmer.loading.effect.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Students> mData ;

    public RecyclerViewAdapter(Context mContext, List<Students> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_student_list,parent,false) ;
        return new MyViewHolder(view) ;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_student_name;
        TextView tv_student_collage;
        TextView tv_student_specialization;
        TextView tv_student_description;
        ImageView img_student_profile;

        MyViewHolder(View itemView) {
            super(itemView);
            tv_student_name = itemView.findViewById(R.id.item_student_name_title);
            tv_student_collage = itemView.findViewById(R.id.item_student_college);
            tv_student_specialization = itemView.findViewById(R.id.item_student_specialization);
            tv_student_description = itemView.findViewById(R.id.item_student_description);
            img_student_profile = itemView.findViewById(R.id.item_profile_img);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_student_name.setText(mData.get(position).getName());
        holder.tv_student_collage.setText(mData.get(position).getCollege());
        holder.tv_student_specialization.setText(mData.get(position).getSpecialization());
        holder.tv_student_description.setText(mData.get(position).getDescription());
        Picasso.get()
                .load(mData.get(position).getProfile_img())
                .into(holder.img_student_profile);
    }
}