package com.example.leal.trainingapp.Uteis;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.leal.trainingapp.model.Book;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // nome do database para sua aplicacao
    private static final String DATABASE_NAME = "mybanco.sqlite";

    // sempre que voce mudar objetos em seu database incremente a versao
    private static final int DATABASE_VERSION = 1;

    // the DAO utilizado para acessar os dados
    private Dao<Book, Integer> bookDao = null;

    /**
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     *
     */
    public void onCreate(SQLiteDatabase database,
                         ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Book.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     */
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        try {
            List<String> allSql = new ArrayList<String>();
            switch (oldVersion) {
                case 1:
// allSql.add("alter table AdData add column `new_col` VARCHAR");
// allSql.add("alter table AdData add column `new_col2` VARCHAR");
            }
            for (String sql : allSql) {
                db.execSQL(sql);
            }
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade",
                    e);
            throw new RuntimeException(e);
        }

    }

    /**
     *
     * @return
     */
    public Dao<Book, Integer> getBookDao() {
        if (null == bookDao) {
            try {
                bookDao = getDao(Book.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return bookDao;
    }
}