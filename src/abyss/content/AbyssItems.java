package abyss.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class AbyssItems implements ContentList {
	public static Item abyss;

	@Override
	public void load() {
		abyss = new Item("abyss", Color.valueOf("212121")) {{
			cost = 3;
		}};
	}
}