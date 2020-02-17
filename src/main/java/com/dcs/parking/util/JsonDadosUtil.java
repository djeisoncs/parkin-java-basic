/**
 * 
 */
package com.dcs.parking.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Classe responsável por fazer manipulações de leitura e escrita de objeto json
 * 
 * @author Djeison 12 de fev de 2020
 */
public class JsonDadosUtil {

	/**
	 * Método responsável por ler um objeto de arquivo json
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param caminho
	 * @param nome
	 * @return JsonObject
	 * @throws FileNotFoundException
	 */
	public static JsonObject lerArquivoJson(String caminho, String nome) throws FileNotFoundException {
		JsonObject jsonObject = new JsonObject();
		Gson gson = new Gson();
		jsonObject = gson.fromJson(new FileReader(caminho + nome), JsonObject.class);
		return jsonObject;
	}

	/**
	 * Método responsável por gravar um objeto de arquivo json
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param jsonObject
	 * @param caminho
	 * @param nome
	 * @return JsonObject
	 * @throws IOException
	 */
	public static boolean gravarArquivoJson(String jsonObject, String caminho, String nome) throws IOException {
		FileWriter fileWriter = new FileWriter(caminho + nome);
		fileWriter.write(jsonObject);
		fileWriter.close();
		return true;
	}
}
