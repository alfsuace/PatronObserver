package com.alfsuace.patronobserver.domain

class SaveEditorUseCase(
    private val editorRepository: EditorRepository
) {
    suspend operator fun invoke(editor: Editor) =
        editorRepository.saveEditor(editor)
}