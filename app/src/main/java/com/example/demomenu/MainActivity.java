package com.example.demomenu;

import static com.example.demomenu.R.*;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = this.findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        Button btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(item -> {
            PopupMenu popupMenu = new PopupMenu(this, item);
            popupMenu.getMenuInflater().inflate(menu.context_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    if(R.id.mnu_xemds == id){
                        Toast.makeText(MainActivity.this, "abcx", Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }
            });
            popupMenu.show();
        });

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        doSomething(item);
        return super.onContextItemSelected(item);
    }

    public void doSomething(MenuItem item){
        int id1 = item.getItemId();
        if(id1 == R.id.item1){
            Toast.makeText(this, "Item 1 button", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Item diffirent button", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id1 = item.getItemId();
        if(R.id.item1 == id1){
            Toast.makeText(this, "Item1", Toast.LENGTH_SHORT).show();
        }else if(id1 == id.item2){
            Toast.makeText(this, "Item2", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}