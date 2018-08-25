package br.com.livroandroid.carros.domain

import android.content.Context
import br.com.livroandroid.carros.extensions.fromJson
import br.com.livroandroid.carros.utils.HttpHelper

object CarroService {
    private const val BASE_URL = "http://livrowebservices.com.br/rest/carros/tipo"

    // Busca os carros por tipo (clássicos, esportivos ou luxo)
    fun getCarros(tipo: TipoCarro): List<Carro> {
        val url = "$BASE_URL/tipo/${tipo.name}"
        val json = HttpHelper.get(url)
        return fromJson<List<Carro>>(json)

    }
}