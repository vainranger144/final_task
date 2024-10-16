package com.example.saucedemo;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class TestDataProvider {
    public static Stream<Arguments> validUserCredentials() {
        return Stream.of(
                Arguments.of("standard_user", "secret_sauce"),
                Arguments.of("problem_user", "secret_sauce")
        );
    }
}
