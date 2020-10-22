package org.springframework.samples.petclinic.secutiry;

public enum Role {
    ADMIN("관리자"),
    OWNER("주인"),
    VETS("수의사"),
    GUEST("손님");

    private final String korean;

    Role(String korean) {
        this.korean = korean;
    }
}
