package com.alfsuace.patronobserver.domain

import com.alfsuace.patronobserver.commons.Either
import com.alfsuace.patronobserver.commons.ErrorApp

interface EventManagerRepository {
    suspend fun obtainEventManagers(): Either<ErrorApp, List<EventManager>>
    suspend fun saveEventManager(eventManager: EventManager)
}