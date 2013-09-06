package org.codelibs.elasticsearch.sample.river;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.river.AbstractRiverComponent;
import org.elasticsearch.river.River;
import org.elasticsearch.river.RiverName;
import org.elasticsearch.river.RiverSettings;

public class SampleRiver extends AbstractRiverComponent implements River {
    private final Client client;

    private SampleRiverLogic riverLogic;

    @Inject
    public SampleRiver(final RiverName riverName, final RiverSettings settings,
            final Client client) {
        super(riverName, settings);
        this.client = client;

        logger.info("CREATE SampleRiver");

        // TODO Your code..

    }

    @Override
    public void start() {
        logger.info("START SampleRiver");

        riverLogic = new SampleRiverLogic();
        new Thread(riverLogic).start();
    }

    @Override
    public void close() {
        logger.info("CLOSE SampleRiver");

        // TODO Your code..
    }

    private class SampleRiverLogic implements Runnable {

        @Override
        public void run() {
            logger.info("START SampleRiverLogic: " + client.toString());

            // TODO Your code..
        }
    }
}
