package ru.virand.universityjournal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener{


    Button btnDatabaseAdd;
    Button btnDatabaseRead;
    Button btnDatabaseClear;

    EditText etDatabaseFullname, etDatabaseBirthday, etDatabaseAddress, etDatabaseTel, etDatabaseEmail,etDatabaseOlymps, etDatabaseSport,etDatabaseNotes;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        btnDatabaseAdd = (Button) findViewById(R.id.btnDatabaseAdd);
        btnDatabaseRead = (Button) findViewById(R.id.btnDatabaseRead);
        btnDatabaseClear = (Button) findViewById(R.id.btnDatabaseClear);
        btnDatabaseAdd.setOnClickListener(this);
        btnDatabaseRead.setOnClickListener(this);
        btnDatabaseClear.setOnClickListener(this);

        etDatabaseFullname = (EditText) findViewById(R.id.etDatabaseFullname);
        etDatabaseBirthday = (EditText) findViewById(R.id.etDatabaseBirthday);
        etDatabaseAddress = (EditText) findViewById(R.id.etDatabaseAddress);
        etDatabaseTel = (EditText) findViewById(R.id.etDatabaseTel);
        etDatabaseEmail = (EditText) findViewById(R.id.etDatabaseEmail);
        etDatabaseOlymps = (EditText) findViewById(R.id.etDatabaseOlymps);
        etDatabaseSport = (EditText) findViewById(R.id.etDatabaseSport);
        etDatabaseNotes = (EditText) findViewById(R.id.etDatabaseNotes);

        // Создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v){
        // Создаем объект для данных
        ContentValues cv = new ContentValues();

        // Получаем данные из полей ввода
        String fullname = etDatabaseFullname.getText().toString();
        String birthday = etDatabaseBirthday.getText().toString();
        String address = etDatabaseAddress.getText().toString();
        String tel = etDatabaseTel.getText().toString();
        String email = etDatabaseEmail.getText().toString();
        String olymps = etDatabaseOlymps.getText().toString();
        String sport = etDatabaseSport.getText().toString();
        String notes = etDatabaseNotes.getText().toString();

        // Подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch(v.getId()){
            case R.id.btnDatabaseAdd:
                // Подготовим данные для вставки в виде пар: наименование столбца - значение
                cv.put("fullName",fullname);
                cv.put("birthday",birthday);
                cv.put("address",address);
                cv.put("tel",tel);
                cv.put("email",email);
                cv.put("olymps",olymps);
                cv.put("sports",sport);
                cv.put("notes",notes);

                // Вставляем запись и получаем ее ID
                long rowID = db.insert("students", null, cv);
                Log.d("SQLITE: ", "row inserted, ID = " + rowID);
                break;
            case R.id.btnDatabaseRead:
                Log.d("SQLITE: ", "ROWS IN TABLE");
                // Делаем запрос всех данных из таблицы students, получаем Cursor
                Cursor c = db.query("students",null,null,null,null, null, null);

                // Ставим позицию курсора на первую строку выборки
                // Если в выборке нет строк, вернется false
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

                    do {
                        // Получаем значения по номерам столбцов и пишем в лог

                        Log.d("SQLITE",
                                "ID = " + c.getInt(idColIndex) +
                                        ", fullName = " + c.getString(fullNameColIndex) +
                                        ", birthday = " + c.getString(birthdayColIndex) +
                                        ", address = " + c.getString(addressColIndex) +
                                        ", olymps = " + c.getString(olympsColIndex) +
                                        ", sports = " + c.getString(sportsColIndex) +
                                        ", notes = " + c.getString(notesColIndex));
                    } while(c.moveToNext());
                }
                else
                {
                    Log.d("SQLITE: ", "0 rows");
                    c.close();
                }
                break;
            case R.id.btnDatabaseClear:
                Log.d("SQLITE", "--- Clear mytable: ---");
                // Удаляем все записи
                int clearCount = db.delete("students", null, null);
                Log.d("SQLITE", "deleted rows count = " + clearCount);
                break;
        }
    }

    class DBHelper extends SQLiteOpenHelper{
        public DBHelper(Context context){
            // Конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            Log.d("SQLITE: ", "onCreate database");
            // Создаем таблицу с полями
            db.execSQL("CREATE TABLE IF NOT EXISTS students(id INT(10) PRIMARY KEY, fullName VARCHAR(255), birthday DATE, address VARCHAR(255), tel VARCHAR(255), email VARCHAR(255), olymps VARCHAR(255), sports VARCHAR(255), notes VARCHAR(255));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
