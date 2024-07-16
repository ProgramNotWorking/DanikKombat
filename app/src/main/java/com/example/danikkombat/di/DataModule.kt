package com.example.danikkombat.di

import com.example.data.database.ItemDao
import com.example.data.database.ItemDatabase
import com.example.data.database.UserStorage
import com.example.data.database.mapper.ItemMapper
import com.example.data.database.mapper.UserStorageImplementation
import com.example.data.repository_implementation.UserRepositoryImplementation
import com.example.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<ItemDatabase> {
        ItemDatabase.getDatabase(context = get())
    }

    single<ItemDao> {
        val database = get<ItemDatabase>()
        database.getItemDao()
    }

    single<UserStorage> {
        UserStorageImplementation(
            mapper = get(),
            dao = get(),
            context = get()
        )
    }

    single<ItemMapper> {
        ItemMapper()
    }

    single<UserRepository> {
        UserRepositoryImplementation(
            storage = get()
        )
    }

}