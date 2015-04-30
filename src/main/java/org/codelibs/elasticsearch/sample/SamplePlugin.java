package org.codelibs.elasticsearch.sample;

import java.util.Collection;

import org.codelibs.elasticsearch.sample.module.SampleModule;
import org.codelibs.elasticsearch.sample.rest.SampleRestAction;
import org.codelibs.elasticsearch.sample.service.SampleService;
import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.rest.RestModule;

public class SamplePlugin extends AbstractPlugin {
    @Override
    public String name() {
        return "SamplePlugin";
    }

    @Override
    public String description() {
        return "This is a sample plugin.";
    }

    // for Rest API
    public void onModule(final RestModule module) {
        module.addRestAction(SampleRestAction.class);
    }

    // for Service
    @Override
    public Collection<Class<? extends Module>> modules() {
        final Collection<Class<? extends Module>> modules = Lists
                .newArrayList();
        modules.add(SampleModule.class);
        return modules;
    }

    // for Service
    @SuppressWarnings("rawtypes")
    @Override
    public Collection<Class<? extends LifecycleComponent>> services() {
        final Collection<Class<? extends LifecycleComponent>> services = Lists
                .newArrayList();
        services.add(SampleService.class);
        return services;
    }
}
