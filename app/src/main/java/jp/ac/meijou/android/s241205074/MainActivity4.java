package jp.ac.meijou.android.s241205074;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s241205074.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s241205074.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {
    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main4);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //MainActivity2から送られたデータを取得
        var editText = getIntent().getStringExtra("title");
        binding.textView5.setText(editText);

        //OKbutton
        binding.button22.setOnClickListener(v->{
            var intent = new Intent();
            intent.putExtra("ret","OK");
            setResult(RESULT_OK, intent);
            finish();

        });

        //Cancelledbutton
        binding.button23.setOnClickListener(v->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}