package com.udacity.asteroidradar.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "asteroid_table")
data class Asteroid(
    @PrimaryKey(autoGenerate = true)
    var asteroidId: Long = 0L,

    @ColumnInfo(name = "codename")
    val codename: String = "",

    @ColumnInfo(name = "closeApproachDate")
    var closeApproachDate: String = "",

    @ColumnInfo(name = "absoluteMagnitude")
    var absoluteMagnitude: Double = 0.0,

    @ColumnInfo(name = "estimatedDiameter")
    var estimatedDiameter: Double = 0.0,

    @ColumnInfo(name = "relativeVelocity")
    var relativeVelocity: Double = 0.0,

    @ColumnInfo(name = "distanceFromEarth")
    var distanceFromEarth: Double = 0.0,

    @ColumnInfo(name = "isPotentiallyHazardous")
    var isPotentiallyHazardous: Boolean = false
)