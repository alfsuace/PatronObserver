package com.alfsuace.patronobserver.domain

class SaveEventManagerUseCase(private val eventManagerRepository: EventManagerRepository) {
    suspend operator fun invoke(eventManager: EventManager) {
        eventManagerRepository.saveEventManager(eventManager)
    }
}