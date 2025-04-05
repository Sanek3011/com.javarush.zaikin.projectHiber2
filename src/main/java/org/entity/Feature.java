package org.entity;

public enum Feature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    Feature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Feature getFeature(String value) {
        for (Feature feature : Feature.values()) {
            if (feature.value.equals(value)) {
                return feature;
            }
        }
        return null;
    }
}
