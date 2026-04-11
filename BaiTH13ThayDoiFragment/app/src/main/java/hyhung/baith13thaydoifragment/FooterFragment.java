package hyhung.baith13thaydoifragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FooterFragment extends Fragment {
    public FooterFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_footer, container, false);

        Button one = view.findViewById(R.id.btnOne);
        Button two = view.findViewById(R.id.btnTwo);
        Button three = view.findViewById(R.id.btnThree);

        FragmentManager fragmentManager = getParentFragmentManager();
        one.setOnClickListener(v -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerViewContent, new OneFragment())
                    .commit();
        });
        two.setOnClickListener(v -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerViewContent, new TwoFragment())
                    .commit();
        });
        three.setOnClickListener(v -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerViewContent, new ThreeFragment())
                    .commit();
        });

        return view;
    }
}