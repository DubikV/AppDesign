package ua.com.expertsolution.appdesign;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.button_dashboard)
    Button buttonDashboard;
    @BindView(R.id.button_detail)
    Button buttonDetail;
    @BindView(R.id.button_login)
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        ButterKnife.bind(this);
        buttonDashboard.setOnClickListener(this);
        buttonDetail.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_dashboard:
                startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                break;
            case R.id.button_detail:
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
                break;
            case R.id.button_login:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
        }
    }
}
