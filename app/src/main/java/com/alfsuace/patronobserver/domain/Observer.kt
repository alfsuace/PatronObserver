package com.alfsuace.patronobserver.domain

interface Observer {
    fun update(filename: String)
}