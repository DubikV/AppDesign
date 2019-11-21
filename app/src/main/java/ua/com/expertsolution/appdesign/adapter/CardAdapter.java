package ua.com.expertsolution.appdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ua.com.expertsolution.appdesign.R;

public class CardAdapter extends RecyclerView.Adapter {

    private List<Integer> list;
    private LayoutInflater layoutInflater;
    private Context context;
    private static ClickListener clickListener;

    public CardAdapter(Context context, List<Integer> list, ClickListener clickListener) {
        this.context = context;
        this.list = list;
        this.clickListener = clickListener;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.circularProgressbar)
        ProgressBar circularProgressbar;

        public CardViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CardViewHolder(layoutInflater.inflate(R.layout.list_card_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Integer getItem(int position) {
        return (int) list.get(position);
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }


}

