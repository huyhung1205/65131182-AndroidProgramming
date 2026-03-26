package hyhung.docbaotonghop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ItemViewHolder> {
    private Context context;
    private ArrayList<Item> dsItem;

    public ListItemAdapter(Context context, ArrayList<Item> dsItem) {
        this.context = context;
        this.dsItem = dsItem;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = dsItem.get(position);
        holder.title.setText(item.getTitle());
        holder.timeUp.setText(item.getTimeUp());

        String imageUrl = item.getUrlAvata();

        // Load ảnh với Glide, nếu lỗi thì dùng ảnh mặc định
        if (imageUrl != null && !imageUrl.isEmpty() && imageUrl.startsWith("http")) {
            Glide.with(context)
                    .load(imageUrl)
                    .centerCrop()
                    .error(R.drawable.avata) // Ảnh mặc định nếu load lỗi
                    .into(holder.imageItem);
        } else {
            // Không có URL hoặc URL không hợp lệ -> dùng ảnh mặc định
            holder.imageItem.setImageResource(R.drawable.avata);
        }

        // Click listener để mở bài báo
        holder.itemView.setOnClickListener(v -> {
            String articleLink = item.getArticleLink();
            if (articleLink != null && !articleLink.isEmpty() && articleLink.startsWith("http")) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(articleLink));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dsItem.size();
    }

    static final class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageItem;
        TextView title, timeUp;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.imageItem);
            title = itemView.findViewById(R.id.title);
            timeUp = itemView.findViewById(R.id.timeUp);
        }
    }
}
