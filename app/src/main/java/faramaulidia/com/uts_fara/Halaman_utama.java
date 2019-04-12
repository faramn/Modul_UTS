package faramaulidia.com.uts_fara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Halaman_utama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
    }

    public void openMenu(View view) {
        Intent intent = new Intent(Halaman_utama.this, Note.class);
        startActivity(intent);
    }

    public void openAbout(View view) {
        Intent intent = new Intent(Halaman_utama.this, About.class);
        startActivity(intent);
    }
}
