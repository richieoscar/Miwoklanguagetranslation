package com.richieoscar.miwok.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.richieoscar.miwok.R;
import com.richieoscar.miwok.adapter.WordPagerAdapter;
import com.richieoscar.miwok.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    TextView numbers, familyMembers, colors, phrases;
   private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportActionBar().setElevation(0);
        setUpViewPager();
    }

    private void setUpViewPager() {
        WordPagerAdapter adapter = new WordPagerAdapter(getSupportFragmentManager());
        binding.viewpager.setAdapter(adapter);
        ViewPager viewPager = binding.viewpager;
        binding.tablayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.item_about:
                startActivity(new Intent(this, AboutActivity.class));
                Toast.makeText(this, R.string.miwok_about, Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}