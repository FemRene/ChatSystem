package me.femrene.chatsystem.enums;

public enum Converter {
    // COLORS
    black("§0","<black>"),
    dark_blue("§1","<dark_blue>"),
    dark_green("§2","<dark_green>"),
    dark_aqua("§3","<dark_aqua>"),
    dark_red("§4","<dark_red>"),
    dark_purple("§5","<dark_purple>"),
    gold("§6","<gold>"),
    gray("§7","<gray>"),
    dark_gray("§8","<dark_gray>"),
    blue("§9","<blue>"),
    green("§a","<green>"),
    aqua("§b","<aqua>"),
    red("§c","<red>"),
    light_purple("§d","<light_purple>"),
    yellow("§e","<yellow>"),
    white("§f","<white>"),
    // FORMAT
    obfuscated("§k","<obfuscated>"),
    bold("§l","<bold>"),
    strikethrough("§m","<strikethrough>"),
    underlined("§n","<underlined>"),
    italic("§o","<italic>"),
    reset("§r","<reset>");

    private String oldColor;
    private String newColor;

    Converter(String oldColor, String newColor) {
        this.oldColor = oldColor;
        this.newColor = newColor;
    }

    public String getOldColor() {
        return oldColor;
    }

    public String getNewColor() {
        return newColor;
    }
}
