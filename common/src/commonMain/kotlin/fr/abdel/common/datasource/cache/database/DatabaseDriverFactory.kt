package fr.abdel.common.datasource.cache.database

import com.squareup.sqldelight.db.SqlDriver
import org.koin.core.component.KoinComponent
import org.koin.core.module.Module

expect class DatabaseDriverFactory(): KoinComponent { fun createDriver(): SqlDriver }