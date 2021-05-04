package com.mandiri.pocket.service;

import java.util.Map;

public interface AppConfigService {

    public String getValue(String value);

    public void setValue(String key, Object value);

    public Map<String, Object> getMap(String key);
}
