package abyss.content;

import mindustry.world.blocks.environment.*;
import mindustry.ctype.ContentList;
import abyss.content.*;

public class AbyssEnvironment implements ContentList {
	public static Floor granite, calcarium;
	public static OreBlock oreSelemate;

	@Override
	public void load() {
		oreSelemate = new OreBlock(AbyssItems.selemate) {{
			oreThreshold = 0.846f;
			oreScale = 24.428572f;
		}};

		granite = new Floor("granite") {{}};
		calcarium = new Floor("calcarium") {{}};
	}
}