package constants;

import lombok.Getter;

@Getter
public enum Filters {

    Condition("condition", "Used", "Condition:"),
    Price("price", "200", "Price:"),
    Location("location", "North America", "Item Location:");

    private String filterType;
    private String filterValue;
    private String appliedValue;

    private Filters(String filterType, String filterValue, String appliedValue) {
        this.filterType = filterType;
        this.filterValue = filterValue;
        this.appliedValue = appliedValue;
    }
    }
