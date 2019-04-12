package faramaulidia.com.uts_fara;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import faramaulidia.com.uts_fara.Model.Database;

public class Tambah_menu extends AppCompatActivity {
    EditText txt_nama,txt_bahan,txt_harga;
    Button Save;
    Database db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_menu);

        db = new Database(this);

        txt_nama = (EditText) findViewById(R.id.text_nama_menu);
        txt_bahan = (EditText) findViewById(R.id.text_bahan_menu);
        txt_harga = (EditText) findViewById(R.id.text_harga_menu);
        Save = (Button) findViewById(R.id.button_tambah);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbnya = db.getWritableDatabase();
                dbnya.execSQL("insert into menu(nama, bahan, harga) values('" + txt_nama.getText().toString() + "','" + txt_bahan.getText().toString() + "','" + txt_harga.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Menu Berhasil Ditambahkan", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Tambah_menu.this, Note.class);
                startActivity(intent);
                finish();
            }
        });
    }





}
