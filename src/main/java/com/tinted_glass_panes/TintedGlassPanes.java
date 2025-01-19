package com.tinted_glass_panes;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class TintedGlassPanes implements ModInitializer {
	static Identifier TINTED_GLASS_PANE_IDENTIFIER = Identifier.of("tinted_glass_panes", "tinted_glass_pane");

	public static class TintedGlassPaneBlock extends PaneBlock {
		public TintedGlassPaneBlock(Settings settings) {
			super(settings);
		}

		@Override
		public int getOpacity(BlockState state) {
			return 15;
		}
	}

	public static final RegistryKey<Block> TINTED_GLASS_PANE_KEY = RegistryKey.of(
			RegistryKeys.BLOCK,
			TINTED_GLASS_PANE_IDENTIFIER
	);

	public static final RegistryKey<Item> TINTED_GLASS_PANE_ITEM_KEY = RegistryKey.of(
			RegistryKeys.ITEM,
			TINTED_GLASS_PANE_IDENTIFIER
	);

	public static final Block TINTED_GLASS_PANE = Registry.register(
			Registries.BLOCK,
			TINTED_GLASS_PANE_KEY,
			new TintedGlassPaneBlock(Block.Settings.create().strength(0.3f).sounds(BlockSoundGroup.GLASS).registryKey(TINTED_GLASS_PANE_KEY))
	);

	public static final Item TINTED_GLASS_PANE_ITEM = Registry.register(
			Registries.ITEM,
			TINTED_GLASS_PANE_ITEM_KEY,
			new BlockItem(TINTED_GLASS_PANE, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(TINTED_GLASS_PANE_ITEM_KEY))
	);

	@Override
	public void onInitialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(content -> content.addAfter(Items.GLASS_PANE, TINTED_GLASS_PANE_ITEM));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.addAfter(Items.TINTED_GLASS, TINTED_GLASS_PANE_ITEM));
	}
}