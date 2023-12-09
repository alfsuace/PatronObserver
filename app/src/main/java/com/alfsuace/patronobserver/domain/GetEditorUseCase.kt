package com.alfsuace.patronobserver.domain

import com.alfsuace.patronobserver.commons.Either
import com.alfsuace.patronobserver.commons.ErrorApp

class GetEditorUseCase(
    private val editorRepository: EditorRepository
) {
    suspend operator fun invoke(id: Int): Either<ErrorApp, Editor> {
        return editorRepository.obtainEditor(id)
    }
}