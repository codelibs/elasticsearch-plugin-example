package org.codelibs.elasticsearch.sample.service;

import org.elasticsearch.ElasticSearchException;
import org.elasticsearch.common.component.AbstractLifecycleComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;

public class SampleService extends AbstractLifecycleComponent<SampleService> {

    @Inject
    public SampleService(final Settings settings) {
        super(settings);
        logger.info("CREATE SampleService");

        // TODO Your code..
    }

    @Override
    protected void doStart() throws ElasticSearchException {
        logger.info("START SampleService");

        // TODO Your code..
    }

    @Override
    protected void doStop() throws ElasticSearchException {
        logger.info("STOP SampleService");

        // TODO Your code..
    }

    @Override
    protected void doClose() throws ElasticSearchException {
        logger.info("CLOSE SampleService");

        // TODO Your code..
    }

}
