package com.ejerciciosmesa.catalogo.appdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class AppDataImpl implements AppData {

	private String name;
	private String author;
	private int year;
	private String web;
	private String webURL;
	private TreeMap<String, GeneralOption> generalOptions;
	private ArrayList<GeneralOption> sortedGeneralOptions;

	public AppDataImpl() {
		name = "Catálogo Automotriz";
		author = "Cristian Chala";
		year = 2025;
		web = "";
		webURL = "";

		generalOptions = new TreeMap<>();
		sortedGeneralOptions = new ArrayList<>();
		int order = 0;

		GeneralOption opProductos = new GeneralOption(order, "PRODUCTOS", "", "/productos/list", "LIST");

		opProductos.addScreen("LIST", "Listado Automotriz");
		opProductos.addScreen("CREATE", "Agregar Nuevos Modelos");
		opProductos.addScreen("UPDATE", "Modificación ");
		opProductos.addScreen("VIEW", "Ficha Técnica");
		opProductos.addScreen("VIEWIMG", "Producto - View Image");

		opProductos.setEmptyMessage("No hay Vehiculos");

		generalOptions.put("PRODUCTOS", opProductos);
		sortedGeneralOptions.add(opProductos);

		order++;

		Collections.sort(sortedGeneralOptions);

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public int getYear() {
		return year;
	}

	@Override
	public String getWeb() {
		return web;
	}

	@Override
	public String getWebUrl() {
		return webURL;
	}

	@Override
	public String getAuthorship() {
		String authorship = "";
		if (!author.isBlank() || !web.isBlank()) {
			authorship += author + " " + year;
			if (!web.isBlank())
				authorship += " - " + web;
		}
		return authorship.trim();
	}

	@Override
	public TreeMap<String, GeneralOption> getGeneralOptions() {
		return generalOptions;
	}

	@Override
	public ArrayList<GeneralOption> getSortedGeneralOptions() {
		return sortedGeneralOptions;
	}

	@Override
	public boolean isMainScreen(String optionCode, String screenCode) {
		return generalOptions.get(optionCode).getMainScreenCode().equals(screenCode);
	}

	@Override
	public String getMainScreenName(String optionCode) {
		return generalOptions.get(optionCode).getMainScreenName();
	}

	@Override
	public String getMainScreenLink(String optionCode) {
		return generalOptions.get(optionCode).getLink();
	}

	@Override
	public String getScreenName(String optionCode, String screenCode) {
		return generalOptions.get(optionCode).getScreen(screenCode);
	}

	@Override
	public String getEmptyMessage(String optionCode) {
		return generalOptions.get(optionCode).getEmptyMessage();
	}

}
