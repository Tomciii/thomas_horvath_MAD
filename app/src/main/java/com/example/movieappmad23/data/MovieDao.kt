package com.example.movieappmad23.data

import androidx.room.*
import com.example.movieappmad23.models.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert
    suspend fun add(movie: Movie)

    @Update
    suspend fun update(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Query("SELECT * from task")
    fun readAll(): Flow<List<Movie>>

    @Query("Select * from task where isDone = 1")
    fun readAllChecked(): Flow<List<Movie>>

    @Query("Select * from task where id=:taskId")
    fun getTaskById(movieId: Int): Movie

    @Query("DELETE from task")
    fun deleteAll()

    fun readFavoriteMovies()
}