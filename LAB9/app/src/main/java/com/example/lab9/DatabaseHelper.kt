package com.example.lab9

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context : Context) :
SQLiteOpenHelper(context, DATABASE_NAME, null, DB_VERSION){

    companion object {
        private val DATABASE_NAME = "STRATHMORE"
        private val DB_VERSION = 1
        val TABLE_NAME = "student_table"
        val ID_COLUMN = "id"
        val NAME_COLUMN = "name"
        val YOB_COLUMN = "YearOfBirth"
        val EMAIL_COLUMN = "email"
    }

    override fun onCreate(db: SQLiteDatabase?){
        val query = ("CREATE TABLE $TABLE_NAME ($ID_COLUMN INTEGER PRIMARY KEY, " + "$NAME_COLUMN TEXT, $YOB_COLUMN TEXT, $EMAIL_COLUMN, TEXT)")

        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int){

        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")

        onCreate(db)
    }

    fun addRecord(name: String, yob:String, email:String){

        val values = ContentValues()

        values.put(NAME_COLUMN, name)
        values.put(YOB_COLUMN, yob)
        values.put(EMAIL_COLUMN, email)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()

    }

    fun getRecords() : Cursor {

        val db = this.readableDatabase

        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

}