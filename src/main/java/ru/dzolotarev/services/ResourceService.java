package ru.dzolotarev.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * Created by Denis Zolotarev on 09.02.2024
 */

@Component
public class ResourceService {
    private final ResourceLoader resourceLoader;

    public ResourceService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource loadResources() {
        return resourceLoader.getResource("classpath:text.txt");
    }
}
