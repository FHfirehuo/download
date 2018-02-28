package com.ciecc.fire.download.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.ciecc.fire.download.domain.SetPojo;

@Component
@ConfigurationProperties(prefix="foo")
public class YMLSetting {

	private final List<SetPojo> list = new ArrayList<>();

    public List<SetPojo> getList() {
        return this.list;
    }
}
