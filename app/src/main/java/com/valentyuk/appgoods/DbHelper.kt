package com.valentyuk.appgoods

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//опишем подключение к БД и создание
class DbHelper (val context: Context, val factory: SQLiteDatabase.CursorFactory?) ://принимаем два параметра и передаем в класс родитель
    SQLiteOpenHelper (context, "app", factory, 1){
    //app - название БД, и версия любая (пока 1)

    // в классе SQLiteOpenHelper есть 2 метода, которые являются абстрактными и должны быть реализованы в классе наследнике

    //создаем таблицу
    override fun onCreate(db: SQLiteDatabase?) {// ? означает что может быть null
       val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)"
        db!!.execSQL(query)//для корректной обработки возможного sql команды и null, нужно ставить!!
    }
//обновление БД
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")//удаляем, если есть таблица users
        onCreate(db)//и создаем
    }

    fun addUser(user: User){
        val values = ContentValues()// мы подставим значение, которое будет подставлено в SQL команду и введет пользователь
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", user.pass)
        val db = this.writableDatabase//обращаемся к текущей БД для записи
        db.insert("users", null, values)

        db.close()

    }
fun getUser(login: String, pass: String ): Boolean{//передаем данные пользователя в функцию
    val db = this.readableDatabase
    val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND pass ='$pass' ", null)//получаем все поля с условием login = login (который мы передали) и второй параметр null, мы данные не получаем динамически
    return result.moveToFirst()//возвращает лито истина либо Ложь в зависимости от того, найдена или нет запись

}

    }