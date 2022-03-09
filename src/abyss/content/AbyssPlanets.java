package abyss.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import abyss.planets.*;

public class AbyssPlanets implements ContentList {
	public static Planet galemite;

	@Override
	public void load() {
		galemite = new Planet("galemite", sun, 3, 1) {{
			generator = new GalemitePlanetGenerator();
			meshLoader = () -> new HexMesh(this, 6);
			atmosphereColor = Color.valueOf("3c1b8f");
			atmosphereRadIn = 0.02f;
			atmosphereRadOut = 0.3f;
			startSector = 15;
			alwaysUnlocked = true;
		}};
	}
}