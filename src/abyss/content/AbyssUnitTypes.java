package abyss.content;

import arc.graphics.Color;
import arc.struct.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.world.meta.*;
import mindustry.gen.*;
import mindustry.ctype.ContentList;
import mindustry.type.*;

public class AbyssUnitTypes implements ContentList {
	public static UnitType antra, karma, kalerbi;

	@Override
	public void load() {
		antra = new UnitType("antra") {{
			health = 250;
			speed = 2f;
			rotateSpeed = speed;
			flying = true;
			constructor = UnitEntity::create;
			range = 30f;
			maxRange = range;
			weapons.add(
				new Weapon() {{
					x = y = 0f;
					reload = 30f;
					mirror = false;
					bullet = new BombBulletType(27f, 30f) {{
						width = height = hitSize * 2f;
						lifetime = 60f;
						keepVelocity = false;
						frontColor = Color.valueOf("2E2E2E");
						backColor = Color.valueOf("1C1C1C");
					}};
				}}
			);
		}};
		karma = new UnitType("karma") {{
			health = 475;
			speed = 1.7f;
			rotateSpeed = speed;
			flying = true;
			constructor = UnitEntity::create;
			range = 120f;
			hitSize = 10f;
			maxRange = range;
			weapons.add(
				new Weapon("abyss-void-mount") {{
					x = 2f;
					y = 0f;
					reload = 60f;
					recoil = 1f;
					bullet = new BasicBulletType(4f, 30f) {{
						width = 9f;
						height = 11f;
						lifetime = 30f;
						splashDamage = 20;
						splashDamageRadius = 32f;
						frontColor = Color.valueOf("2E2E2E");
						backColor = Color.valueOf("1C1C1C");
					}};
				}}
			);
		}};
		kalerbi = new UnitType("kalerbi") {{
			health = 830;
			speed = 1.5f;
			rotateSpeed = speed;
			engineOffset = -2f;
			engineSize = 5f;
			flying = true;
			constructor = UnitEntity::create;
			range = 200f;
			maxRange = range;
			hitSize = 14f;
			weapons.add(
				new Weapon("abyss-void-laser-mount") {{
					x = 5f;
					y = 2.75f;
					reload = 120f;
					recoil = 1.5f;
					bullet = new LaserBulletType() {{
						length = 100f;
						width = 8f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}}; 
				}},
				new Weapon("abyss-void-mount") {{
					x = 3f;
					y = 6f;
					reload = 30f;
					recoil = 0.5f;
					bullet = new BasicBulletType(4f, 30f) {{
						width = 7f;
						height = 9f;
						lifetime = 50f;
						frontColor = Color.valueOf("2E2E2E");
						backColor = Color.valueOf("1C1C1C");
					}};
				}}
			);
		}};
	}
}