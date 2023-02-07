package com.sherbrooke.winememory.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.sherbrooke.winememory.model.Degustation;

import java.util.List;

@Dao
public interface DegustationDao {

    @Query("SELECT * FROM degustation")
    List<Degustation> getAll();

    @Query("SELECT * FROM degustation WHERE nom = :name")
    List<Degustation> getByName(String name);

    @Query("SELECT * FROM degustation WHERE _id = :id")
    List<Degustation> getById(int id);

    @Insert
    void insert(Degustation degustation);

    @Update
    void update(Degustation degustation);

    @Delete
    void delete(Degustation degustation);

}
