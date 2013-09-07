package org.codelibs.elasticsearch.sample.module;

import org.codelibs.elasticsearch.sample.river.SampleRiver;
import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.river.River;

public class SampleRiverModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(River.class).to(SampleRiver.class).asEagerSingleton();
    }
}
