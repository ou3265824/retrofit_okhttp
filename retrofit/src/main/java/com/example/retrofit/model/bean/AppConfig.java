package com.example.retrofit.model.bean;

/**
 * 配置信息
 * 
 * @author
 *
 */
public class AppConfig extends BaseEntity {


	private String Config_ID;
	private String ConfigKey;
	private String ConfigValue;
	private String ConfigExplain;
	private String ConfigImgUrl;
	
	
	
	public String getConfigImgUrl() {
		return ConfigImgUrl;
	}

	public void setConfigImgUrl(String configImgUrl) {
		ConfigImgUrl = configImgUrl;
	}

	public String getConfig_ID() {
		return Config_ID;
	}

	public void setConfig_ID(String config_ID) {
		Config_ID = config_ID;
	}

	public String getConfigKey() {
		return ConfigKey;
	}

	public void setConfigKey(String configKey) {
		ConfigKey = configKey;
	}

	public String getConfigValue() {
		return ConfigValue;
	}

	public void setConfigValue(String configValue) {
		ConfigValue = configValue;
	}

	public String getConfigExplain() {
		return ConfigExplain;
	}

	public void setConfigExplain(String configExplain) {
		ConfigExplain = configExplain;
	}

	@Override
	public String toString() {
		return "AppConfig{" +
				"Config_ID='" + Config_ID + '\'' +
				", ConfigKey='" + ConfigKey + '\'' +
				", ConfigValue='" + ConfigValue + '\'' +
				", ConfigExplain='" + ConfigExplain + '\'' +
				", ConfigImgUrl='" + ConfigImgUrl + '\'' +
				'}';
	}
}
