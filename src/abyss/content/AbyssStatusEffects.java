package abyss.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.StatusEffect;

public class AbyssStatusEffects implements ContentList {
	public static StatusEffect kaleminite;

	@Override
	public void load() {
		kaleminite = new StatusEffect("kaleminite") {{
			healthMultiplier = 0.8f;
			speedMultiplier = 0.8f;
			color = Color.valueOf("DB4543");
		}};
	}
}