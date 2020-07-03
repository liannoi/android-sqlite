package org.itstep.liannoi.spot.infrastructure.primitives;

import org.jetbrains.annotations.NotNull;

public abstract class Trimmer {
    public static String trimOrLeave(@NotNull String text, int maxLength) {
        return text.length() > maxLength ? text.substring(0, maxLength) + "..." : text;
    }
}
