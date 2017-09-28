package br.com.ufg.LeilaoEtdd;

import junit.framework.Test;
import junit.framework.Assert;

import br.com.ufg.LeilaoEtdd.dominio.Lance;
import br.com.ufg.LeilaoEtdd.dominio.Leilao;
import br.com.ufg.LeilaoEtdd.dominio.Usuario;
import br.com.ufg.LeilaoEtdd.servico.Avaliador;

public class TesteDoAvaliador {
	
	public void deveEntenderLancesEmOrdemCrescente() {
		//parte 1 - cen�rio
		Usuario joao = new Usuario("Jo�o");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		//parte 2 - a��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//parte 3 - valida��o
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
}
