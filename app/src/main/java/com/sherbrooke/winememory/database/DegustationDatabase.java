package com.sherbrooke.winememory.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sherbrooke.winememory.dao.DegustationDao;
import com.sherbrooke.winememory.model.Degustation;

@Database(entities = {Degustation.class}, version = 1)
public abstract class DegustationDatabase extends RoomDatabase {
    public abstract DegustationDao degustationDao();
}
