package org.unibl.etf.mdp.library.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	private Properties properties;

	public AppConfig() {
		properties = new Properties();
		loadProperties();
	}

	private void loadProperties() {
		try (InputStream input = getClass().getClassLoader()
				.getResourceAsStream("org/unibl/etf/mdp/library/properties/app.properties")) {
			if (input == null) {
				System.out.println("Sorry, unable to find app.properties");
				return;
			}
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private String getProperty(String key) {
		return properties.getProperty(key);
	}

	private double getDoubleProperty(String key) {
		return Double.parseDouble(properties.getProperty(key));
	}

	private Integer getIntegerProperty(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}

	public String getLogDir() {
		return getProperty("LOG_DIR");
	}

	public String getDtoMsg() {
		return getProperty("GET_DTO");
	}

	public String getLogFile() {
		return getProperty("LOG_FILE");
	}

	public String getEndMsg() {
		return getProperty("END_MSG");
	}

	public int getDiscoveryServerTCPPort() {
		return getIntegerProperty("DISCOVERY_SERVER_TCP_PORT");
	}

	public String getDiscoverAllMsg() {
		return getProperty("DISCOVER_ALL");
	}

	public String getRequestMsg() {
		return getProperty("REQUEST");
	}

	public String getApproveMsg() {
		return getProperty("APPROVE");
	}

	public String getDenialMsg() {
		return getProperty("DENIAL");
	}

	public String getOkMsg() {
		return getProperty("OK");
	}
}