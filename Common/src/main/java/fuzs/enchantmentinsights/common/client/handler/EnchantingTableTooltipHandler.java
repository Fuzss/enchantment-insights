package fuzs.enchantmentinsights.common.client.handler;

import fuzs.enchantmentinsights.common.EnchantmentInsights;
import fuzs.enchantmentinsights.common.client.gui.tooltip.EnchantmentTooltipLines;
import fuzs.enchantmentinsights.common.client.util.EnchantmentWithLevel;
import fuzs.enchantmentinsights.common.config.ClientConfig;
import fuzs.tooltipinsights.common.api.v1.client.handler.TooltipDescriptionsHandler;
import fuzs.tooltipinsights.common.api.v1.config.StyledTooltipsConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class EnchantingTableTooltipHandler extends TooltipDescriptionsHandler<EnchantmentWithLevel, ClientConfig.EnchantmentTooltipComponents> {
    public static final TooltipDescriptionsHandler<EnchantmentWithLevel, ClientConfig.EnchantmentTooltipComponents> INSTANCE = new EnchantingTableTooltipHandler();

    private EnchantingTableTooltipHandler() {
        super(EnchantmentTooltipLines.ENCHANTMENT_SUPPLIERS);
    }

    @Override
    protected StyledTooltipsConfig<ClientConfig.EnchantmentTooltipComponents> getStyleConfig() {
        return EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantingTableTooltips;
    }

    @Override
    protected Map<Component, EnchantmentWithLevel> getByName(ItemStack itemStack, HolderLookup.Provider registries) {
        Stream<EnchantmentWithLevel> stream = registries.lookupOrThrow(Registries.ENCHANTMENT)
                .listElements()
                .flatMap((Holder.Reference<Enchantment> holder) -> IntStream.rangeClosed(1, holder.value().getMaxLevel())
                        .mapToObj((int level) -> new EnchantmentWithLevel(holder, level)));
        return EnchantedItemTooltipHandler.getByName(stream);
    }
}
