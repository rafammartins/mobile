package com.ghostapps.placapp.main.di

import androidx.room.Room
import com.ghostapps.placapp.data.records.local.RecordDatabase
import com.ghostapps.placapp.data.records.RecordEntity
import com.ghostapps.placapp.data.records.local.useCases.DeleteLocalRegister
import com.ghostapps.placapp.data.records.local.useCases.GetAllLocalRegister
import com.ghostapps.placapp.data.records.local.useCases.InsertLocalRegister
import com.ghostapps.placapp.data.records.remote.useCases.DeleteFirestoreRegister
import com.ghostapps.placapp.data.records.remote.useCases.GetAllFirestoreRegister
import com.ghostapps.placapp.data.records.remote.useCases.InsertFirestoreRegister
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object DataModules {
    val modules = module {
        single {
            Room.databaseBuilder(
                androidApplication(),
                RecordDatabase::class.java,
                RecordEntity.TABLE_NAME
            ).fallbackToDestructiveMigration().build()
        }
        factory {
            InsertFirestoreRegister()
        }
        factory {
            DeleteFirestoreRegister()
        }
        factory {
            GetAllFirestoreRegister()
        }
    }
 }