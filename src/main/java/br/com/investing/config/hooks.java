package br.com.investing.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

public class hooks {

	@Before
	public void ConfiguracaoInicial() {

		System.out.println("*** Iniciando a extração *** \n");

	}

	@Test
	public void Jsoup() {

		try {

			File arquivo = new File("C:\\temp\\resultado_da_extracao.txt");

			FileWriter fw = new FileWriter(arquivo.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			URL html = new URL("https://br.investing.com/indices/major-indices");

			Document doc = org.jsoup.Jsoup.parse(html, 10000);

			Elements table = doc.select("#cross_rates_container");
			Iterator<Element> Itera_TD = table.select("tr").iterator();

			int Tamanho = Itera_TD.toString().length();

			for (int i = 0; i < Tamanho; i++) {
				System.out.print(Itera_TD.next().text() + "\n");
				Thread.sleep(10);

				bw.write(table.text() + "\n");
				Thread.sleep(10);

			}
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());

			System.out.println(e.getStackTrace());

		}
	}

}
