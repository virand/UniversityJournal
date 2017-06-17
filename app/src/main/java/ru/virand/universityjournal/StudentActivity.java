package ru.virand.universityjournal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class StudentActivity extends AppCompatActivity {
    TextView tvStudentFullName;
    EditText etStudentBirthday;
    EditText etStudentAddress;
    EditText etStudentTel;
    EditText etStudentEmail;
    EditText etStudentOlymps;
    EditText etStudentSports;
    EditText etStudentNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
       // Toast.makeText(this,id,Toast.LENGTH_SHORT).show();

        tvStudentFullName = (TextView) findViewById(R.id.tvStudentFullName);
        etStudentAddress = (EditText) findViewById(R.id.etStudentAddress);
        etStudentBirthday = (EditText) findViewById(R.id.etStudentBirthday);
        etStudentTel = (EditText) findViewById(R.id.etStudentTel);
        etStudentEmail = (EditText) findViewById(R.id.etStudentEmail);
        etStudentOlymps = (EditText) findViewById(R.id.etStudentOlymps);
        etStudentSports = (EditText) findViewById(R.id.etStudentSports);
        etStudentNotes = (EditText) findViewById(R.id.etDatabaseNotes);


        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //Cursor c = db.rawQuery("SELECT * FROM students", null);
        String selection = "id="+id;
        Cursor c = db.query("students",null,selection,null,null,null,null);

        if(c.moveToFirst()){
            // Определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int fullNameColIndex = c.getColumnIndex("fullName");
            int birthdayColIndex = c.getColumnIndex("birthday");
            int addressColIndex = c.getColumnIndex("address");
            int telColIndex = c.getColumnIndex("tel");
            int olympsColIndex = c.getColumnIndex("olymps");
            int sportsColIndex = c.getColumnIndex("sports");
            int notesColIndex = c.getColumnIndex("notes");
            int emailColIndex = c.getColumnIndex("email");

            do {
                // Получаем значения по номерам столбцов и пишем в лог

                Log.d("SQLITE",
                        "ID = " + c.getInt(idColIndex) +
                                ", fullName = " + c.getString(fullNameColIndex) +
                                ", birthday = " + c.getString(birthdayColIndex) +
                                ", address = " + c.getString(addressColIndex) +
                                ", tel = " + c.getString(telColIndex) +
                                ", olymps = " + c.getString(olympsColIndex) +
                                ", sports = " + c.getString(sportsColIndex) +
                                ", notes = " + c.getString(notesColIndex));



                tvStudentFullName.setText(c.getString(fullNameColIndex));
                etStudentAddress.setText(c.getString(addressColIndex));
                etStudentBirthday.setText(c.getString(birthdayColIndex));
                etStudentTel.setText(c.getString(telColIndex));
                etStudentEmail.setText(c.getString(telColIndex));
                etStudentOlymps.setText(c.getString(emailColIndex));
                etStudentSports.setText(c.getString(sportsColIndex));
                //etStudentNotes.setText(c.getString(notesColIndex));

            } while(c.moveToNext());



        }
        else
        {
            Log.d("SQLITE: ", "0 rows");
            c.close();
        }
    }

    class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context){
            // Конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            Log.d("SQLITE: ", "onCreate database");
            // Создаем таблицу с полями
            db.execSQL("CREATE TABLE students(id integer primary key autoincrement, fullName VARCHAR(255), birthday DATE, address VARCHAR(255), tel VARCHAR(255), email VARCHAR(255), olymps VARCHAR(255), sports VARCHAR(255), notes VARCHAR(255));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
