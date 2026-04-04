package hyhung.th_intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class LoginActivity extends AppCompatActivity {
    String pass = "phanhuyhung", name = "PhanHuyHung", mail="hung.ph.65cntt@ntu.edu.vn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void btnXacNhan(View v){
        String getName = ((EditText)findViewById(R.id.name)).getText().toString();
        String getPass = ((EditText)findViewById(R.id.pass)).getText().toString();
        String getMail = ((EditText)findViewById(R.id.mail)).getText().toString();

        if (getName.equals(name) && getPass.equals(pass) && getMail.equals(mail)){
            Intent myHomeActivity = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(myHomeActivity);
        } else {
            Toast.makeText(this,"Đăng nhập sai thông tin", Toast.LENGTH_SHORT).show();
        }
    }
}