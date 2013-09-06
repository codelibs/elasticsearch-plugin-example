package org.codelibs.elasticsearch.sample.module;

import org.codelibs.elasticsearch.sample.service.SampleService;
import org.elasticsearch.common.inject.AbstractModule;

public class SampleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SampleService.class).asEagerSingleton();
    }
}