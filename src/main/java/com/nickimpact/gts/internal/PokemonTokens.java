package com.nickimpact.gts.internal;

import com.google.common.collect.Maps;
import com.nickimpact.gts.GTS;
import com.nickimpact.gts.api.text.Tokens;
import com.nickimpact.gts.api.text.Translator;
import com.nickimpact.gts.entries.pixelmon.EnumPokemonFields;
import com.nickimpact.gts.entries.pixelmon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import org.spongepowered.api.text.Text;

import java.util.Map;
import java.util.Optional;

/**
 * (Some note will go here)
 *
 * @author NickImpact
 */
public class PokemonTokens {

	private static Map<String, Translator> tokens = Maps.newHashMap();

	static {
		tokens.put("pokemon", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.NAME
		)));
		tokens.put("nickname", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.NICKNAME
		)));
		tokens.put("ability", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.ABILITY
		)));
		tokens.put("gender", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.GENDER
		)));
		tokens.put("nature", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.NATURE
		)));
		tokens.put("growth", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.GROWTH
		)));
		tokens.put("level", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.LEVEL
		)));
		tokens.put("evs_percent", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_PERCENT
		)));
		tokens.put("evs_total", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_TOTAL
		)));
		tokens.put("evhp", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_HP
		)));
		tokens.put("evatk", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_ATK
		)));
		tokens.put("evdef", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_DEF
		)));
		tokens.put("evspatk", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_SPATK
		)));
		tokens.put("evspdef", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_SPDEF
		)));
		tokens.put("evspeed", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_SPEED
		)));
		tokens.put("ivs_percent", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_PERCENT
		)));
		tokens.put("ivs_total", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_TOTAL
		)));
		tokens.put("ivhp", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_HP
		)));
		tokens.put("ivatk", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_ATK
		)));
		tokens.put("ivdef", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_DEF
		)));
		tokens.put("ivspatk", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_SPATK
		)));
		tokens.put("ivspdef", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_SPDEF
		)));
		tokens.put("ivspeed", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_SPEED
		)));
		tokens.put("form", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.FORM
		)));
		tokens.put("shiny", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.SHINY
		)));
		tokens.put("halloween", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.HALLOWEEN
		)));
		tokens.put("roasted", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.ROASTED
		)));
		tokens.put("clones", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.CLONES
		)));
		tokens.put("hidden_power", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.HIDDEN_POWER
		)));
		tokens.put("moves_1", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.MOVES_1
		)));
		tokens.put("moves_2", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.MOVES_2
		)));
		tokens.put("moves_3", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.MOVES_3
		)));
		tokens.put("moves_4", (p, v, m) -> Optional.of(GTS.getInstance().getTextParsingUtils().getPokemonInfo(
				getPokemonFromVariableIfExists(m), EnumPokemonFields.MOVES_4
		)));
		tokens.put("ivs_stat", (p, v, m) -> {
			if(getPokemonFromVariableIfExists(m) != null) {
				return Optional.of(Text.of("IV"));
			}

			return Optional.empty();
		});
		tokens.put("evs_stat", (p, v, m) -> {
			if(getPokemonFromVariableIfExists(m) != null) {
				return Optional.of(Text.of("EV"));
			}

			return Optional.empty();
		});
	}

	public static Map<String, Translator> getTokens() {
		return tokens;
	}

	private static EntityPixelmon getPokemonFromVariableIfExists(Map<String, Object> m) {
		Optional<Object> optPoke = m.values().stream().filter(val -> val instanceof Pokemon || val instanceof EntityPixelmon).findAny();
		if(optPoke.isPresent()) {
			if(optPoke.get() instanceof Pokemon)
				return ((Pokemon) optPoke.get()).getPokemon();

			return (EntityPixelmon) optPoke.get();
		}

		return null;
	}
}
