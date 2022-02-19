package abyss.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.*;

public class AbyssItems implements ContentList {
	public static Item 
		abyss, singularityCore,
		balestenite, kalenium, selemate;
	public static Liquid
		heavyOil, lightOil;

	@Override
	public void load() {
		abyss = new Item("abyss", Color.valueOf("212121")) {{
			cost = 3;
		}};
		singularityCore = new Item("singularity-core", Color.valueOf("212121")) {{
			cost = 4;
		}};

		balestenite = new Item("balestenite", Color.valueOf("C0A8A6")) {{
			cost = 2;
		}};
		kalenium = new Item("kalenium", Color.valueOf("DC8268")) {{
			cost = 5;
		}};
		selemate = new Item("selemate", Color.valueOf("A4A298")) {{
			cost = 4;
			hardness = 3;
		}};

		heavyOil = new Liquid("heavy-oil", Color.valueOf("212121")) {{
			viscosity = 0.9f;
		}};
		lightOil = new Liquid("light-oil", Color.valueOf("989800")) {{
			viscosity = 0.7f;
		}};
	}
}