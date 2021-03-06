package com.simonorj.mc.phantomsmp;

import org.bukkit.configuration.file.FileConfiguration;

class ConfigTool {
    static final String REMOVE_TARGETING_RESTED_NODE = "remove-targeting-rested";
    static final String REMOVE_WHEN_SLEEPING_NODE = "remove-when-sleeping";
    static final String DISALLOW_SPAWNING_FOR_NODE = "disallow-targeting-for";
    static final String ENABLE_METRICS_NODE = "enable-metrics";
    static final String CONFIG_VERSION_NODE = "config-version";
    static final int version = 1;

    private static final String HEADER =
            "# PhantomSMP by Simon Chuu\n" +
            "\n" +
            "# For help, follow the plugin project link below:\n" +
            "# https://github.com/SimonOrJ/PhantomSMP/\n";

    private static final String REMOVE_TARGETING_RESTED =
            "# Remove phantoms that try to target player slept within three (Minecraft)\n" +
            "# days?\n" +
            "#   true = remove phantom targeting rested player\n" +
            "#   false = Keep phantoms (and make phantoms try to target another player)\n";

    private static final String REMOVE_WHEN_SLEEPING =
            "# Remove phantoms right away when the player sleeps in bed?\n" +
            "#   true = remove phantoms as soon as player sleeps\n" +
            "#   false = Keep phantoms (and let the above option take care of it)\n";

    private static final String DISALLOW_SPAWNING_FOR =
            "# How many ticks since player rested should phantoms ignore the player?\n" +
            "#   NOTE: Any value under 72000 (3 full Minecraft days) will essentially be\n" +
            "#   ignored for phantom spawning.  It will only have an effect on already\n" +
            "#   spawned phantoms only.\n";

    private static final String ENABLE_METRICS =
            "# Enable metrics for this plugin? (If unsure, leave it as true)\n" +
            "#   Link to metrics: https://bstats.org/plugin/bukkit/PhantomSMP/\n";

    private static final String CONFIG_VERSION =
            "# Keeps track of configuration version -- do not change!\n";

    static String saveToString(FileConfiguration config) {
        boolean remove = config.getBoolean(REMOVE_TARGETING_RESTED_NODE, true);
        boolean sleeping = config.getBoolean(REMOVE_WHEN_SLEEPING_NODE, true);
        int disallow = config.getInt(DISALLOW_SPAWNING_FOR_NODE, 72000);
        boolean metrics = config.getBoolean(ENABLE_METRICS_NODE, true);

        return HEADER +
                "\n" +
                REMOVE_TARGETING_RESTED +
                REMOVE_TARGETING_RESTED_NODE +
                ": " + remove +
                "\n\n" +
                REMOVE_WHEN_SLEEPING +
                REMOVE_WHEN_SLEEPING_NODE +
                ": " + sleeping +
                "\n\n" +
                DISALLOW_SPAWNING_FOR +
                DISALLOW_SPAWNING_FOR_NODE +
                ": " + disallow +
                "\n\n" +
                ENABLE_METRICS +
                ENABLE_METRICS_NODE +
                ": " + metrics +
                "\n\n" +
                CONFIG_VERSION +
                CONFIG_VERSION_NODE +
                ": " + version +
                "\n";
    }
}
