package com.example.lab9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userName : EditText = findViewById(R.id.editTextName)
        var userYOB :EditText = findViewById(R.id.editTextYOB)
        var userEmail :EditText = findViewById(R.id.editTextEmail)

        var btnSave: Button = findViewById(R.id.btnSave)
        var btnView : Button = findViewById(R.id.btnView)

        var TVShowRecords : TextView = findViewById(R.id.showDBRecords)

        btnSave.setOnClickListener {

            var name = userName.text.toString().trim()
            var yob = userYOB.text.toString().trim()
            var email = userEmail.text.toString().trim()

            val databaseHelper = DatabaseHelper(this)

            if (yob !="" && name !="" && email !="") {

                databaseHelper.addRecord(name, yob, email)

                Toast.makeText(this, "Record added to database successfully", Toast.LENGTH_LONG).show()


                userName.text.clear()
                userYOB.text.clear()
                userEmail.text.clear()
            } else{
                Toast.makeText(this, "Error, you have an empty field!", Toast.LENGTH_LONG).show()
            }
        }

        btnView.setOnClickListener {

            val databaseHelper = DatabaseHelper(this)

            var cursor = databaseHelper.getRecords()

            while (cursor.moveToNext()){
                var name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.NAME_COLUMN))
                var yob = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.YOB_COLUMN))
                var email = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.EMAIL_COLUMN))
                  TVShowRecords.text = "$name \n $yob \n $email \n"
            }

            cursor.close()
        }
    }
}