package net.lepko.minecraft.easycrafting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Version {
	public static final String MOD_NAME = "Easy Crafting";
	public static final String VERSION = "0.9.9";
	private static final String UPDATE_URL = "http://lepko.net/external/easycrafting/update.txt";

	private static String newVersionString = "";
	private static String updateMessageString = "";

	private static boolean updatePrinted = false;

	public static void updateCheck() {
		if (ModEasyCrafting.instance.checkForUpdates) {
			try {
				URL url = new URL(UPDATE_URL);
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

				newVersionString = in.readLine();
				updateMessageString = in.readLine();

				in.close();
			} catch (Exception e) {
				System.out.println("[" + MOD_NAME + "] Checking for updates failed!");
				return;
			}

			if (!newVersionString.trim().isEmpty() && !VERSION.equalsIgnoreCase(newVersionString)) {
				System.out.println("[" + MOD_NAME + "] Update available! You have: " + VERSION + " Latest: " + newVersionString);
				System.out.println("[" + MOD_NAME + "] " + updateMessageString);
			}
		}
	}

	public static void updatePrint() {
		if (!updatePrinted && !newVersionString.trim().isEmpty() && !VERSION.equalsIgnoreCase(newVersionString)) {
			ProxyCommon.proxy.printMessageToChat("\u00A7" + "6[" + MOD_NAME + "] " + "\u00A7" + "aUpdate available! " + "\u00A7" + "7You have: " + "\u00A7" + "c" + VERSION + " " + "\u00A7" + "7Latest: " + "\u00A7" + "2" + newVersionString);
			ProxyCommon.proxy.printMessageToChat("\u00A7" + "6[" + MOD_NAME + "] " + "\u00A7" + "f" + updateMessageString);
		}
		updatePrinted = true;
	}
}
