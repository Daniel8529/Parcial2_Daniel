package com.ucne.parcial2_daniel.ui.List


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.parcial2_daniel.data.DTO.Vervoresponsidto
import com.ucne.parcial2_daniel.data.repository.ConsumirApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

data class ListViewModelListUiState(
    val verbo: List<Vervoresponsidto> = emptyList(),
)

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: ConsumirApi
) : ViewModel() {

    private val _uiState = MutableStateFlow( ListViewModelListUiState())
    val uiState: StateFlow<ListViewModelListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                try {
                    it.copy(verbo =repository.geAllapi().sortedBy { it.Verbo } )
                }
                catch (ioe:IOException){
                    it.copy(verbo = emptyList() )
                }

            }
        }
    }


}