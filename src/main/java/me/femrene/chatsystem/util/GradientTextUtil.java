package me.femrene.chatsystem.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class GradientTextUtil {

    private static final MiniMessage MINI_MESSAGE = MiniMessage.builder().build();

    public static String applyGradient(String text) {
        Component component = MINI_MESSAGE.deserialize(text);
        return MINI_MESSAGE.serialize(component);
    }
}