package ua.com.expertsolution.appdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ua.com.expertsolution.appdesign.R;

public class DaysAdapter extends RecyclerView.Adapter {

    private List<Integer> list;
    private LayoutInflater layoutInflater;
    private Context context;
    private static ClickListener clickListener;

    public DaysAdapter(Context context, List<Integer> list, ClickListener clickListener) {
        this.context = context;
        this.list = list;
        this.clickListener = clickListener;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.dot_up)
        View dotUp;
        @BindView(R.id.dot_down)
        View dotDown;

        @BindView(R.id.day)
        TextView day;

        @BindView(R.id.total)
        TextView total;

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
        return new CardViewHolder(layoutInflater.inflate(R.layout.list_money_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(list.size()>1) {
            if (i == 0) {
                ((CardViewHolder)viewHolder).dotUp.setVisibility(View.GONE);
            }else if(i == list.size()-1) {
                ((CardViewHolder) viewHolder).dotDown.setVisibility(View.GONE);
            }
        }
        ((CardViewHolder)viewHolder).day.setText("January "+(1+i));
        ((CardViewHolder)viewHolder).total.setText("$ "+ ThreadLocalRandom.current().nextDouble(1, 20));
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

