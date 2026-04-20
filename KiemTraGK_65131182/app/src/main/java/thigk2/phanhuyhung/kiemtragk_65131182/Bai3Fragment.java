package thigk2.phanhuyhung.kiemtragk_65131182;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Bai3Fragment extends Fragment {

    private RecyclerView recyclerViewAttractions;
    private AttractionAdapter attractionAdapter;

    public Bai3Fragment() {
        super(R.layout.fragment_bai3);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Ánh xạ RecyclerView từ XML
        recyclerViewAttractions = view.findViewById(R.id.recyclerview_attractions);

        // Tạo danh sách địa điểm du lịch
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Tháp Nha Trang", "Nha Trang, Khánh Hòa", R.drawable.thap_nha_trang));
        attractions.add(
                new Attraction("Bãi Biển Nha Trang", "Phường Vĩnh Phương, Nha Trang", R.drawable.bai_bien_nha_trang));
        attractions
                .add(new Attraction("Vinpearl Amusement Park", "Đảo Hòn Tre, Nha Trang", R.drawable.winpeal_nha_trang));
        attractions.add(new Attraction("Đảo Mộc Châu", "Vịnh Nha Trang, Khánh Hòa", R.drawable.dao_moc_chau));
        attractions.add(new Attraction("Chùa Lâm Ty Ni", "Thôn Khánh Phong, Nha Trang", R.drawable.chua_lam_ty_ni));
        attractions.add(new Attraction("Suối Tranh", "Khánh Sơn, Khánh Hòa", R.drawable.suoi_tranh));

        // Tạo LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        // Tạo adapter và gán cho RecyclerView
        attractionAdapter = new AttractionAdapter(getContext(), attractions);
        recyclerViewAttractions.setLayoutManager(layoutManager);
        recyclerViewAttractions.setAdapter(attractionAdapter);
    }
}