package com.alfsuace.patronobserver.domain

import com.alfsuace.patronobserver.commons.Either
import com.alfsuace.patronobserver.commons.ErrorApp

interface EditorRepository {

    suspend fun obtainEditor(id: Int): Either<ErrorApp, Editor>
    suspend fun saveEditor(editor: Editor)
}