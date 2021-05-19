package fr.abdel.common.datasource.cache.database

internal class Database(databaseDriverFactory: DatabaseDriverFactory): AppDatabase {


    private val driver = databaseDriverFactory.createDriver()

}