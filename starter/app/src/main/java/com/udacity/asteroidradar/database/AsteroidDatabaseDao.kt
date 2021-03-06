package com.udacity.asteroidradar.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AsteroidDatabaseDao {

    @Insert
    fun insert(asteroid: Asteroid)

    @Update
    fun update(asteroid: Asteroid)

    @Query("SELECT * FROM asteroid_table WHERE asteroidId = :key")
    fun get(key: Long): Asteroid

    @Query("DELETE FROM asteroid_table")
    fun clear()

    @Query("SELECT * FROM asteroid_table ORDER BY asteroidId DESC")
    fun getAllAsteroid(): LiveData<List<Asteroid>>

    @Query("SELECT * FROM asteroid_table ORDER BY asteroidId DESC LIMIT 1")
    fun getRecentAsteroid(): Asteroid?
}