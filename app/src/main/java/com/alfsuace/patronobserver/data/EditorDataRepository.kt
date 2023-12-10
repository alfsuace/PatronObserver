package com.alfsuace.patronobserver.data

import com.alfsuace.patronobserver.commons.Either
import com.alfsuace.patronobserver.commons.ErrorApp
import com.alfsuace.patronobserver.domain.Editor
import com.alfsuace.patronobserver.domain.EditorRepository

class EditorDataRepository(
    private val localSource: EditorXmlLocalDataSource,
) : EditorRepository {

    override suspend fun obtainEditor(id: Int): Either<ErrorApp, Editor> {
        return localSource.getEditor(id)
    }

    override suspend fun saveEditor(editor: Editor) {
        localSource.saveEditor(editor)
    }
}
