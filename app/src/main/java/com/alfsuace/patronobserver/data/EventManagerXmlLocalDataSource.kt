package com.alfsuace.patronobserver.data

import android.content.Context
import com.alfsuace.patronobserver.commons.Either
import com.alfsuace.patronobserver.commons.ErrorApp
import com.alfsuace.patronobserver.commons.Serializer
import com.alfsuace.patronobserver.commons.left
import com.alfsuace.patronobserver.commons.right
import com.alfsuace.patronobserver.domain.EventManager

class EventManagerXmlLocalDataSource
    (
    private val context: Context,
    private val serializer: Serializer
) {

    private val sharedPref = context.getSharedPreferences("EventManager", Context.MODE_PRIVATE)

    fun saveEventManager(eventManager: EventManager): Either<ErrorApp, Boolean> = try {
        sharedPref.edit().apply {
            putString(
                eventManager.toString(),
                serializer.toJson(eventManager, EventManager::class.java)
            )
        }.apply()
        true.right()
    } catch (ex: Exception) {
        ErrorApp.DataError.left()
    }

    fun getEventManagers(): Either<ErrorApp, List<EventManager>> = try {
        sharedPref.all.map {
            serializer.fromJson(it.value as String, EventManager::class.java)
        }.right()
    } catch (ex: Exception) {
        ErrorApp.DataError.left()
    }
}
