package abyss.content;

import mindustry.ctype.ContentList;
import mindustry.type.StatusEffect;

public class AbyssStatusEffects implements ContentList {
	public static StatusEffect kaleminite;

	@Override
	public void load() {
		kaleminite = new StatusEffect("kaleminite") {{
			healthMultiplier = 0.8;
			speedMultiplier = 0.8;
		}};
	}
}