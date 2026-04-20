package thigk2.phanhuyhung.kiemtragk_65131182;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {

    private List<Attraction> attractions;
    private Context context;

    public AttractionAdapter(Context context, List<Attraction> attractions) {
        this.context = context;
        this.attractions = attractions;
    }

    @NonNull
    @Override
    public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_attraction, parent, false);
        return new AttractionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {
        Attraction attraction = attractions.get(position);

        holder.tvLocationName.setText(attraction.getName());
        holder.tvLocationAddress.setText(attraction.getAddress());
        holder.ivLocationImage.setImageResource(attraction.getImageResId());
    }

    @Override
    public int getItemCount() {
        return attractions.size();
    }

    static class AttractionViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLocationImage;
        TextView tvLocationName;
        TextView tvLocationAddress;

        public AttractionViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLocationImage = itemView.findViewById(R.id.iv_location_image);
            tvLocationName = itemView.findViewById(R.id.tv_location_name);
            tvLocationAddress = itemView.findViewById(R.id.tv_location_address);
        }
    }
}
