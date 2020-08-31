package com.example.tiendavirtual.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.tiendavirtual.R;
import com.example.tiendavirtual.VerProductoFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        Button vermas =  root.findViewById(R.id.vermas);

        //homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
         //   @Override
          //  public void onChanged(@Nullable String s) {
           //     textView.setText(s);
            //}
        //});
        vermas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerProductoFragment verProductoFragment = new VerProductoFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                //verProductoFragment (getIntent().getExtras());
                //getActivity().getSupportFragmentManager().beginTransaction()

                transaction.replace(R.id.nav_host_fragment, verProductoFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                //transaction.replace(R.id.nav_host_fragment, newFragment);

            }
        });
        return root;
    }
}