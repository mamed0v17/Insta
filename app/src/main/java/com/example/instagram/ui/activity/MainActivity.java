package com.example.instagram.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.instagram.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private BottomNavigationView bottomNavigationView;
    private TextView textView;
    private ImageView camera;
    private static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNav();
        switchNav();
        cameraIntent();
    }
    private void cameraIntent() {
        camera.setOnClickListener(v ->{
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try{
                startActivityForResult(intent, REQUEST_TAKE_PHOTO);
            }catch (ActivityNotFoundException e){
                e.printStackTrace();
            }
        });
            }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap thumbnailBitmap = (Bitmap) extras.get("data");
                camera.setImageBitmap(thumbnailBitmap);
        }
    }

    private void switchNav() {
        camera = findViewById(R.id.camera_iv);
        textView = findViewById(R.id.tvTextTitle);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onDestinationChanged(@NonNull  NavController controller, @NonNull  NavDestination destination, @Nullable  Bundle arguments) {
                switch (destination.getId()){
                    case R.id.activityFragment:
                        textView.setText("Following");
                        camera.setVisibility(View.GONE);
                    break;
                    case R.id.homeFragment:
                        textView.setText("Instagram");
                        camera.setVisibility(View.VISIBLE);
                    break;
                    case R.id.profileFragment:
                        textView.setText("jacob_w");
                        camera.setVisibility(View.GONE);
                        break;
                }

            }
        });
        }
    private void initNav() {
        bottomNavigationView = findViewById(R.id.bottomNav);
        navController = Navigation.findNavController(this,R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }

}