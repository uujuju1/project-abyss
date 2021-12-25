package abyss.content;

import arc.graphics.Color;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.ctype.ContentList;
import mindustry.type.*;

public class AbyssUnitTypes implements ContentList {
	public static UnitType antra;

	@Override
	public void load() {
		antra = new UnitType("antra") {{
			health = 250;
			speed = 2f;
			rotateSpeed = 4f;
			flying = true;
			constructor = UnitEntity::create;
		}};
	}
}