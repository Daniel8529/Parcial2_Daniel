package com.ucne.parcial2_daniel.ui.List

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ucne.parcial2_daniel.data.DTO.Vervoresponsidto


@Composable
fun ListScreen(
    viewModel:  ListViewModel  = hiltViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta")}, modifier = Modifier.padding(2.dp), actions = {})

        },
        floatingActionButton = {

        }
    ) {


        val uiState by viewModel.uiState.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {

            EntidadApiList(
                Verbo = uiState.verbo,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }


    }

}



@Composable
fun EntidadApiList(
    Verbo:List<Vervoresponsidto>,
    viewModel: ListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(Verbo) {verbo ->
            EntidadApiRow(verbo, viewModel)
        }
    }
}

@Composable
fun EntidadApiRow(vervoresponsidto: Vervoresponsidto, viewModel: ListViewModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {


        Text(
            text ="Verbo:${vervoresponsidto.Verbo}",
            style = MaterialTheme.typography.h6
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Categoria: ${vervoresponsidto.Categoria}"
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Nivel: ${vervoresponsidto.Nivel}"
            )


        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                model = "${vervoresponsidto.Imagen}",
                contentDescription = null
            )

        }


        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}