package ru.ok.onelog.builtin;

public enum Outcome {
    success,
    failure;

    public static Outcome successIf(boolean success) {
        return success ? success : failure;
    }
}
