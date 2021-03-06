package com.nickimpact.gts.configuration;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.nickimpact.gts.api.configuration.ConfigKey;
import com.nickimpact.gts.api.configuration.keys.ListKey;
import com.nickimpact.gts.api.configuration.keys.StringKey;
import joptsimple.OptionSpec;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * (Some note will go here)
 *
 * @author NickImpact
 */
public class MsgConfigKeys {

	// Plugin chat prefix (replacement option for {{gts_prefix}}
	public static final ConfigKey<String> PREFIX = StringKey.of("prefix", "&eGTS &7\u00bb");

	// Generic messages for the program
	// Best to support lists of text here, as a server may decide to go heavy on text formatting
	public static final ConfigKey<List<String>> MAX_LISTINGS = ListKey.of("max-listings", Lists.newArrayList(
			"{{gts_prefix}} &cUnfortunately, you can't deposit another listing, since you already have {{max_listings}} deposited..."
	));
	public static final ConfigKey<List<String>> ADD_TEMPLATE = ListKey.of("addition-to-seller", Lists.newArrayList(
			"{{gts_prefix}} &7Your &a{{listing_name}} &7has been added to the market!"
	));
	public static final ConfigKey<List<String>> TAX_APPLICATION = ListKey.of("taxes.applied", Lists.newArrayList(
			"&c&l- {{tax}} &7(&aTaxes&7)"
	));
	public static final ConfigKey<List<String>> TAX_INVALID = ListKey.of("taxes.invalid", Lists.newArrayList(
			"{{gts_prefix}} &cUnable to afford the tax of &e{{tax}} &cfor this listing..."
	));
	public static final ConfigKey<List<String>> ADD_BROADCAST = ListKey.of("addition-broadcast", Lists.newArrayList(
			"{{gts_prefix}} &c{{player}} &7has added a &a{{listing_specifics}} &7to the GTS for &a{{price}}&7!"
	));
	public static final ConfigKey<List<String>> PURCHASE_PAY = ListKey.of("prices.pay", Lists.newArrayList(
			"{{gts_prefix}} &7You have purchased a &a{{listing_specifics}} &7for &e{{price}}&7!"
	));
	public static final ConfigKey<List<String>> PURCHASE_RECEIVE = ListKey.of("prices.receive", Lists.newArrayList(
			"{{gts_prefix}} &7You have received your price of &e{{price}} from your &a{{listing_name}} &7listing!"
	));
	public static final ConfigKey<List<String>> AUCTION_BID = ListKey.of("auctions.bid", Lists.newArrayList(
			"{{gts_prefix}} &e{{player}} &7has placed a bid on the &a{{listing_specifics}}!"
	));
	public static final ConfigKey<List<String>> AUCTION_WIN = ListKey.of("auctions.win", Lists.newArrayList(
			"{{gts_prefix}} &e{{player}} &7has won the auction for the &a{{listing_specifics}}!"
	));
	public static final ConfigKey<List<String>> AUCTION_IS_HIGH_BIDDER = ListKey.of("auctions.is-high-bidder", Lists.newArrayList(
			"{{gts_prefix}} &cHold off! You wouldn't want to bid against yourself!"
	));
	public static final ConfigKey<List<String>> REMOVAL_CHOICE = ListKey.of("removal.choice", Lists.newArrayList(
			"{{gts_prefix}} &7Your &a{{listing_name}} &7listing has been returned!"
	));
	public static final ConfigKey<List<String>> REMOVAL_EXPIRES = ListKey.of("removal.expires", Lists.newArrayList(
			"{{gts_prefix}} &7Your &a{{listing_name}} &7listing has expired, and has thus been returned!"
	));

	// Items
	public static final ConfigKey<String> UI_ITEMS_NEXT_PAGE = StringKey.of("item-displays.next-page", "&a\u2192 Next Page \u2192");
	public static final ConfigKey<String> UI_ITEMS_LAST_PAGE = StringKey.of("item-displays.last-page", "&c\u2190 Last Page \u2190");
	public static final ConfigKey<String> UI_ITEMS_PLAYER_TITLE = StringKey.of("item-displays.head.title", "&ePlayer Info");
	public static final ConfigKey<List<String>> UI_ITEMS_PLAYER_LORE = ListKey.of("item-displays.head.lore", Lists.newArrayList());
	public static final ConfigKey<String> UI_ITEMS_SORT_TITLE = StringKey.of("item-displays.sort.title", "&eSort Listings");
	public static final ConfigKey<List<String>> UI_ITEMS_SORT_LORE = ListKey.of("item-displays.sort.lore", Lists.newArrayList());
	public static final ConfigKey<String> UI_ITEMS_PLAYER_LISTINGS_TITLE = StringKey.of("item-displays.player-listings.title", "&eYour Listings");
	public static final ConfigKey<List<String>> UI_ITEMS_PLAYER_LISTINGS_LORE = ListKey.of("item-displays.player-listings.lore", Lists.newArrayList());

	// Entries
	public static final ConfigKey<List<String>> ENTRY_INFO = ListKey.of("entries.base-info", Lists.newArrayList(
			"",
			"&7Price: &e{{price}}",
			"&7Time Left: &e{{time_left}}"
	));
	public static final ConfigKey<List<String>> AUCTION_INFO = ListKey.of("entries.auction-info", Lists.newArrayList(
			"",
			"&7High Bidder: &e{{high_bidder}}",
			"&7Current Price: &e{{auc_price}}",
			"&7Increment: &e[{increment}}",
			"&7Time Left: &e{{time_left}}"
	));


	// Pokemon Entries
	public static final ConfigKey<String> POKEMON_ENTRY_SPEC_TEMPLATE = StringKey.of("entries.pokemon.spec-template", "{{ability:s}}{{ivs_percent:s}}{{ivs_stat:s}}{{shiny:s}}&a{{pokemon}}");
	public static final ConfigKey<String> POKEMON_ENTRY_BASE_TITLE = StringKey.of("entries.pokemon.base.title", "&e{{pokemon}} {{shiny:s}}&7| &bLvl {{level}}");
	public static final ConfigKey<List<String>> POKEMON_ENTRY_BASE_LORE = ListKey.of("entries.pokemon.base.lore.base", Lists.newArrayList(
			"&7Listing ID: &e{{id}}",
			"&7Seller: &e{{seller}}",
			"",
			"&7Ability: &e{{ability}}",
			"&7Gender: &e{{gender}}",
			"&7Nature: &e{{nature}}",
			"&7Size: &e{{growth}}"
	));
	public static final ConfigKey<List<String>> POKEMON_ENTRY_BASE_MEW_CLONES = ListKey.of("entries.pokemon.base.lore.mew-clones", Lists.newArrayList(
			"&7Clones: &e{{clones}}"
	));
	public static final ConfigKey<String> POKEMON_ENTRY_CONFIRM_TITLE = StringKey.of("entries.pokemon.confirm.title", "&ePurchase {{pokemon}}?");
	public static final ConfigKey<List<String>> POKEMON_ENTRY_CONFIRM_LORE = ListKey.of("entries.pokemon.confirm.lore", Lists.newArrayList(
			"&7Here's some additional info:",
			"&7EVs: &e{{evs_total}}&7/&e510 &7(&a{{evs_percent}}&7)",
			"&7IVs: &e{{ivs_total}}&7/&e186 &7(&a{{ivs_percent}}&7)",
			"",
			"&7Move Set:",
			"  &7 - &e{{moves_1}}",
			"  &7 - &e{{moves_2}}",
			"  &7 - &e{{moves_3}}",
			"  &7 - &e{{moves_4}}"
	));

	// Error messages
	public static final ConfigKey<String> NOT_ENOUGH_FUNDS = StringKey.of("purchase.not-enough-funds", "&cUnfortunately, you were unable to afford the price of {{price}}");
	public static final ConfigKey<String> ALREADY_CLAIMED = StringKey.of("purchase.already-claimed", "&cUnfortunately, this listing has already been claimed...");
	public static final ConfigKey<List<String>> ITEM_ENTRY_BASE_LORE = ListKey.of("entries.item.base.lore", Lists.newArrayList(
			"&7Seller: &e{{seller}}"
	));
	public static final ConfigKey<List<String>> ITEM_ENTRY_CONFIRM_LORE = ListKey.of("entries.item.confirm.lore", Lists.newArrayList(
			"&7Seller: &e{{seller}}"
	));
	public static final ConfigKey<String> ITEM_ENTRY_CONFIRM_TITLE = StringKey.of("entries.item.confirm.title", "&ePurchase {{item_title}}?");
	public static final ConfigKey<String> ITEM_ENTRY_BASE_TITLE = StringKey.of("entries.item.base.title", "{{item_title}}");
	public static final ConfigKey<String> ITEM_ENTRY_SPEC_TEMPLATE = StringKey.of("entries.item.spec-template", "{{item_title}}");

	private static Map<String, ConfigKey<?>> KEYS = null;

	public static synchronized Map<String, ConfigKey<?>> getAllKeys() {
		if(KEYS == null) {
			Map<String, ConfigKey<?>> keys = new LinkedHashMap<>();

			try {
				Field[] values = MsgConfigKeys.class.getFields();
				for(Field f : values) {
					if(!Modifier.isStatic(f.getModifiers()))
						continue;

					Object val = f.get(null);
					if(val instanceof ConfigKey<?>)
						keys.put(f.getName(), (ConfigKey<?>) val);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			KEYS = ImmutableMap.copyOf(keys);
		}

		return KEYS;
	}
}
