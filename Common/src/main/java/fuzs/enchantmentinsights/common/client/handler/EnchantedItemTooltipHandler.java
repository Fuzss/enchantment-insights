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
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.chat.MutableComponent;
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
    protected Map<Component, EnchantmentWithLevel> getByName(ItemStack itemStack, HolderLookup.Provider registries) {
        return getByName(EnchantmentComponents.getAllEnchantments(itemStack));
    }

    public static Map<Component, EnchantmentWithLevel> getByName(Stream<EnchantmentWithLevel> stream) {
        // an item can contain the same effect multiple times, so make sure to include a merge function in our collect call
        return stream.collect(Collectors.toMap(
                (EnchantmentWithLevel enchantment) -> Enchantment.getFullname(enchantment.enchantment(), enchantment.level()),
                Function.identity(),
                        (EnchantmentWithLevel o1, EnchantmentWithLevel o2) -> o2));
    }

    @Override
    protected Component getNameComponent(Component originalName, EnchantmentWithLevel enchantment) {
        // Replace the enchantment name with our colored variant.
        return getFullName(enchantment.enchantment(), enchantment.level());
    }

    /**
     * @see Enchantment#getFullname(Holder, int)
     */
    public static Component getFullName(Holder<Enchantment> enchantment, int level) {
        MutableComponent component = enchantment.value().description().copy();
        mergeEnchantmentStyle(enchantment, component);
        addLevelComponent(enchantment, level, component);
        return component;
    }

    private static void mergeEnchantmentStyle(Holder<Enchantment> enchantment, MutableComponent component) {
        if (enchantment.is(EnchantmentTags.CURSE)) {
            ComponentUtils.mergeStyles(component,
                    EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantedItemTooltips.enchantmentNameStyling.curseStyle);
        } else if (enchantment.is(EnchantmentTags.TREASURE)) {
            ComponentUtils.mergeStyles(component,
                    EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantedItemTooltips.enchantmentNameStyling.treasureStyle);
        } else {
            ComponentUtils.mergeStyles(component,
                    EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantedItemTooltips.enchantmentNameStyling.defaultStyle);
        }
    }

    private static void addLevelComponent(Holder<Enchantment> enchantment, int level, MutableComponent component) {
        boolean maximumLevel = EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantedItemTooltips.itemTooltipLines.maximumLevel();

        if (maximumLevel || level != 1 || enchantment.value().getMaxLevel() != 1) {
            component.append(CommonComponents.SPACE).append(Component.translatable("enchantment.level." + level));

            if (maximumLevel) {
                int maxLevel = enchantment.value().getMaxLevel();
                component.append(CommonComponents.SPACE)
                        .append("(")
                        .append(Component.translatable("enchantment.level." + maxLevel))
                        .append(")");
            }
        }
    }
}
