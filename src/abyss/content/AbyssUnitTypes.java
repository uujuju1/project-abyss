package abyss.content;

import arc.graphics.Color;
import arc.struct.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.abilities.*;
import mindustry.world.meta.*;
import mindustry.gen.*;
import mindustry.ctype.ContentList;
import mindustry.type.*;

import abyss.type.*;
import abyss.type.draw.*;

public class AbyssUnitTypes implements ContentList {
	public static UnitType 
		antra, karma, kalerbi, kodene, tolonia,
		katerni, termina, solanra, deuteria, atomega;

	@Override
	public void load() {
		antra = new UnitType("antra") {{
			health = 250;
			speed = 2f;
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
			engineOffset = 6.5f;
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
			rotateSpeed = 1.9f;
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
			rotateSpeed = 1f;
			engineSize = 8f;
			engineOffset = 8f;
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
					bullet = new ContinuousLaserBulletType() {{
						maxRange = range;
						damage = 24f;
						length = range;
						drawSize = 200f;
						lifetime = 60f;
						shake = 1f;
						width = 6f;
						largeHit = true;
						incendChance = 0.03f;
						incendSpread = 5f;
						incendAmount = 1;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}},
				new Weapon("abyss-void-laser-weapon") {{
					x = 9.5f;
					y = -11f;
					reload = 120f;
					recoil = 4f;
					bullet = new ContinuousLaserBulletType() {{
						maxRange = range;
						damage = 24f;
						length = range;
						drawSize = 200f;
						lifetime = 60f;
						shake = 1f;
						width = 6f;
						largeHit = true;
						incendChance = 0.03f;
						incendSpread = 5f;
						incendAmount = 1;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}}
			);
		}};

		katerni = new RotorUnitType("katerni") {{
			health = 200;
			speed = 1.8f;
			range = 120f;
			maxRange = range;
			hitSize = 8f;

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = 0f;
					y = 5f;
					s = 20f;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-mount") {{
					x = 5f;
					y = 8f;
					reload = 30f;
					recoil = 1f;
					bullet = new BasicBulletType(4f, 15) {{
						lifetime = 30f;
						width = 7f;
						height = 9f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-mount") {{
					x = 3f;
					y = 10f;
					reload = 30f;
					recoil = 1f;
					bullet = new MissileBulletType(6f, 20) {{
						lifetime = 20f;
						width = 7f;
						height = 9f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}}
			);
		}};
		termina = new RotorUnitType("termina") {{
			health = 530;
			speed = 1.7f;
			range = 200f;
			lowAltitude = false;
			maxRange = range;
			hitSize = 10f;

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = 0f;
					y = 4f;
					s = 20f;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-mount") {{
					x = 3f;
					y = 12f;
					reload = 10f;
					recoil = 0.5f;
					bullet = new BasicBulletType(4f, 25) {{
						lifetime = 50f;
						width = 7f;
						height = 9f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-missile-mount") {{
					x = 5.75f;
					y = 6f;
					reload = 60f;
					recoil = 2f;
					bullet = new LaserBulletType(30) {{
						width = 6f;
						length = 200f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}},
				new Weapon() {{
					x = y = 0f;
					reload = 180f;
					recoil = 0f;
					mirror = false;
					bullet = new MissileBulletType(8f, 180) {{
						width = 14f;
						height = 20f;
						shootEffect = Fx.none;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}}
			);
		}};
		solanra = new RotorUnitType("solanra") {{
			health = 960;
			speed = 1.6f;
			range = 276f;
			maxRange = range;
			hitSize = 16f;
			lowAltitude = false;

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = 0f;
					y = 7f;
					s = 20f;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-mount") {{
					x = 3f;
					y = 19f;
					reload = 10f;
					recoil = 0.5f;
					bullet = new BasicBulletType(4f, 50) {{
						width = 8f;
						height = 10f;
						lifetime = 69f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-mount") {{
					x = 9.5f;
					y = 10f;
					reload = 10f;
					recoil = 0.5f;
					bullet = new BasicBulletType(4f, 50) {{
						width = 8f;
						height = 10f;
						lifetime = 69f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-missile-mount") {{
					x = 7.25f;
					y = 16f;
					reload = 30f;
					recoil = 1f;
					bullet = new LaserBulletType(60) {{
						width = 8f;
						length = 276f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}},
				new Weapon("abyss-copter-big-mount") {{
					x = 10f;
					y = 2f;
					reload = 120f;
					recoil = 2f;
					bullet = new MissileBulletType(6f, 100) {{
						lifetime = 60f;
						width = 10f;
						height = 12f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}}; 
				}}
			);
			weapons.add(
				new Weapon() {{
					x = y = 0f;
					reload = 240f;
					recoil = 0f;
					bullet = new MissileBulletType(8f, 200) {{
						lifetime = 35f;
						width = 12f;
						height = 18f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}}
			);
		}};
		deuteria = new RotorUnitType("deuteria") {{
			health = 6540;
			speed = 1.5f;
			range = 300f;
			maxRange = range;
			hitSize = 22f;

			abilities.add(
				new UnitSpawnAbility(katerni, 60f * 60f, 0f, -20f)
			);

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = 0f;
					y = 4f;
					s = 20f;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-mount") {{
					x = 3f;
					y = 23f;
					reload = 10f;
					recoil = 0.5f;
					bullet = new BasicBulletType(4f, 50) {{
						width = 8f;
						height = 10f;
						lifetime = 75f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-missile-mount") {{
					x = 3.75f;
					y = 17f;
					reload = 10f;
					recoil = 1f;
					bullet = new MissileBulletType(6f, 75) {{
						width = 9f;
						height = 11f;
						lifetime = 50f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-big-mount") {{
					x = 6f;
					y = 3f;
					reload = 30f;
					recoil = 2f;
					bullet = new LaserBulletType(120) {{
						width = 10f;
						length = 300f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}},
				new Weapon("abyss-copter-missile-mount") {{
					x = 12f;
					y = -3f;
					reload = 10f;
					recoil = 1f;
					bullet = new LaserBulletType(50) {{
						width = 10f;
						length = 300f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}}
			);
			weapons.add(
				new Weapon() {{
					x = y = 0f;
					reload = 120f;
					recoil = 0f;
					bullet = new MissileBulletType(8f, 300) {{
						lifetime = 45f;
						width = 12f;
						height = 18f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}}
			);
		}};
		atomega = new RotorUnitType("atomega") {{
			health = 22000;
			speed = 1.5f;
			range = 360f;
			maxRange = range;
			hitSize = 28f;

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = 0f;
					y = 12f;
					s = 25f;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-big-mount") {{
					x = 16f;
					y = 0f;
					reload = 30f;
					recoil = 2f;
					bullet = new MissileBulletType(6f, 100) {{
						lifetime = 60f;
						width = 10f;
						height = 12f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-big-mount") {{
					x = 5f;
					y = -1.5f;
					reload = 60f;
					recoil = 2f;
					bullet = new LaserBulletType(150) {{
						width = 8f;
						length = 360f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}},
				new Weapon("abyss-copter-big-mount") {{
					x = 0f;
					y = -30f;
					reload = 10f;
					mirror = false;
					recoil = 2f;
					bullet = new BasicBulletType(4f, 100) {{
						lifetime = 90f;
						width = 8f;
						height = 10f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}}
			);
			weapons.add(
				new Weapon("abyss-copter-missile-mount") {{
					x = 12f;
					y = 24f;
					reload = 5f;
					recoil = 0.5f;
					bullet = new BasicBulletType(4f, 50) {{
						lifetime = 90f;
						width = 7f;
						height = 9f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-missile-mount") {{
					x = y = 16f;
					reload = 5f;
					recoil = 0.5f;
					bullet = new BasicBulletType(4f, 50) {{
						lifetime = 90f;
						width = 7f;
						height = 9f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon() {{
					x = y = 0f;
					reload = 360f;
					mirror = false;
					recoil = 0;
					bullet = new MissileBulletType(8f, 400) {{
						lifetime = 50f;
						width = 14f;
						height = 20f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}}
			);
		}};
	}
}