package org.codelibs.elasticsearch.sample.rest;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static org.elasticsearch.rest.RestRequest.Method.GET;
import static org.elasticsearch.rest.RestStatus.OK;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;

public class RestSampleAction extends BaseRestHandler {

    public RestSampleAction(final Settings settings,
            final RestController controller) {
        // nothing
    }

    @Override
    public List<Route> routes() {
        return unmodifiableList(asList(new Route(GET, "/{index}/_sample"),
                new Route(GET, "/_sample")));
    }

    @Override
    public String getName() {
        return "sample_get";
    }

    @Override
    protected RestChannelConsumer prepareRequest(final RestRequest request,
            final NodeClient client) throws IOException {
        final boolean isPretty = request.hasParam("pretty");
        final String index = request.param("index");
        return channel -> {
            final XContentBuilder builder = JsonXContent.contentBuilder();
            if (isPretty) {
                builder.prettyPrint().lfAtEnd();
            }
            builder.startObject();
            if (index != null) {
                builder.field("index", index);
            }
            builder.field("description",
                    "This is a sample response: " + new Date().toString());
            builder.endObject();
            channel.sendResponse(new BytesRestResponse(OK, builder));
        };
    }

}
