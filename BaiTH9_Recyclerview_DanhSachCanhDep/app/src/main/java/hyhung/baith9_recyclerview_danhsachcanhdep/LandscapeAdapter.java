package hyhung.baith9_recyclerview_danhsachcanhdep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Landscape> list;
    private OnItemClickListener listener;

    // Interface để xử lý click
    public interface OnItemClickListener {
        void onItemClick(Landscape landscape);
    }

    public LandscapeAdapter(Context context, ArrayList<Landscape> list, OnItemClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_landscape, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Landscape land = list.get(position);
        holder.tvName.setText(land.getName());
        holder.tvDescription.setText(land.getDescription());
        holder.imLandscape.setImageResource(land.getImageResId());

        // Click item → trigger listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(land);
            }
        });
    }

    @Override
    public int getItemCount() { return list.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDescription;
        ImageView imLandscape;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imLandscape = itemView.findViewById(R.id.imLandscape);
        }
    }
}
