package br.com.livroandroid.carros.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import br.com.livroandroid.carros.R
import br.com.livroandroid.carros.adapter.CarroAdapter
import br.com.livroandroid.carros.domain.Carro
import br.com.livroandroid.carros.domain.CarroService
import br.com.livroandroid.carros.domain.TipoCarro
import br.com.livroandroid.carros.extensions.setupToolbar
import br.com.livroandroid.carros.extensions.toast
import kotlinx.android.synthetic.main.activity_carros.*

class CarrosActivity : BaseActivity() {
    private var tipo: TipoCarro = TipoCarro.Classicos
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)

        this.tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val s = context.getString(tipo.string)

        setupToolbar(R.id.toolbar, s, upNavigation = true)
    }

    override fun onResume() {
        super.onResume()

        val carros = CarroService.getCarros(this,tipo)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CarroAdapter(carros) { c -> onClickCarro(c)}
    }

    private fun onClickCarro(c: Carro) {
        toast(c.nome)
    }
}