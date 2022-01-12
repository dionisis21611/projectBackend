package tech.getarrays.petmanager.Side;

import java.util.Optional;


public enum RoleName {
    ROLE_USER("Πολίτης"),
    ROLE_DOCTOR("Κτηνίατρος"),
    ROLE_EMPLOYEE("Δημοτικός υπάλληλος"),
    ROLE_ADMIN("Διαχειριστής");

    private final String label;

    RoleName(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Optional<RoleName> from(String text) {
        return Optional.ofNullable(text)
                .map(String::toUpperCase)
                .map(RoleName::valueOf);
    }

    public RoleName valueOfLabel(String label){
        for (RoleName r : values()) {
            if (r.label.equals(label)){
                return r;
            }
        }
        return null;
    }
}
