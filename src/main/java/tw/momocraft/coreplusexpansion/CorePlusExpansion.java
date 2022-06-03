package tw.momocraft.coreplusexpansion;

import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import tw.momocraft.coreplus.api.CorePlusAPI;

import java.util.Map;

public final class CorePlusExpansion extends PlaceholderExpansion implements Configurable {

    @Override
    public String getIdentifier() {
        return "coreplus";
    }

    @Override
    public String getAuthor() {
        return "momocraft";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier) {
        // %coreplus_IDENTIFIER%

        // %coreplus_playerdata_VALUE%
        if (identifier.startsWith("playerdata_")) {
            return CorePlusAPI.getFile().getMySQL().getValue("CorePlusExpansion",
                    ).getResSelectionTool().name();
        }
        // %coreplus_placeholder_VALUE%
        if (identifier.startsWith("placeholder_")) {
            return CorePlusAPI.getMsg().transHolder("CorePlusExpansion", player,
                    identifier.substring(identifier.indexOf("placeholder_")));
        }
        // return null for unknown placeholders
        return null;
    }

    @Override
    public Map<String, Object> getDefaults() {
        return null;
    }
}