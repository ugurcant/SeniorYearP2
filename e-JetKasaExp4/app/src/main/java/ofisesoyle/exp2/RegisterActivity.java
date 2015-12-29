package ofisesoyle.exp2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import ofisesoyle_moduls.Config;

public class RegisterActivity extends AppCompatActivity{

    private EditText editTextFirstName, editTextLastName, editTextUsername, editTextPassword, editTextEmail;
    private Button buttonRegister, buttonBacktoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextFirstName = (EditText) findViewById(R.id.editTextRegisterFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextRegisterLastName);
        editTextUsername = (EditText) findViewById(R.id.editTextRegisterUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextRegisterPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextRegisterEmail);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                registerUser();
            }
        });
        buttonBacktoLogin = (Button) findViewById(R.id.button_backto_login);
        buttonBacktoLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerUser() {
        String fName = editTextFirstName.getText().toString().trim();
        String lName = editTextLastName.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim().toLowerCase();
        String password = editTextPassword.getText().toString().trim().toLowerCase();
        String email = editTextEmail.getText().toString().trim().toLowerCase();

        if (fName.equals("") || lName.equals("") || username.equals("") || password.equals("") || email.equals("")) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Eksik Bilgi Girdiniz");
            builder1.setCancelable(true);
            builder1.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        } else {
            register(fName, lName, username, email, password);
        }
    }
    private void register(final String fname, final String lname, final String username,final String email, final String password) {

        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
             protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this, "Lütfen Bekleyin",null, true, true);
            }
            @Override
            protected String doInBackground(String... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(Config.KEY_USERFNAME,fname);
                hashMap.put(Config.KEY_USERLNAME,lname);
                hashMap.put(Config.KEY_USERNAME,username);
                hashMap.put(Config.KEY_USEREMAIL,email);
                hashMap.put(Config.KEY_PASSWORD,password);
                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(Config.URL_REGISTER,hashMap);
                return s;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                try{
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
                    JSONObject c = result.getJSONObject(0);
                    String request_result = c.getString(Config.TAG_REQUEST);

                    if (request_result.equals(Config.LOGIN_SUCCESS)) {
                        Toast.makeText(RegisterActivity.this, "Kayıt Tamamlandı", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(RegisterActivity.this, "Kullanıcı Adı Kullanılıyor", Toast.LENGTH_LONG).show();
                    }
                }catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        RegisterUser ru = new RegisterUser();
        ru.execute();
    }
}