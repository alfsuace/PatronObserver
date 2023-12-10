package com.alfsuace.patronobserver.domain

data class Editor(
    val events: EventManager = EventManager(),
    val id: Int,
    val contenido: String
)

class EventManager(val observers: MutableList<Observer> = mutableListOf()) {
    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyObservers(filename: String) {
        observers.forEach { it.update(filename) }
    }
}

