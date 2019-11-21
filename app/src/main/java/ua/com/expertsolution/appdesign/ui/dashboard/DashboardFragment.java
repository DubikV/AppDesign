package ua.com.expertsolution.appdesign.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import butterknife.BindView;
import butterknife.ButterKnife;
import ua.com.expertsolution.appdesign.R;
import ua.com.expertsolution.appdesign.adapter.CardAdapter;
import ua.com.expertsolution.appdesign.adapter.DaysAdapter;

public class DashboardFragment extends Fragment {

    @BindView(R.id.card_list)
    RecyclerView cardList;

    @BindView(R.id.money_list)
    RecyclerView moneyList;
    private DashBoardViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this,root);
        homeViewModel =
                ViewModelProviders.of(this).get(DashBoardViewModel.class);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        List<Integer> cards = new ArrayList<>();
        for(int i = 0; i<=10; i++){
            cards.add(i);
        }

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(cardList);
        cardList.setAdapter(new CardAdapter(getContext(), cards, new CardAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

            }
        }));

        List<Integer> days = new ArrayList<>();
        for(int i = 0; i<=30; i++){
            days.add(i);
        }
        moneyList.setAdapter(new DaysAdapter(getContext(), days, new DaysAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

            }
        }));

        return root;
    }

}