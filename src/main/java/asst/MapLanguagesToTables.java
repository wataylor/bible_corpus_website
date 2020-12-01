package asst;

import java.util.Map;
import java.util.TreeMap;

/** Generate a map between the corpus language names
 * and the SQL table and column where the verse text resides
 * 
 * <p><b>Note</b>: This file is used in both the 1 project and in the
 * corpus project.  It must be maintained carefully in both places.</p>
 * 
 * @author Material Gain
 * @since 2020 11
 */
public class MapLanguagesToTables {
	/**  Map the name of each translation to the database
	 * table and column where it is to be found. */
	public static Map<String, String> LANG_2_TABLE = new TreeMap<String, String>();
	static {
		LANG_2_TABLE.put("KJV English", "0.KJVEnglish");
		LANG_2_TABLE.put("Achuar-NT", "0.Achuar_NT");
		LANG_2_TABLE.put("Afrikaans", "0.Afrikaans");
		LANG_2_TABLE.put("Aguaruna-NT", "0.Aguaruna_NT");
		LANG_2_TABLE.put("Akawaio-NT", "0.Akawaio_NT");
		LANG_2_TABLE.put("Albanian", "0.Albanian");
		LANG_2_TABLE.put("Amharic", "1.Amharic");
		LANG_2_TABLE.put("Amuzgo-NT", "1.Amuzgo_NT");
		LANG_2_TABLE.put("Arabic", "1.Arabic");
		LANG_2_TABLE.put("Armenian-PART", "1.Armenian_PART");
		LANG_2_TABLE.put("Aukan-NT", "1.Aukan_NT");
		LANG_2_TABLE.put("Barasana-NT", "2.Barasana_NT");
		LANG_2_TABLE.put("Basque-NT", "2.Basque_NT");
		LANG_2_TABLE.put("Bulgarian", "2.Bulgarian");
		LANG_2_TABLE.put("Burmese", "21.Burmese");
		LANG_2_TABLE.put("Cabecar-NT", "2.Cabecar_NT");
		LANG_2_TABLE.put("Cakchiquel-NT", "2.Cakchiquel_NT");
		LANG_2_TABLE.put("Campa-NT", "3.Campa_NT");
		LANG_2_TABLE.put("Camsa-NT", "3.Camsa_NT");
		LANG_2_TABLE.put("Cebuano", "3.Cebuano");
		LANG_2_TABLE.put("Chamorro-PART", "3.Chamorro_PART");
		LANG_2_TABLE.put("Cherokee-NT", "3.Cherokee_NT");
		LANG_2_TABLE.put("Chinantec-NT", "4.Chinantec_NT");
		LANG_2_TABLE.put("Chinese-tok", "4.Chinese_tok");
		LANG_2_TABLE.put("Chinese", "4.Chinese");
		LANG_2_TABLE.put("Coptic-NT", "4.Coptic_NT");
		LANG_2_TABLE.put("Creole", "4.Creole");
		LANG_2_TABLE.put("Croatian", "5.Croatian");
		LANG_2_TABLE.put("Czech", "5.Czech");
		LANG_2_TABLE.put("Danish", "5.Danish");
		LANG_2_TABLE.put("Dinka-NT", "5.Dinka_NT");
		LANG_2_TABLE.put("Dutch", "5.Dutch");
		LANG_2_TABLE.put("English-WEB", "6.English_WEB");
		LANG_2_TABLE.put("English", "6.English");
		LANG_2_TABLE.put("Esperanto", "6.Esperanto");
		LANG_2_TABLE.put("Estonian-PART", "6.Estonian_PART");
		LANG_2_TABLE.put("Ewe-NT", "6.Ewe_NT");
		LANG_2_TABLE.put("Farsi", "7.Farsi");
		LANG_2_TABLE.put("Finnish", "7.Finnish");
		LANG_2_TABLE.put("French", "7.French");
		LANG_2_TABLE.put("Gaelic-PART", "7.Gaelic_PART");
		LANG_2_TABLE.put("Galela-NT", "7.Galela_NT");
		LANG_2_TABLE.put("German", "8.German");
		LANG_2_TABLE.put("Greek", "8.Greek");
		LANG_2_TABLE.put("Gujarati-NT", "8.Gujarati_NT");
		LANG_2_TABLE.put("Hebrew", "8.Hebrew");
		LANG_2_TABLE.put("Hindi", "8.Hindi");
		LANG_2_TABLE.put("Hungarian", "9.Hungarian");
		LANG_2_TABLE.put("Icelandic", "9.Icelandic");
		LANG_2_TABLE.put("Indonesian", "9.Indonesian");
		LANG_2_TABLE.put("Italian", "9.Italian");
		LANG_2_TABLE.put("Jakalteko-NT", "9.Jakalteko_NT");
		LANG_2_TABLE.put("Japanese-tok", "10.Japanese_tok");
		LANG_2_TABLE.put("Japanese", "10.Japanese");
		LANG_2_TABLE.put("K'iche'-NT-SIL", "10.K_iche__NT_SIL");
		LANG_2_TABLE.put("K'iche'-NT", "10.K_iche__NT");
		LANG_2_TABLE.put("Kabyle-NT", "10.Kabyle_NT");
		LANG_2_TABLE.put("Kannada", "11.Kannada");
		LANG_2_TABLE.put("Korean", "11.Korean");
		LANG_2_TABLE.put("Latin", "11.Latin");
		LANG_2_TABLE.put("Latvian-NT", "11.Latvian_NT");
		LANG_2_TABLE.put("Lithuanian", "11.Lithuanian");
		LANG_2_TABLE.put("Lukpa-NT", "12.Lukpa_NT");
		LANG_2_TABLE.put("Malagasy", "12.Malagasy");
		LANG_2_TABLE.put("Malayalam", "12.Malayalam");
		LANG_2_TABLE.put("Mam-NT", "12.Mam_NT");
		LANG_2_TABLE.put("Manx-PART", "12.Manx_PART");
		LANG_2_TABLE.put("Maori", "13.Maori");
		LANG_2_TABLE.put("Marathi", "13.Marathi");
		LANG_2_TABLE.put("Myanmar", "13.Myanmar");
		LANG_2_TABLE.put("Nahuatl-NT", "13.Nahuatl_NT");
		LANG_2_TABLE.put("Nepali", "13.Nepali");
		LANG_2_TABLE.put("Norwegian", "14.Norwegian");
		LANG_2_TABLE.put("Ojibwa-NT", "14.Ojibwa_NT");
		LANG_2_TABLE.put("Paite", "14.Paite");
		LANG_2_TABLE.put("Polish", "14.Polish");
		LANG_2_TABLE.put("Portuguese", "14.Portuguese");
		LANG_2_TABLE.put("Potawatomi-PART", "15.Potawatomi_PART");
		LANG_2_TABLE.put("Q'eqchi'", "15.Q_eqchi_");
		LANG_2_TABLE.put("Quichua-NT", "15.Quichua_NT");
		LANG_2_TABLE.put("Romani-NT", "15.Romani_NT");
		LANG_2_TABLE.put("Romanian", "15.Romanian");
		LANG_2_TABLE.put("Russian", "16.Russian");
		LANG_2_TABLE.put("Serbian", "16.Serbian");
		LANG_2_TABLE.put("Shona", "16.Shona");
		LANG_2_TABLE.put("Shuar-NT", "16.Shuar_NT");
		LANG_2_TABLE.put("Slovak", "16.Slovak");
		LANG_2_TABLE.put("Slovene", "17.Slovene");
		LANG_2_TABLE.put("Somali", "17.Somali");
		LANG_2_TABLE.put("Spanish", "17.Spanish");
		LANG_2_TABLE.put("Swahili-NT", "17.Swahili_NT");
		LANG_2_TABLE.put("Swedish", "17.Swedish");
		LANG_2_TABLE.put("Syriac-NT", "18.Syriac_NT");
		LANG_2_TABLE.put("Tachelhit-NT", "18.Tachelhit_NT");
		LANG_2_TABLE.put("Tagalog", "18.Tagalog");
		LANG_2_TABLE.put("Telugu", "18.Telugu");
		LANG_2_TABLE.put("Thai-tok", "18.Thai_tok");
		LANG_2_TABLE.put("Thai", "19.Thai");
		LANG_2_TABLE.put("Tuareg-PART", "19.Tuareg_PART");
		LANG_2_TABLE.put("Turkish", "19.Turkish");
		LANG_2_TABLE.put("Ukranian-NT", "19.Ukranian_NT");
		LANG_2_TABLE.put("Uma-NT", "19.Uma_NT");
		LANG_2_TABLE.put("Uspanteco-NT", "20.Uspanteco_NT");
		LANG_2_TABLE.put("Vietnamese-tok", "20.Vietnamese_tok");
		LANG_2_TABLE.put("Vietnamese", "20.Vietnamese");
		LANG_2_TABLE.put("Wolaytta-NT", "20.Wolaytta_NT");
		LANG_2_TABLE.put("Wolof-NT", "20.Wolof_NT");
		LANG_2_TABLE.put("Xhosa", "21.Xhosa");
		LANG_2_TABLE.put("Zarma", "21.Zarma");
		LANG_2_TABLE.put("Zulu-NT", "21.Zulu_NT");
	}

	/** Generate a series of bootstrap htrefs to refer to
	 * individual Bibles.  A bootstrap row automatically reformats
	 * @return .html for a series of bootstrap tables.
	 */
	public static String getHrefs() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"container\">\n"
				+ "<div class=\"row\">\n"
				+ "<div>\n");

		sb.append(makeHrefOf("KJV English"));
		for (String s : LANG_2_TABLE.keySet()) {
			if (!"KJV English".equals(s)) {
				sb.append(makeHrefOf(s));
			}
		}

		sb.append("</div>\n");
		sb.append("</div></div>\n");
		return sb.toString();	
	}

	private static String makeHrefOf(String str) {
		return "<a href=\"" + str + "\"/>" + str + "</a> ";
	}
}
