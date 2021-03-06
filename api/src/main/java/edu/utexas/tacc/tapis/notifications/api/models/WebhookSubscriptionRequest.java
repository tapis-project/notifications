package edu.utexas.tacc.tapis.notifications.api.models;

import org.hibernate.validator.constraints.URL;

import java.net.URI;

public class WebhookSubscriptionRequest {

    @URL(message = "A valid URL is required")
    private URI endpoint;

    public URI getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(URI endpoint) {
        this.endpoint = endpoint;
    }

}
