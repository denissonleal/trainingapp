package com.example.leal.trainingapp.Uteis;

import android.content.Context;
import android.database.SQLException;

import com.example.leal.trainingapp.model.Book;

import java.util.List;

public class DatabaseManager {

    private static DatabaseManager instance;
    private DatabaseHelper helper;

    public static void init(Context ctx) {
        if (null == instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    /**
     *
     * @return
     */
    public List<Book> findAllBook() {
        List<Book> list = null;
        try {
            list = getHelper().getBookDao().queryBuilder().orderBy("id", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}