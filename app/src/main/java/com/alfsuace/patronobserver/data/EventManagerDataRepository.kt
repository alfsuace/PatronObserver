package com.alfsuace.patronobserver.data

import com.alfsuace.patronobserver.commons.Either
import com.alfsuace.patronobserver.commons.ErrorApp
import com.alfsuace.patronobserver.domain.EventManager
import com.alfsuace.patronobserver.domain.EventManagerRepository

class EventManagerDataRepository(
    private val localSource: EventManagerXmlLocalDataSource,
) : EventManagerRepository {

    override suspend fun obtainEventManagers(): Either<ErrorApp, List<EventManager>> {
        return localSource.getEventManagers()
    }

    override suspend fun saveEventManager(eventManager: EventManager) {
        localSource.saveEventManager(eventManager)
    }

}