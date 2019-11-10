package com.mynuex.hydrationapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// This created the actual database on the device
@Database(entities = {WaterRecord.class}, version = 1, exportSchema = false)
public abstract class WaterDatabase extends RoomDatabase {

    private static volatile WaterDatabase INSTANCE;

    public abstract WaterDAO waterDAO();  // Abstract method

    static WaterDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WaterDatabase.class) {   // Only one thread can run this code at once
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WaterDatabase.class, "Water").build();
                }
            }
        }
        return INSTANCE;
    }
}
