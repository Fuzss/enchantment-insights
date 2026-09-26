package fuzs.enchantmentinsights.common.client.handler;

import fuzs.enchantmentinsights.common.EnchantmentInsights;
import fuzs.enchantmentinsights.common.client.gui.component.EnchantmentComponents;
import fuzs.enchantmentinsights.common.client.gui.tooltip.EnchantmentTooltipLines;
import fuzs.enchantmentinsights.common.client.util.EnchantmentWithLevel;
import fuzs.enchantmentinsights.common.config.ClientConfig;
import fuzs.tooltipinsights.common.api.v1.client.handler.TooltipDescriptionsHandler;
import fuzs.tooltipinsights.common.api.v1.config.StyledTooltipsConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.*;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class EnchantedItemTooltipHandler extends TooltipDescriptionsHandler<EnchantmentWithLevel, ClientConfig.EnchantmentLevelTooltipComponents> {
    public static final TooltipDescriptionsHandler<EnchantmentWithLevel, ClientConfig.EnchantmentLevelTooltipComponents> INSTANCE = new EnchantedItemTooltipHandler();

    private EnchantedItemTooltipHandler() {
        super(EnchantmentTooltipLines.ENCHANTMENT_LEVEL_SUPPLIERS);
    }

    @Override
    protected StyledTooltipsConfig<ClientConfig.EnchantmentLevelTooltipComponents> getStyleConfig() {
        return EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantedItemTooltips;
    }

    @Override
    protected Map<ComponentContents, EnchantmentWithLevel> getByName(ItemStack itemStack, HolderLookup.Provider registries) {
        return getByName(EnchantmentComponents.getAllEnchantments(itemStack));
    }

    public static Map<ComponentContents, EnchantmentWithLevel> getByName(Stream<EnchantmentWithLevel> stream) {
        // An item can contain the same enchantment multiple times, so we must include a merge function.
        return stream.collect(Collectors.toMap((EnchantmentWithLevel enchantment) -> enchantment.enchantment()
                .value()
                .description()
                .getContents(), Function.identity(), (EnchantmentWithLevel o1, EnchantmentWithLevel o2) -> o2));
    }

    @Override
    protected Component getNameComponent(Component originalName, EnchantmentWithLevel enchantment) {
        // Keep the original component so text added by other mods is preserved, only replace the name color.
        MutableComponent enchantmentName = originalName.copy();
        return addLevelComponent(enchantment.enchantment(),
                enchantment.level(),
                mergeEnchantmentStyle(enchantment.enchantment(), enchantmentName));
    }

    private static MutableComponent mergeEnchantmentStyle(Holder<Enchantment> enchantment, MutableComponent enchantmentName) {
        Style style = getEnchantmentStyle(enchantment);
        // The config color takes precedence, other root attributes set by other mods are preserved; empty config clears the vanilla color.
        enchantmentName.setStyle(style.isEmpty() ? Style.EMPTY : style.applyTo(enchantmentName.getStyle()));
        return enchantmentName;
    }

    private static Style getEnchantmentStyle(Holder<Enchantment> enchantment) {
        ClientConfig.EnchantmentTextStyling styling = EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantedItemTooltips.enchantmentNameStyling;
        if (enchantment.is(EnchantmentTags.CURSE)) {
            return styling.curseStyle;
        } else if (enchantment.is(EnchantmentTags.TREASURE)) {
            return styling.treasureStyle;
        } else {
            return styling.defaultStyle;
        }
    }

    private static MutableComponent addLevelComponent(Holder<Enchantment> enchantment, int level, MutableComponent enchantmentName) {
        if (EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantedItemTooltips.itemTooltipLines.maximumLevel()) {
            int maxLevel = enchantment.value().getMaxLevel();
            enchantmentName.append(CommonComponents.SPACE)
                    .append("(")
                    .append(Component.translatable("enchantment.level." + maxLevel))
                    .append(")");
        }

        return enchantmentName;
    }
}
