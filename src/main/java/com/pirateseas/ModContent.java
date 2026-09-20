package com.pirateseas;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModContent {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PirateSeas.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PirateSeas.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PirateSeas.MOD_ID);

    public static final RegistryObject<EntityType<PirateEntity>> DECKHAND =
            ENTITIES.register("pirate_deckhand", () -> EntityType.Builder.of(PirateEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).build("pirate_deckhand"));
    public static final RegistryObject<EntityType<PirateEntity>> GUNNER =
            ENTITIES.register("pirate_gunner", () -> EntityType.Builder.of(PirateEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).build("pirate_gunner"));
    public static final RegistryObject<EntityType<PirateEntity>> MUSKETEER =
            ENTITIES.register("pirate_musketeer", () -> EntityType.Builder.of(PirateEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).build("pirate_musketeer"));
    public static final RegistryObject<EntityType<PirateEntity>> CAPTAIN =
            ENTITIES.register("pirate_captain", () -> EntityType.Builder.of(PirateEntity::new, MobCategory.MONSTER)
                    .sized(0.65f, 2.0f).build("pirate_captain"));
    public static final RegistryObject<EntityType<BulletEntity>> BULLET =
            ENTITIES.register("bullet", () -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC)
                    .sized(0.18f, 0.18f).clientTrackingRange(8).updateInterval(1).build("bullet"));

    public static final RegistryObject<Item> PIRATE_HAT =
            ITEMS.register("pirate_hat", () -> new ArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CAPTAIN_HAT =
            ITEMS.register("captain_hat", () -> new ArmorItem(ArmorMaterials.GOLD, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CUTLASS =
            ITEMS.register("cutlass", () -> new SwordItem(Tiers.IRON, 4, -2.2f, new Item.Properties().durability(420)));
    public static final RegistryObject<Item> CAPTAINS_SABRE =
            ITEMS.register("captains_sabre", () -> new SwordItem(Tiers.DIAMOND, 4, -2.05f,
                    new Item.Properties().durability(700).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> LEAD_BALL =
            ITEMS.register("lead_ball", () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> FLINTLOCK =
            ITEMS.register("flintlock_pistol", () -> new GunItem(7f, 2.1f, 2.5f, 1, 30,
                    new Item.Properties().durability(280)));
    public static final RegistryObject<Item> MUSKET =
            ITEMS.register("musket", () -> new GunItem(11f, 2.8f, 1.0f, 1, 45,
                    new Item.Properties().durability(360)));
    public static final RegistryObject<Item> BLUNDERBUSS =
            ITEMS.register("blunderbuss", () -> new GunItem(4f, 1.9f, 10f, 7, 50,
                    new Item.Properties().durability(300)));

    public static final RegistryObject<Item> DECKHAND_EGG =
            ITEMS.register("pirate_deckhand_spawn_egg", () -> new ForgeSpawnEggItem(DECKHAND, 0x5A301C, 0xC4372D, new Item.Properties()));
    public static final RegistryObject<Item> GUNNER_EGG =
            ITEMS.register("pirate_gunner_spawn_egg", () -> new ForgeSpawnEggItem(GUNNER, 0x243D5B, 0xD4A331, new Item.Properties()));
    public static final RegistryObject<Item> MUSKETEER_EGG =
            ITEMS.register("pirate_musketeer_spawn_egg", () -> new ForgeSpawnEggItem(MUSKETEER, 0x31533A, 0xCFC4A2, new Item.Properties()));
    public static final RegistryObject<Item> CAPTAIN_EGG =
            ITEMS.register("pirate_captain_spawn_egg", () -> new ForgeSpawnEggItem(CAPTAIN, 0x171419, 0xA01E24, new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> TAB =
            TABS.register("pirate_seas", () -> CreativeModeTab.builder()
                    .title(Component.literal("Pirate Seas"))
                    .icon(() -> new ItemStack(CUTLASS.get()))
                    .displayItems((p, out) -> {
                        out.accept(PIRATE_HAT.get()); out.accept(CAPTAIN_HAT.get());
                        out.accept(CUTLASS.get()); out.accept(CAPTAINS_SABRE.get());
                        out.accept(FLINTLOCK.get()); out.accept(MUSKET.get()); out.accept(BLUNDERBUSS.get());
                        out.accept(LEAD_BALL.get());
                        out.accept(DECKHAND_EGG.get()); out.accept(GUNNER_EGG.get());
                        out.accept(MUSKETEER_EGG.get()); out.accept(CAPTAIN_EGG.get());
                    }).build());

    private ModContent() {}
}
