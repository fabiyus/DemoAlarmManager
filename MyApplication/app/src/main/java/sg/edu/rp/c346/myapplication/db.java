package sg.edu.rp.c346.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 16023068 on 14/11/2017.
 */

public class db extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "test";

    private static final String TABLE_CPU_Details = "CPUDetails";

    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";

    public db(Context contex){super(contex, DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_CPU_DETAIL_TABLE = "CREATE TABLE " + TABLE_CPU_Details + "("
                + KEY_NAME + " TEXT PRIMARY KEY,"
                + KEY_PRICE + " INTEGER " + ")";

        db.execSQL(CREATE_CPU_DETAIL_TABLE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + TABLE_CPU_Details);

        onCreate(db);
    }


}
