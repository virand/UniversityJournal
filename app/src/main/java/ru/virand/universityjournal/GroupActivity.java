package ru.virand.universityjournal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GroupActivity extends AppCompatActivity implements View.OnClickListener{

    /*
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
     */

    LinearLayout llGroupStudents;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        llGroupStudents = (LinearLayout) findViewById(R.id.llGroupStudents);

        dbHelper = new DBHelper(this);

        // Подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();

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
            //int studentId=1;

            do {
                // Получаем значения по номерам столбцов и пишем в лог

                /*
                                            LinearLayout llLesson = new LinearLayout(getContext());
                            llLesson.setLayoutParams(mainLLParams);
                            TextView tvTime = new TextView(getContext());
                            tvTime.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 4f));
                            tvTime.setText(l);
                            TextView tvLessonName = new TextView(getContext());
                            tvLessonName.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
                            tvLessonName.setText("Методология программной инженерии\nКлименков Сергей Викторович\nКронверкский пр., д. 49 лит. А 324");
                            llLesson.addView(tvTime);
                            llLesson.addView(tvLessonName);
                            mainLL.addView(llLesson);
                 */

                TextView tvStudent = new TextView(this);
                tvStudent.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                tvStudent.setText(c.getInt(idColIndex)+" "+ c.getString(fullNameColIndex));
                tvStudent.setId(c.getInt(idColIndex));
                tvStudent.setOnClickListener(this);
                //studentId++;

                llGroupStudents.addView(tvStudent);

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

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        intent = new Intent(this, StudentActivity.class);
        Log.d("View v id: ", String.valueOf(v.getId()));

        TextView tv = (TextView) findViewById(v.getId());
        String tvText = tv.getText().toString();
        Log.d("textVew value: ", tvText);

        String arr[] = tvText.split(" ", 2);
        String tvId = arr[0];
        Log.d("tvId value: ", tvId);
        intent.putExtra("id",tvId);

        startActivity(intent);
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
            db.execSQL("CREATE TABLE IF NOT EXISTS students(id INT(10) PRIMARY KEY, fullName VARCHAR(255), birthday DATE, address VARCHAR(255), tel VARCHAR(255), email VARCHAR(255), olymps VARCHAR(255), sports VARCHAR(255), notes VARCHAR(255));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
