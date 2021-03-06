package com.nickimpact.gts.entries.pixelmon;

import com.google.common.collect.Lists;
import com.nickimpact.gts.GTS;
import com.nickimpact.gts.api.commands.SpongeCommand;
import com.nickimpact.gts.api.commands.SpongeSubCommand;
import com.nickimpact.gts.api.commands.annotations.CommandAliases;
import com.nickimpact.gts.api.json.Typing;
import com.nickimpact.gts.api.listings.Listing;
import com.nickimpact.gts.api.listings.entries.Entry;
import com.nickimpact.gts.api.listings.pricing.Price;
import com.nickimpact.gts.api.utils.MessageUtils;
import com.nickimpact.gts.configuration.ConfigKeys;
import com.nickimpact.gts.configuration.MsgConfigKeys;
import com.nickimpact.gts.entries.prices.MoneyPrice;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.config.PixelmonItems;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.storage.NbtKeys;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerComputerStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import com.pixelmonmod.pixelmon.util.helpers.SpriteHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.common.item.inventory.util.ItemStackUtil;

import java.util.List;
import java.util.Optional;

/**
 * (Some note will go here)
 *
 * @author NickImpact
 */
@Typing("Pokemon")
public class PokemonEntry extends Entry<Pokemon> {

	public PokemonEntry() {
		super();
	}

	public PokemonEntry(EntityPixelmon pokemon, Price price) {
		this(new Pokemon(pokemon), price);
	}

	public PokemonEntry(Pokemon pokemon, Price price) {
		super(pokemon, price);
	}

	@Override
	public SpongeSubCommand commandSpec(boolean isAuction) {
		return new PokemonSub(isAuction);
	}

	@Override
	public String getSpecsTemplate() {
		return GTS.getInstance().getMsgConfig().get(MsgConfigKeys.POKEMON_ENTRY_SPEC_TEMPLATE);
	}

	@Override
	public String getName() {
		return this.getElement().getPokemon().getName();
	}

	@Override
	public ItemStack baseItemStack(Player player) {
		return getPicture(this.getElement().getPokemon());
	}

	@Override
	public String baseTitleTemplate() {
		return GTS.getInstance().getMsgConfig().get(MsgConfigKeys.POKEMON_ENTRY_BASE_TITLE);
	}

	@Override
	public List<String> baseLoreTemplate(boolean auction) {
		List<String> template = Lists.newArrayList();
		template.addAll(GTS.getInstance().getMsgConfig().get(MsgConfigKeys.POKEMON_ENTRY_BASE_LORE));

		if(this.getElement().getPokemon().getSpecies().equals(EnumPokemon.Mew)) {
			template.addAll(GTS.getInstance().getMsgConfig().get(MsgConfigKeys.POKEMON_ENTRY_BASE_MEW_CLONES));
		}

		if(auction) {
			template.addAll(GTS.getInstance().getMsgConfig().get(MsgConfigKeys.AUCTION_INFO));
		} else {
			template.addAll(GTS.getInstance().getMsgConfig().get(MsgConfigKeys.ENTRY_INFO));
		}

		return template;
	}

	@Override
	public ItemStack confirmItemStack(Player player) {
		return getPicture(this.getElement().getPokemon());
	}

	@Override
	public String confirmTitleTemplate() {
		return GTS.getInstance().getMsgConfig().get(MsgConfigKeys.POKEMON_ENTRY_CONFIRM_TITLE);
	}

	@Override
	public List<String> confirmLoreTemplate() {
		return GTS.getInstance().getMsgConfig().get(MsgConfigKeys.POKEMON_ENTRY_CONFIRM_LORE);
	}

	@Override
	public boolean supportsOffline() {
		return false;
	}

	@Override
	public boolean giveEntry(User user) {
		Optional<PlayerStorage> optStorage = PixelmonStorage.pokeBallManager.getPlayerStorageFromUUID(
				(MinecraftServer) Sponge.getServer(),
				user.getUniqueId()
		);

		if (!optStorage.isPresent())
			return false;

		optStorage.get().addToParty(this.getElement().getPokemon());
		optStorage.get().sendUpdatedList();

		return true;
	}

	@Override
	public boolean doTakeAway(Player player) {
		if(GTS.getInstance().getConfig().get(ConfigKeys.BLACKLISTED_POKEMON).stream().anyMatch(name -> name.equalsIgnoreCase(this.getElement().getPokemon().getName()))){
			return false;
		}

		PlayerStorage ps = PixelmonStorage.pokeBallManager.getPlayerStorage((EntityPlayerMP)player).orElse(null);
		if(ps == null)
			return false;

		ps.recallAllPokemon();
		ps.removeFromPartyPlayer(ps.getPosition(this.getElement().getPokemon().getPokemonId()));
		ps.sendUpdatedList();

		return true;
	}

	private static ItemStack getPicture(EntityPixelmon pokemon) {
		net.minecraft.item.ItemStack item = new net.minecraft.item.ItemStack(PixelmonItems.itemPixelmonSprite);
		NBTTagCompound nbt = new NBTTagCompound();
		String idValue = String.format("%03d", pokemon.baseStats.nationalPokedexNumber);
		if (pokemon.isEgg) {
			switch (pokemon.getSpecies()) {
				case Manaphy:
				case Togepi:
					nbt.setString(NbtKeys.SPRITE_NAME,
					              String.format("pixelmon:sprites/eggs/%s1", pokemon.getSpecies().name.toLowerCase()));
					break;
				default:
					nbt.setString(NbtKeys.SPRITE_NAME, "pixelmon:sprites/eggs/egg1");
					break;
			}
		} else if (pokemon.getIsShiny()) {
			nbt.setString(NbtKeys.SPRITE_NAME, "pixelmon:sprites/shinypokemon/" + idValue + SpriteHelper.getSpriteExtra(pokemon.getSpecies().name, pokemon.getForm()));
		} else {
			nbt.setString(NbtKeys.SPRITE_NAME, "pixelmon:sprites/pokemon/" + idValue + SpriteHelper.getSpriteExtra(pokemon.getSpecies().name, pokemon.getForm()));
		}

		item.setTagCompound(nbt);
		return ItemStackUtil.fromNative(item);
	}

	@CommandAliases({"pokemon", "poke"})
	public class PokemonSub extends SpongeSubCommand {

		private final Text argPos = Text.of("pos");
		private final Text argPrice = Text.of("price");

		private final boolean isAuction;

		public PokemonSub(boolean isAuction) {
			this.isAuction = isAuction;
		}

		@Override
		public CommandElement[] getArgs() {
			return new CommandElement[]{
					GenericArguments.integer(argPos),
					GenericArguments.integer(argPrice)
			};
		}

		@Override
		public Text getDescription() {
			return Text.of("Handles pokemon");
		}

		@Override
		public Text getUsage() {
			return Text.of("/gts sell pokemon <party slot> <price>");
		}

		@Override
		public SpongeCommand[] getSubCommands() {
			return new SpongeCommand[0];
		}

		@Override
		public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
			if(!GTS.getInstance().getConfig().get(ConfigKeys.POKEMON_ENABLED)) {
				throw new CommandException(Text.of("The selling of pokemon is disabled..."));
			}

			if(src instanceof Player) {
				Player player = (Player)src;
				int pos = args.<Integer>getOne(argPos).get() - 1;
				int price = args.<Integer>getOne(argPrice).get();
				if(price <= 0) {
					throw new CommandException(Text.of("Price must be a positive integer!"));
				}

				Optional<PlayerStorage> optStorage = PixelmonStorage.pokeBallManager.getPlayerStorage((EntityPlayerMP)player);
				if(optStorage.isPresent()) {
					PlayerStorage storage = optStorage.get();
					NBTTagCompound nbt = storage.getNBT(storage.getIDFromPosition(pos));
					if(nbt != null) {
						EntityPixelmon pokemon = (EntityPixelmon) PixelmonEntityList.createEntityFromNBT(
								nbt,
								(World) player.getWorld()
						);
						if (storage.countTeam() == 1 && !pokemon.isEgg)
							throw new CommandException(Text.of("You can't sell your last non-egg party member!"));

						Listing.Builder lb = Listing.builder()
								.player(player)
								.entry(new PokemonEntry(pokemon, new MoneyPrice(price)))
								.doesExpire()
								.expiration(GTS.getInstance().getConfig().get(ConfigKeys.LISTING_TIME));

						if(isAuction) {
							lb = lb.auction();
						}

						lb.build();

						return CommandResult.success();
					}

					throw new CommandException(Text.of("Unable to find a pokemon in the specified slot..."));
				}

				MessageUtils.genAndSendErrorMessage(
						"Pixelmon storage Access Error",
						"Unable to locate storage for " + player.getName(),
						"Their UUID: " + player.getUniqueId()
				);
				throw new CommandException(Text.of("Unable to find your party data, this error has been reported"));
			}

			throw new CommandException(Text.of("Only players may use this command..."));
		}
	}
}
