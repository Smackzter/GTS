package com.nickimpact.gts.commands.basic;

import com.google.common.collect.Lists;
import com.nickimpact.gts.GTS;
import com.nickimpact.gts.api.commands.annotations.CommandAliases;
import com.nickimpact.gts.api.commands.SpongeCommand;
import com.nickimpact.gts.api.commands.SpongeSubCommand;
import com.nickimpact.gts.api.commands.annotations.Parent;
import com.nickimpact.gts.api.json.Registry;
import com.nickimpact.gts.api.listings.entries.Entry;
import com.nickimpact.gts.api.utils.MessageUtils;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

import java.util.List;
import java.util.Map;

/**
 * (Some note will go here)
 *
 * @author NickImpact
 */
@Parent
@CommandAliases({"sell", "add"})
public class SellCmd extends SpongeSubCommand {

	public static List<SpongeSubCommand> children = Lists.newArrayList();

	@Override
	public CommandElement[] getArgs() {
		return null;
	}

	@Override
	public Text getDescription() {
		return Text.of("Adds a listing to the market");
	}

	@Override
	public Text getUsage() {
		return Text.of("/gts sell <type>");
	}

	@SuppressWarnings("unchecked")
	@Override
	public SpongeCommand[] getSubCommands() {
		AucCmd.getEntryCommandSpecs(children, false);
		return children.toArray(new SpongeSubCommand[children.size()]);
	}

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		return CommandResult.empty();
	}
}
