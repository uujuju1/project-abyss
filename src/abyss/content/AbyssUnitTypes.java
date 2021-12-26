package abyss.content;

import arc.graphics.Color;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.world.meta.*;
import mindustry.gen.*;
import mindustry.ctype.ContentList;
import mindustry.type.*;

public class AbyssUnitTypes implements ContentList {
	public static UnitType antra;

	@Override
	public void load() {
		antra = new UnitType("antra") {{
			health = 250;
			speed = 2f;
			rotateSpeed = 8f;
			flying = true;
			constructor = UnitEntity::create;
			range = 30f;
			maxRange = range;
			weapons.add(
				new Weapon() {{
					x = y = 0f;
					reloadTime = 30f;
					mirror = false;
					shootSound = Sounds.plasmaBoom;
					bullet = new BombBulletType(27f, 30f) {{
						width = height = hitSize * 2f;
						lifetime = 60f;
						frontColor = Color.valueOf("2E2E2E");
						backColor = Color.valueOf("1C1C1C");
					}};
				}}
			);
		}};
		karma = new UnitType("karma") {{
			health = 475;
			speed = 1.7f;
			rotateSpeed = 7f;
			flying = true;
			constructor = UnitEntity::create;
			range = 120f;
			maxRange = range;
			weapons.add(
				new Weapon("void-mount") {{
					x = 2f;
					y = 0f;
					reload = 60f;
					recoil = 1f;
					bullet = new BasicBulletType(4f, 30f) {{
						width = 9f;
						height = 11f;
						lifetime = 30f;
						frontColor = Color.valueOf("2E2E2E");
						backColor = Color.valueOf("1C1C1C");
					}};
				}}
			);
		}};
	}
}