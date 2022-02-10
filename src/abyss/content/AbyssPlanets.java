package abyss.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import abyss.planetgen.*;

public class AbyssPlanets implements ContentList {
	public static Planet selemi, arbine;

	@Override
	public void load() {
		selemi = new Planet("selemi", Planets.sun, 0, 1.5) {{
			bloom = true;
			accessible = false;
			meshLoader = () -> new SunMesh(
				this, 4,
				5, 0.3, 1.7, 1.2, 1,
				1.1f,
				Color.valueOf("F2FFFF"),
				Color.valueOf("DDECED"),
				Color.valueOf("D1E1E3"),
				Color.valueOf("BBCDD0"),
				Color.valueOf("B0C4C7"),
				Color.valueOf("9AB1B5")
			);
			orbitRadius = 150f;
		}};
		arbine = new Planet("arbine", selemi, 3, 1) {{
			generator = new ArbinePlanetGenerator();
			meshLoader = () -> new HexMesh(this, 6);
			atmosphereColor = Color.valueOf("3FC4E4");
			atmosphereRadIn = 0.02f;
			atmosphereRadOut = 0.3f;
			startSector = 30;
			alwaysUnlocked = true;
		}};
	}
}