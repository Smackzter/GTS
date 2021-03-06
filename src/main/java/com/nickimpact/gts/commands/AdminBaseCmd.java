package com.nickimpact.gts.commands;

import com.nickimpact.gts.api.commands.annotations.AdminCmd;
import com.nickimpact.gts.api.commands.annotations.CommandAliases;
import com.nickimpact.gts.api.commands.SpongeCommand;
import com.nickimpact.gts.api.commands.SpongeSubCommand;
import com.nickimpact.gts.commands.administrative.ClearCmd;
import com.nickimpact.gts.commands.administrative.EditCmd;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

/**
 * (Some note will go here)
 *
 * @author NickImpact
 */
@AdminCmd
@CommandAliases({"admin"})
public class AdminBaseCmd extends SpongeSubCommand {

	@Override
	public CommandElement[] getArgs() {
		return new CommandElement[0];
	}

	@Override
	public Text getDescription() {
		return Text.of("The administrative bridge for GTS");
	}

	@Override
	public Text getUsage() {
		return Text.of("/gts admin <clear/edit>");
	}

	@Override
	public SpongeCommand[] getSubCommands() {
		return new SpongeCommand[]{
				new ClearCmd(),
				new EditCmd()
		};
	}

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		throw new CommandException(Text.of("/gts admin requires a specific action"));
	}
}
