package com.netflix.simianarmy.aws.janitor.crawler.edda;

import com.netflix.simianarmy.Resource;
import org.codehaus.jackson.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class JsonNodeTagsProcessor {
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(EddaASGJanitorCrawler.class);

    public static void processJsonNodeTags(JsonNode jsonNode, Resource resource) {
        JsonNode tags = jsonNode.get("tags");
        if (tags == null || !tags.isArray() || tags.size() == 0) {
            LOGGER.debug(String.format("No tags is found for %s", resource.getId()));
        } else {
            for (Iterator<JsonNode> it = tags.getElements(); it.hasNext(); ) {
                JsonNode tag = it.next();
                String key = tag.get("key").getTextValue();
                String value = tag.get("value").getTextValue();
                resource.setTag(key, value);
            }
        }
    }
}
