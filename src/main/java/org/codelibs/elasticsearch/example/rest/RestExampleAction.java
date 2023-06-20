package org.codelibs.elasticsearch.example.rest;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static org.elasticsearch.rest.RestRequest.Method.GET;
import static org.elasticsearch.rest.RestStatus.OK;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.elasticsearch.client.internal.node.NodeClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestResponse;
import org.elasticsearch.xcontent.XContentBuilder;
import org.elasticsearch.xcontent.json.JsonXContent;

public class RestExampleAction extends BaseRestHandler {

    public RestExampleAction(final Settings settings,
            final RestController controller) {
        // nothing
    }

    @Override
    public List<Route> routes() {
        return unmodifiableList(asList(new Route(GET, "/{index}/_example"),
                new Route(GET, "/_example")));
    }

    @Override
    public String getName() {
        return "example_get";
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
                    "This is a example response: " + new Date().toString());
            builder.endObject();
            channel.sendResponse(new RestResponse(OK, builder));
        };
    }

}
