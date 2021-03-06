package com.nickimpact.gts.configuration;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.nickimpact.gts.api.configuration.ConfigKey;
import com.nickimpact.gts.api.configuration.keys.*;
import com.nickimpact.gts.storage.StorageCredentials;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * (Some note will go here)
 *
 * @author NickImpact
 */
public class ConfigKeys {

	//------------------------------------------------------------------------------------------------------------------
	// General config settings
	//------------------------------------------------------------------------------------------------------------------

	/** Default time = 1 minute = 60 seconds */
	public static final ConfigKey<Integer> AUC_TIME = IntegerKey.of("auctions.default-time", 60);

	/** Max time = 5 minutes = 300 seconds */
	public static final ConfigKey<Integer> AUC_MAX_TIME = IntegerKey.of("auctions.max-time", 300);

	/** Default time = 1 hour = 60 minutes = 3600 seconds */
	public static final ConfigKey<Integer> LISTING_TIME = IntegerKey.of("listings.listing-time", 60 * 60);

	/** Max time = 12 hours = 720 minutes = 43,200 seconds */
	public static final ConfigKey<Integer> LISTING_MAX_TIME = IntegerKey.of("listings.listing-max-time", 720 * 60);

	/** The max number of listings a player can have in the GTS */
	public static final ConfigKey<Integer> MAX_LISTINGS = IntegerKey.of("listings.listings-max", 5);

	/** Whether or not taxes should be applied on listing entries */
	public static final ConfigKey<Boolean> TAX_ENABLED = BooleanKey.of("tax.enabled", false);
	public static final ConfigKey<Double> TAX_MONEY_TAX = DoubleKey.of("tax.money.tax", 0.08);

	public static final ConfigKey<Boolean> ITEMS_ENABLED = BooleanKey.of("entries.items.enabled", true);
	public static final ConfigKey<Boolean> POKEMON_ENABLED = BooleanKey.of("entries.pokemon.enabled", true);

	public static final ConfigKey<Boolean> CUSTOM_NAME_ALLOWED = BooleanKey.of("entries.items.custom-names-allowed", true);


	//------------------------------------------------------------------------------------------------------------------
	// Blacklist config settings
	//------------------------------------------------------------------------------------------------------------------
	public static final ConfigKey<List<String>> BLACKLISTED_POKEMON = ListKey.of("blacklist.pokemon", Lists.newArrayList());
	public static final ConfigKey<List<String>> BLACKLISTED_ITEMS = ListKey.of("blacklist.items", Lists.newArrayList());

	//------------------------------------------------------------------------------------------------------------------
	// Storage-based config settings
	//------------------------------------------------------------------------------------------------------------------

	/** Which storage type to use */
	public static final ConfigKey<String> STORAGE_METHOD = StringKey.of("storage.storage-method", "h2");

	/** Represents the credentials for logging into a database storage type */
	public static final ConfigKey<StorageCredentials> DATABASE_VALUES = EnduringKey.wrap(AbstractKey.of(c -> new StorageCredentials(
			c.getString("storage.data.address", null),
			c.getString("storage.data.database", null),
			c.getString("storage.data.username", null),
			c.getString("storage.data.password", null)
	)));

	/** The table prefix for the main SQL tables */
	public static final ConfigKey<String> SQL_TABLE_PREFIX = EnduringKey.wrap(StringKey.of("storage.data.table_prefix", "gts_"));

	private static Map<String, ConfigKey<?>> KEYS = null;

	public static synchronized Map<String, ConfigKey<?>> getAllKeys() {
		if(KEYS == null) {
			Map<String, ConfigKey<?>> keys = new LinkedHashMap<>();

			try {
				Field[] values = ConfigKeys.class.getFields();
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
