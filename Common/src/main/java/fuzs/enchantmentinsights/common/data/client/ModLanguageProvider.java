package fuzs.enchantmentinsights.common.data.client;

import fuzs.puzzleslib.common.api.client.data.v3.language.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;
import net.minecraft.world.item.enchantment.Enchantments;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations() {
        this.addVanillaEnchantments();
        this.addModEffects();
    }

    private void addVanillaEnchantments() {
        this.add(Enchantments.AQUA_AFFINITY, "desc", "Improves underwater mining speed.");
        this.add(Enchantments.BANE_OF_ARTHROPODS, "desc", "Increases damage against arthropods.");
        this.add(Enchantments.BINDING_CURSE, "desc", "Prevents armor removal.");
        this.add(Enchantments.BLAST_PROTECTION, "desc", "Reduces explosion damage.");
        this.add(Enchantments.BREACH, "desc", "Reduces target's armor effectiveness.");
        this.add(Enchantments.CHANNELING, "desc", "Summons lightning on struck targets during storms.");
        this.add(Enchantments.DENSITY, "desc", "Increases mace smash damage.");
        this.add(Enchantments.DEPTH_STRIDER, "desc", "Increases underwater movement speed.");
        this.add(Enchantments.EFFICIENCY, "desc", "Increases mining speed.");
        this.add(Enchantments.FEATHER_FALLING, "desc", "Reduces fall damage.");
        this.add(Enchantments.FIRE_ASPECT, "desc", "Sets targets ablaze.");
        this.add(Enchantments.FIRE_PROTECTION, "desc", "Reduces fire damage.");
        this.add(Enchantments.FLAME, "desc", "Creates flaming arrows.");
        this.add(Enchantments.FORTUNE, "desc", "Increases block drop rates.");
        this.add(Enchantments.FROST_WALKER, "desc", "Creates frozen water walkways.");
        this.add(Enchantments.IMPALING, "desc", "Increases damage against aquatic mobs.");
        this.add(Enchantments.INFINITY, "desc", "Prevents arrow consumption.");
        this.add(Enchantments.KNOCKBACK, "desc", "Increases knockback strength.");
        this.add(Enchantments.LOOTING, "desc", "Increases mob drop rates.");
        this.add(Enchantments.LOYALTY, "desc", "Returns thrown trident.");
        this.add(Enchantments.LUCK_OF_THE_SEA, "desc", "Increases fishing treasure chances.");
        this.add(Enchantments.LUNGE, "desc", "Launches user forward on spear jab attacks.");
        this.add(Enchantments.LURE, "desc", "Reduces fishing time.");
        this.add(Enchantments.MENDING, "desc", "Repairs items with experience.");
        this.add(Enchantments.MULTISHOT, "desc", "Shoots multiple arrows.");
        this.add(Enchantments.PIERCING, "desc", "Arrows pierce multiple targets.");
        this.add(Enchantments.POWER, "desc", "Increases arrow damage.");
        this.add(Enchantments.PROJECTILE_PROTECTION, "desc", "Reduces projectile damage.");
        this.add(Enchantments.PROTECTION, "desc", "Reduces most damage types.");
        this.add(Enchantments.PUNCH, "desc", "Increases arrow knockback.");
        this.add(Enchantments.QUICK_CHARGE, "desc", "Reduces crossbow loading time.");
        this.add(Enchantments.RESPIRATION, "desc", "Extends underwater breathing.");
        this.add(Enchantments.RIPTIDE, "desc", "Launches user in water or rain.");
        this.add(Enchantments.SHARPNESS, "desc", "Increases melee damage.");
        this.add(Enchantments.SILK_TOUCH, "desc", "Blocks drop themselves.");
        this.add(Enchantments.SMITE, "desc", "Increases damage against undead.");
        this.add(Enchantments.SOUL_SPEED, "desc", "Increases speed on soul blocks.");
        this.add(Enchantments.SWEEPING_EDGE, "desc", "Increases sweep attack damage.");
        this.add(Enchantments.SWIFT_SNEAK, "desc", "Increases sneaking speed.");
        this.add(Enchantments.THORNS, "desc", "Damages attacking entities.");
        this.add(Enchantments.UNBREAKING, "desc", "Increases item durability.");
        this.add(Enchantments.VANISHING_CURSE, "desc", "Destroys item on death.");
        this.add(Enchantments.WIND_BURST, "desc", "Creates launching wind on mace smash.");
    }

    private void addModEffects() {
        this.add("enchantment.enchantplus.armor.fury", "desc", "Increases damage and armor penetration.");
        this.add("enchantment.enchantplus.armor.lifeplus", "desc", "Increases maximum health.");
        this.add("enchantment.enchantplus.armor.venom_protection", "desc", "Reduces negative effect duration.");
        this.add("enchantment.enchantplus.axe.timber", "desc", "Cuts down entire trees.");
        this.add("enchantment.enchantplus.boots.agility", "desc", "Increases movement speed.");
        this.add("enchantment.enchantplus.boots.lava_walker", "desc", "Creates solid lava walkways.");
        this.add("enchantment.enchantplus.boots.step_assist", "desc", "Allows stepping up higher blocks.");
        this.add("enchantment.enchantplus.bow.accuracy_shot", "desc", "Reduces arrow spread.");
        this.add("enchantment.enchantplus.bow.breezing_arrow", "desc", "Launches nearby entities upward.");
        this.add("enchantment.enchantplus.bow.echo_shot", "desc", "Creates echoing arrows.");
        this.add("enchantment.enchantplus.bow.explosive_arrow", "desc", "Creates explosive arrows.");
        this.add("enchantment.enchantplus.bow.storm_arrow", "desc", "Creates storm charged arrows.");
        this.add("enchantment.enchantplus.chestplate.builder_arm", "desc", "Increases block reach.");
        this.add("enchantment.enchantplus.elytra.armored", "desc", "Reduces damage while gliding.");
        this.add("enchantment.enchantplus.helmet.auto_feed", "desc", "Automatically restores hunger.");
        this.add("enchantment.enchantplus.helmet.bright_vision", "desc", "Provides night vision.");
        this.add("enchantment.enchantplus.helmet.voidless", "desc", "Prevents falling into the void.");
        this.add("enchantment.enchantplus.hoe.scyther", "desc", "Tills multiple blocks.");
        this.add("enchantment.enchantplus.leggings.dwarfed", "desc", "Reduces player size.");
        this.add("enchantment.enchantplus.leggings.fast_swim", "desc", "Increases swimming speed.");
        this.add("enchantment.enchantplus.leggings.leaping", "desc", "Increases jump height.");
        this.add("enchantment.enchantplus.leggings.oversize", "desc", "Increases player size.");
        this.add("enchantment.enchantplus.mace.striker", "desc", "Summons lightning on attacks.");
        this.add("enchantment.enchantplus.mace.wind_propulsion", "desc", "Launches user upward on impact.");
        this.add("enchantment.enchantplus.pickaxe.bedrock_breaker", "desc", "Allows breaking bedrock.");
        this.add("enchantment.enchantplus.pickaxe.spawner_touch", "desc", "Allows mining monster spawners.");
        this.add("enchantment.enchantplus.pickaxe.vein_miner", "desc", "Mines connected ore blocks.");
        this.add("enchantment.enchantplus.sword.attack_speed", "desc", "Increases attack speed.");
        this.add("enchantment.enchantplus.sword.fear", "desc", "Delays creeper explosions.");
        this.add("enchantment.enchantplus.sword.life_steal", "desc", "Restores health on hit.");
        this.add("enchantment.enchantplus.sword.poison_aspect", "desc", "Poisons struck targets.");
        this.add("enchantment.enchantplus.sword.pull", "desc", "Chance to obtain monster spawn eggs.");
        this.add("enchantment.enchantplus.sword.reach", "desc", "Increases attack range.");
        this.add("enchantment.enchantplus.sword.xp_boost", "desc", "Increases experience gain.");
        this.add("enchantment.enchantplus.tools.auto_smelt", "desc", "Automatically smelts mined blocks.");
        this.add("enchantment.enchantplus.tools.miningplus", "desc", "Increases mining speed.");
        this.add("enchantment.enchantplus.bow.eternal_frost", "desc", "Creates icy arrows.");
        this.add("enchantment.enchantplus.bow.rebound", "desc", "Arrows ricochet between targets.");
        this.add("enchantment.enchantplus.durability.curse_of_breaking", "desc", "Increases durability consumption.");
        this.add("enchantment.enchantplus.durability.curse_of_enchant",
                "desc",
                "Prevents enchanting and disenchanting.");
        this.add("enchantment.enchantplus.mace.teluric_wave", "desc", "Creates seismic waves.");
        this.add("enchantment.enchantplus.sword.last_hope", "desc", "Consumes the weapon for a fatal strike.");
        this.add("enchantment.enchantplus.sword.tears_of_asflors", "desc", "Converts experience into damage.");
        this.add("enchantment.enchantplus.trident.gungnir_breath", "desc", "Freezes water and slows targets.");
        this.add("enchantment.enchantplus.elytra.kinetic_protection", "desc", "Reduces elytra collision damage.");
        this.add("enchantment.enchantplus.hoe.harvest", "desc", "Plants seeds in an area.");
        this.add("enchantment.enchantplus.sword.dimensional_hit", "desc", "Increases damage in other dimensions.");
        this.add("enchantment.enchantplus.sword.critical", "desc", "Partially ignores armor.");
        this.add("enchantment.enchantplus.sword.death_touch", "desc", "Applies Darkness.");
        this.add("enchantment.enchantplus.sword.runic_despair", "desc", "Increases damage in the Runic dimension.");
        this.add("enchantment.enchantplus.chestplate.magnet", "desc", "Collects nearby items.");
        this.add("enchantment.enchantplus.mounted.cavalier_egis", "desc", "Reduces damage while mounted.");
        this.add("enchantment.enchantplus.mounted.ethereal_leap", "desc", "Increases mount jump height.");
        this.add("enchantment.enchantplus.mounted.steel_fang", "desc", "Increases wolf damage.");
        this.add("enchantment.enchantplus.mounted.velocity", "desc", "Increases mount speed.");
        this.add("enchantment.air_jump_enchantment.air_jump", "desc", "Grants an extra midair jump.");
        this.add("enchantment.kattersstructures.blunt", "desc", "Increases damage against armored targets.");
        this.add("enchantment.kattersstructures.crystal_curse", "desc", "Increases damage but reduces durability.");
        this.add("enchantment.kattersstructures.web_walker", "desc", "Increases cobweb movement speed.");
        this.add("enchantment.phy_nvs.nightvision", "desc", "Provides temporary night vision.");
        this.add("enchantment.deeperdarker.catalysis", "desc", "Spreads sculk from defeated mobs.");
        this.add("enchantment.deeperdarker.sculk_smite", "desc", "Increases damage against sculk mobs.");
        this.add("enchantment.create_sa.gravity_gun", "desc", "Allows moving and throwing entities.");
        this.add("enchantment.create_sa.impact", "desc", "Creates a damaging impact burst.");
        this.add("enchantment.create_sa.digging", "desc", "Mines a larger area.");
        this.add("enchantment.create_sa.hellfire", "desc", "Increases flamethrower damage.");
        this.add("enchantment.galosphere.enfeeble", "desc", "Pink salt pillars inflict slowness.");
        this.add("enchantment.galosphere.rupture", "desc", "Pink salt pillars release damaging shards.");
        this.add("enchantment.galosphere.sustain", "desc", "Extends pink salt pillar duration.");
        this.add("enchantment.galosphere.sifting", "desc", "Increases suspicious block yields.");
        this.add("enchantment.wan_ancient_beasts.hunter_mark", "desc", "Increases damage against beasts.");
        this.add("enchantment.wan_ancient_beasts.blood_thirst",
                "desc",
                "Increases damage while affected by potion effects.");
        this.add("enchantment.wan_ancient_beasts.life_steal", "desc", "Restores health on hit.");
        this.add("enchantment.gofish.deepfry", "desc", "Catches cooked fish.");
        this.add("enchantment.shieldsplus.recoil", "desc", "Knocks back attackers.");
        this.add("enchantment.shieldsplus.reflection", "desc", "Reflects damage to attackers.");
        this.add("enchantment.shieldsplus.reinforced", "desc", "Increases shield protection.");
        this.add("enchantment.shieldsplus.aegis", "desc", "Reduces damage after blocking.");
        this.add("enchantment.shieldsplus.ablaze", "desc", "Ignites attackers.");
        this.add("enchantment.shieldsplus.lightweight", "desc", "Increases movement while blocking.");
        this.add("enchantment.shieldsplus.fast_recovery", "desc", "Reduces shield cooldown.");
        this.add("enchantment.shieldsplus.shield_bash", "desc", "Grants a shield bash attack.");
        this.add("enchantment.shieldsplus.perfect_parry", "desc", "Perfectly timed blocks negate damage.");
        this.add("enchantment.shieldsplus.celestial_guardian", "desc", "Survive lethal damage while blocking.");
        this.add("enchantment.grapplemod.wallrunenchantment", "desc", "Allows running on walls.");
        this.add("enchantment.grapplemod.doublejumpenchantment", "desc", "Grants an extra jump.");
        this.add("enchantment.grapplemod.slidingenchantment", "desc", "Allows momentum based sliding.");
        this.add("enchantment.hunterillager.bounce", "desc", "Increases boomerang bounces.");
        this.add("enchantment.betterarcheology.penetrating_strike",
                "desc",
                "Partially bypasses protection enchantments.");
        this.add("enchantment.betterarcheology.seas_bounty", "desc", "Increases fishing treasure variety.");
        this.add("enchantment.betterarcheology.soaring_winds", "desc", "Boosts elytra takeoff.");
        this.add("enchantment.betterarcheology.tunneling", "desc", "Mines an extra block below.");
        this.add("enchantment.endlessbiomes.vwooping", "desc", "Attackers may be teleported away.");
        this.add("enchantment.endlessbiomes.shared_pain", "desc", "Excess damage hits nearby enemies.");
        this.add("enchantment.stalwart_dungeons.thunder_strike", "desc", "Allows hammers to summon lightning.");
        this.add("enchantment.butcher.butcherenchantment", "desc", "Mobs drop their corpses.");
        this.add("enchantment.blockswapper.excavating", "desc", "Allows replacing blocks with air.");
        this.add("enchantment.cardiac.lifesteal", "desc", "Defeated mobs drop extra healing orbs.");
    }
}
