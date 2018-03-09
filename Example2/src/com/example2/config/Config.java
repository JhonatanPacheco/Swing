package com.example2.config;


import java.io.IOException;
import java.util.Properties;

public class Config {

	private static Properties properties;

	protected Config() {
	}

	/**
	 * Lazy init for this Singleton Class.
	 *
	 * @return The Properties object.
	 */
	public static Properties getInstance() {
		if (properties == null) {
			try {
				properties = new Properties();

				// load config.properties :
				properties.load(Config.class.getClassLoader().getResourceAsStream("app.properties"));

			} catch (IOException e) {
				System.exit(0);
			}
		}

		return properties;
	}

	/**
	 * Method to get the properties value for a given key.
	 *
	 * @param key
	 * @return The String value.
	 */
	public static String getProperty(String key) {
		return Config.getInstance().getProperty(key);
	}

	/**
	 * Create the instance for the first time.
	 */
	public static void init() {
		Config.getInstance();
	}
}
