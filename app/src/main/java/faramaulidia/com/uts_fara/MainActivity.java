package faramaulidia.com.uts_fara;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import faramaulidia.com.uts_fara.Model.Database;

public class MainActivity extends AppCompatActivity {

    public List<User> user;
    public EditText text_username,text_password;
    public Button button_login;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new ArrayList<>();
        user.add(new User("Fara", "maulidia"));

        text_username = (EditText) findViewById(R.id.text_username);
        text_password = (EditText) findViewById(R.id.text_password);
        button_login = (Button) findViewById(R.id.button_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User pengguna = null;
                for(User u:user){
                    if(u.getUsername().equals(text_username.getText().toString()) && u.getPassword().equals(text_password.getText().toString())){
                        pengguna = u;
                    }
                }

                if(pengguna != null){
                    SharedPreferences spPengguna = MainActivity.this.getSharedPreferences("Userlogin", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = spPengguna.edit();
                    edit.putString("sedangLogin",pengguna.getUsername());
                    edit.apply();

                    Intent intent = new Intent(MainActivity.this, Halaman_utama.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Username or Password is not valid", Toast.LENGTH_LONG).show();
                }
            }
        });

        db = new Database(this);
    }
}
