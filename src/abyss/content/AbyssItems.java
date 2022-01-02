package abyss.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class AbyssItems implements ContentList {
	public static Item abyss, balestenite;

	@Override
	public void load() {
		abyss = new Item("abyss", Color.valueOf("212121")) {{
			cost = 3;
		}};
		balestenite = new Item("balestenite", Color.valueOf("C0A8A6")) {{
			cost = 2;
		}};
	}
}