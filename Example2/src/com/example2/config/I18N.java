package com.example2.config;


import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18N {

	private static Locale locale;

	private static ResourceBundle messages;

	/**
	 * Private constructor so this class cannot be instantiated only by it self.
	 */
	private I18N() {
	}

	/**
	 * Method to create the ResourceBundle object if not exists.
	 *
	 * @return The ResourceBundle object if not exist.
	 */
	public static ResourceBundle getInstance() {
		if (messages == null) {
			try {
				// user default Locale :
				locale = Locale.getDefault();


				messages = ResourceBundle.getBundle("messages", locale);
			} catch (MissingResourceException e) {
				System.exit(0);
			}
		}

		return messages;
	}

	/**
	 * Method to simplify call => I18N.lang("aa.bb") and not
	 * I18N.getInstance().getMessages().getString("aa.bb") and to catch exeption
	 * when key not found.
	 *
	 * @param key
	 * @return The string value of given key.
	 */
	public static String lang(String key) {
		String value = "KEY_NOT_FOUND";

		try {
			value = I18N.getInstance().getString(key);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return value;
	}

	/**
	 * Create the instance for the first time.
	 */
	public static void init() {
		if (I18N.getInstance() != null) {
			System.out.println("Locale configured successfully to : " + I18N.lang("tag"));
		}
	}
}