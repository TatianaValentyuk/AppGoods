package com.valentyuk.appgoods

import android.provider.ContactsContract.CommonDataKinds.Email

//если у нас один нужен конструктор то при создании класса ставим ()  указываем переменные, это и будет по сути конструктор
class User (val login: String, val email: String, val pass: String){

}