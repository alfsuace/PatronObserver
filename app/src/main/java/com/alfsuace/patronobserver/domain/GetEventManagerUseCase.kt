package com.alfsuace.patronobserver.domain

import com.alfsuace.patronobserver.commons.Either
import com.alfsuace.patronobserver.commons.ErrorApp

class GetEventManagerUseCase(private val eventManagerRepository: EventManagerRepository) {
    suspend operator fun invoke(): Either<ErrorApp, List<EventManager>> {
        return eventManagerRepository.obtainEventManagers()
    }
}