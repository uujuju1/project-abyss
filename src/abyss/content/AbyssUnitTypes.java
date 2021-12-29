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
	public static UnitType antra, karma, kalerbi, kodene, tolonia;

	@Override
	public void load() {
		antra = new UnitType("antra") {{
			health = 250;
			speed = 2f;
			rotateSpeed = 0.4f;
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
			rotateSpeed = 0.3f;
			engineOffset = 0.3f;
			flying = true;
			constructor = UnitEntity::create;
			range = 120f;
			hitSize = 9f;
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
			speed = 1.4f;
			rotateSpeed = 0.2f;
			engineOffset = 0.5f;
			engineSize = 5f;
			flying = true;
			constructor = UnitEntity::create;
			range = 200f;
			maxRange = range;
			hitSize = 12f;
			weapons.add(
				new Weapon("abyss-void-laser-mount") {{
					x = 5f;
					y = -2.75f;
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
		kodene = new UnitType("kodene") {{
			health = 4000;
			speed = 1f;
			rotateSpeed = 0.1f;
			engineSize = 6f;
			engineOffset = -1.7f;
			flying = true;
			constructor = UnitEntity::create;
			range = 280f;
			maxRange = range;
			hitSize = 28f;
			weapons.add(
				new Weapon("abyss-void-missile-mount") {{
					x = 7.25f;
					y = -8.75f;
					reload = 240f;
					recoil = 4f;
					bullet = new MissileBulletType(4f, 200f) {{
						width = 21f;
						height = 27f;
						lifetime = 70f;
						splashDamage = 75f;
						splashDamageRadius = 32f;
						frontColor = Color.valueOf("2E2E2E");
						backColor = Color.valueOf("1C1C1C");
					}};
				}},
				new Weapon("abyss-void-artillery-mount") {{
					x = 5.5f;
					y = 8f;
					reload = 30f;
					recoil =2f;
					bullet = new ArtilleryBulletType(4f, 75f) {{
						width = height = 16f;
						maxRange = 70f;
						splashDamage = 75f;
						splashDamageRadius = 32f;
						frontColor = Color.valueOf("2E2E2E");
						backColor = Color.valueOf("1C1C1C");
					}};
				}}
			);
		}};
		tolonia = new UnitType("tolonia") {{
			health = 22000;
			speed = 0.5f;
			rotateSpeed = 0.01f;
			engineSize = 8f;
			engineOffset = -1.7f;
			flying = true;
			constructor = UnitEntity::create;
			range = 320f;
			maxRange = range;
			hitSize = 36f;
			weapons.add(
				new Weapon("abyss-void-artillery-mount") {{
					x = 5f;
					y = 10f;
					reload = 10f;
					recoil = 3f;
					bullet = new BasicBulletType(6f, 100f) {{
						width = height = 16f;
						lifetime = 53f;
						frontColor = Color.valueOf("2E2E2E");
						backColor = Color.valueOf("1C1C1C");
					}};
				}},
				new Weapon("abyss-void-laser-weapon") {{
					x = 14f;
					y = 5f;
					alternate = true;
					reload = 120f;
					recoil = 4f;
					bullet = new ContinuousLaserBulletType(24f) {{
						length = maxRange;						
						lifetime = 60f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}},
				new Weapon("abyss-void-laser-weapon") {{
					x = 9.5f;
					y = -11f;
					reload = 120f;
					recoil = 4f;
					bullet = new ContinuousLaserBulletType(24f) {{
						length = maxRange;
						lifetime = 60f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}}
			);
		}};
	}
}