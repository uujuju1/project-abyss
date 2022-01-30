package abyss.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class AbyssItems implements ContentList {
	public static Item 
		abyss, darkPowder,
		balestenite, kalenium, selemate;

	@Override
	public void load() {
		abyss = new Item("abyss", Color.valueOf("212121")) {{
			cost = 3;
		}};
		darkPowder = new Item("dark-powder", Color.valueOf("212121")) {{
			cost = 3;
		}}

		balestenite = new Item("balestenite", Color.valueOf("C0A8A6")) {{
			cost = 2;
		}};
		kalenium = new Item("kalenium", Color.valueOf("DC8268")) {{
			cost = 5;
		}};
		selemate = new Item("selemate", Color.valueOf("A4A298")) {{
			cost = 4;
		}};
	}
}