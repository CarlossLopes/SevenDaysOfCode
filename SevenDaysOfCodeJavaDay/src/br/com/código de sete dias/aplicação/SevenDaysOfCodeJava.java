package br.com.sevendaycode.aplication;

import java.io.PrintWriter;
import java.util.List;

import br.com.sevendaycode.fonte.Content;
import br.com.sevendaycode.fonte.HtmlGenerator;
import br.com.sevendaycode.fonte.ImdbApiClient;
import br.com.sevendaycode.fonte.ImdbMovieJsonParser;
import br.com.sevendaycode.fonte.JsonParser;

public class SevenDaysOfCodeJava {

	public static void main(String[] args) throws Exception {

		System.out.println("Chamando API");
		String apiKey = "<chave key>";
		String json = new ImdbApiClient(apiKey).getBody();

		System.out.println("Parsing do JSON");
		JsonParser jsonParser = new ImdbMovieJsonParser(json);
		List<? extends Content> contentList = jsonParser.parse();

		System.out.println("Gerando HTML");
		PrintWriter writer = new PrintWriter("content.html");
		new HtmlGenerator(writer).generate(contentList);
		writer.close();
	}
}
