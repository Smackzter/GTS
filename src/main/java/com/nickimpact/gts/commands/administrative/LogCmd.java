package com.nickimpact.gts.commands.administrative;

import com.nickimpact.gts.api.commands.annotations.AdminCmd;
import com.nickimpact.gts.api.commands.annotations.CommandAliases;
import com.nickimpact.gts.api.commands.SpongeCommand;
import com.nickimpact.gts.api.commands.SpongeSubCommand;
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
@CommandAliases({"logs"})
public class LogCmd extends SpongeSubCommand {

	@Override
	public CommandElement[] getArgs() {
		return new CommandElement[0];
	}

	@Override
	public Text getDescription() {
		return Text.of();
	}

	@Override
	public Text getUsage() {
		return Text.of("/gts admin logs <target>");
	}

	@Override
	public SpongeCommand[] getSubCommands() {
		return new SpongeCommand[0];
	}

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		return CommandResult.success();
	}
}
