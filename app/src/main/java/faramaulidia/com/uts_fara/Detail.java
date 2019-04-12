package faramaulidia.com.uts_fara;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import faramaulidia.com.uts_fara.Model.Database;

public class Detail extends AppCompatActivity {
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String Nama = intent.getStringExtra("nama");
        String Bahan = intent.getStringExtra("bahan");
        String Harga = intent.getStringExtra("harga");

        TextView txNama = (TextView) findViewById(R.id.text_nama);
        TextView txBahan= (TextView) findViewById(R.id.text_bahan);
        TextView txHarga = (TextView) findViewById(R.id.text_harga);
        ImageButton btn_delete = (ImageButton) findViewById(R.id.btn_delete);

        txNama.setText("Nama : " + Nama);
        txBahan.setText("Bahan Baku :" +  Bahan);
        txHarga.setText("Harga : " + Harga);


    }
}
