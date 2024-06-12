package com.example.tabs;

import android.os.Bundle;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ImageButton img;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    SectionsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        tabLayout= findViewById(R.id.tabs);
        viewPager2 = findViewById(R.id.viewPager);

        FragmentManager fm = getSupportFragmentManager();

        adapter = new SectionsPagerAdapter(fm,getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Inicio"));
        tabLayout.addTab(tabLayout.newTab().setText("Registro"));
        tabLayout.addTab(tabLayout.newTab().setText("Contacto"));
        tabLayout.addTab(tabLayout.newTab().setText("Canciones"));

        img = findViewById(R.id.menuButton);

        img.setImageResource(R.drawable.ic_menu);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                String tabName = Objects.requireNonNull(tab.getText()).toString();
                Toast.makeText(MainActivity.this, "Has pasado al tab " + tabName, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback()
        {
            @Override
            public void onPageSelected(int position)
            {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    public void showPopUp(View view) {

        PopupMenu popup = new PopupMenu(this , view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.config) {

            showAlertDialog("Configuración");
            return true;

        } else if (id == R.id.guia) {

            showAlertDialog("Guia");
            return true;

        } else if (id == R.id.acerca_de) {

            showAlertDialog("Acerca de");
            return true;
        }

        return false;
    }

    private void showAlertDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage("Se ha ingresado a " + title)
                .setPositiveButton("OK", null)
                .show();
    }
}