package faramaulidia.com.uts_fara;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import faramaulidia.com.uts_fara.Model.Database;

public class Note extends AppCompatActivity {
    RecyclerView recyclerView;
    Menuadapter adapter;
    ArrayList<Menu> menu;
    Database db;
    Cursor cursor;
    TextView tvNote;
    ImageButton delete;
    Button btnTambah;
    RecyclerView.LayoutManager layoutManager;
    private static final String LOG_TAG = MainActivity.class.getSimpleName ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        db = new Database(this);

        recyclerView = (RecyclerView) findViewById(R.id.rvNote);
        tvNote = (TextView) findViewById(R.id.tvNote);
        btnTambah = (Button) findViewById(R.id.btn_tambah);
        delete = (ImageButton) findViewById(R.id.btn_delete);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Note.this, Tambah_menu.class);
                startActivity(intent);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbsql = db.getReadableDatabase();
                String sql = "delete from menu";
                dbsql.execSQL(sql);
                addDataDummy();
            }
        });

        addDataDummy();
    }

    private void addDataDummy() {
        menu = new ArrayList<>();
        SQLiteDatabase dbsql = db.getReadableDatabase();
        cursor = dbsql.rawQuery("SELECT * FROM menu",null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            do {

                menu.add(new Menu(cursor.getString(cursor.getColumnIndex("nama")),cursor.getString(cursor.getColumnIndex("bahan")),cursor.getString(cursor.getColumnIndex("harga"))));

            } while (cursor.moveToNext());
        }

        adapter = new Menuadapter(menu);

        layoutManager = new LinearLayoutManager(Note.this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(layoutManager);

        if(menu.size() > 0){
            this.tvNote.setText("Jumlah Menu Makanan : " + menu.size());
        }else{
            adapter.notifyDataSetChanged();
            this.tvNote.setText("Tidak ada Menu untuk ditampilkan. : ");
        }
    }

    public void clickLogout ( View view ) {
        Log.d(LOG_TAG, "Logout");
        startActivity(new Intent(this,MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}
