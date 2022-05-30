package com.example.notesx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.notesx.databinding.ActivityDatainsertBinding;

public class datainsert extends AppCompatActivity {
    ActivityDatainsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDatainsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String type = getIntent().getStringExtra("type");
        if (type.equals("update"))
        {
            setTitle("update");
            binding.title.setText(getIntent().getStringExtra("title"));
            binding.description.setText(getIntent().getStringExtra("discription"));
            int id = getIntent().getIntExtra("id",0);
            binding.add.setText("Update Note");
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.title.getText().toString());
                    intent.putExtra("discription", binding.description.getText().toString());
                    intent.putExtra("id",id);
                    setResult(RESULT_OK, intent);
                    finish();

                }
            });

        }else {
            setTitle("Add Mode");

            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.title.getText().toString());
                    intent.putExtra("discription", binding.description.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();

                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(datainsert.this,MainActivity.class));
    }
}