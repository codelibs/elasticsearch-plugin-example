package org.codelibs.elasticsearch.sample.module;

import org.codelibs.elasticsearch.sample.river.SampleRiver;
import org.elasticsearch.common.inject.AbstractModule;

public class SampleRiverModule extends AbstractModule {
    @Override
    protected void configure() {
        this.bind(SampleRiver.class).asEagerSingleton();
    }
}
