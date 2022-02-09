package abyss.content;

import arc.graphics.Color;
import arc.struct.*;
import mindustry.graphics.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.abilities.*;
import mindustry.world.meta.*;
import mindustry.gen.*;
import mindustry.ctype.ContentList;
import mindustry.type.*;

import abyss.entities.abilities.*;
import abyss.type.weapons.*;
import abyss.graphics.*;
import abyss.type.*;
import abyss.type.draw.*;

public class AbyssUnitTypes implements ContentList {
	public static UnitType 
		antra, karma, kalerbi, kodene, tolonia,
		katerni, termina, solanra, deuteria, atomega,
		saloni, alerbite, laminite, almone, aracnophobia,
		solenopsis, cricetiae, oryctolagus, carcharodon, orcinus;

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
					shootSound = Sounds.plasmadrop;
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
					shootSound = Sounds.laser;
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
					shootSound = Sounds.missile;
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
					recoil = 2f;
					shootSound = Sounds.artillery;
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
					shootSound = Sounds.shootBig;
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
					shootSound = Sounds.laserbig;
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
					shootSound = Sounds.laserbig;
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
					y = 4f;
					s = 20f;
					elevation = visualElevation;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-mount") {{
					x = 4.75f;
					y = 3.5f;
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
					x = 1.5f;
					y = 9.5f;
					reload = 30f;
					recoil = 1f;
					alternate = true;
					shootSound = Sounds.missile;
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
					elevation = visualElevation;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-mount") {{
					x = 6.75f;
					y = 4.5f;
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
				new Weapon("abyss-copter-mount") {{
					x = 4.75f;
					y = 6.5f;
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
					y = -0.5f;
					reload = 60f;
					recoil = 2f;
					alternate = true;
					shootSound = Sounds.laser;
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
					shootSound = Sounds.artillery;
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
					y = 10f;
					s = 20f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = 0f;
					y = -10f;
					s = 20f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = 9f;
					y = -1f;
					s = -20f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = -9f;
					y = -1f;
					s = -20f;
					elevation = visualElevation;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-missile-mount") {{
					x = 4f;
					y = -7f;
					reload = 30f;
					recoil = 1f;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(4f, 40) {{
						width = 7f;
						height = 9f;
						lifetime = 69f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-missile-mount") {{
					x = 4.25f;
					y = 8f;
					reload = 30f;
					recoil = 1f;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(4f, 40) {{
						width = 7f;
						height = 9f;
						lifetime = 69f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-big-mount") {{
					x = 6f;
					y = 0f;
					reload = 120f;
					recoil = 3f;
					shootSound = Sounds.artillery;
					bullet = new ArtilleryBulletType(2f, 75) {{
						width = height = 10f;
						lifetime = 138f;
						range = 276f;
						splashDamage = 75;
						splashDamageRadius = 32f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon() {{
					x = y = 0f;
					reload = 180f;
					recoil = 0f;
					shootSound = Sounds.shootBig;
					bullet = new MissileBulletType(8f, 150) {{
						width = 14f;
						height = 18f;
						lifetime = 80f;
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

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = 11.5f;
					y = 2.75f;
					s = 20f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = -11.5f;
					y = 2.75f;
					s = 20f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = 11.5f;
					y = 2.75f;
					s = -20f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = -11.5f;
					y = 2.75f;
					s = -20f;
					elevation = visualElevation;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-missile-mount") {{
					x = 13.25f;
					y = 11f;
					reload = 30f;
					recoil = 1f;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(4f, 80) {{
						width = 7f;
						height = 9f;
						lifetime = 75f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-missile-mount") {{
					x = 3.5f;
					y = 15f;
					reload = 30f;
					recoil = 1f;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(4f, 80) {{
						width = 7f;
						height = 9f;
						lifetime = 75f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon("abyss-copter-spark-mount") {{
					x = 5f;
					y = 5f;
					reload = 5f;
					recoil = 2f;
					shootSound = Sounds.spark;
					bullet = new LightningBulletType() {{
						lightningLengthRand = 1;
						damage = 70;
					}};
				}},
				new Weapon() {{
					x = y = 0f;
					reload = 240f;
					recoil = 0f;
					shootSound = Sounds.artillery;
					bullet = new MissileBulletType(8f, 400) {{
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

			rotors.addAll(
				new DrawRotor(name + "-rotor") {{
					x = 15.75f;
					y = 10f;
					s = 25f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = 15.75f;
					y = 10f;
					s = -25f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = -15.75f;
					y = 10f;
					s = 25f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = -15.75f;
					y = 10f;
					s = -25f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = 0f;
					y = -10f;
					s = 25f;
					elevation = visualElevation;
				}},
				new DrawRotor(name + "-rotor") {{
					x = 0f;
					y = -10f;
					s = -25f;
					elevation = visualElevation;
				}}
			);

			weapons.add(
				new Weapon("abyss-copter-spark-mount") {{
					x = 16f;
					y = 0f;
					reload = 30f;
					recoil = 2f;
					shootSound = Sounds.laser;
					bullet = new LaserBulletType(200) {{
						width = 8f;
						length = 360f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}},
				new Weapon("abyss-copter-spark-mount") {{
					x = 5f;
					y = 9f;
					reload = 60f;
					recoil = 2f;
					shootSound = Sounds.laser;
					bullet = new LaserBulletType(200) {{
						width = 8f;
						length = 360f;
						colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
					}};
				}},
				new Weapon("abyss-copter-big-mount") {{
					x = 7f;
					y = -1.5f;
					reload = 30f;
					recoil = 2f;
					shots = 4;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(4f, 50) {{
						lifetime = 90f;
						width = 8f;
						height = 10f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}},
				new Weapon() {{
					x = y = 0f;
					reload = 360f;
					mirror = false;
					recoil = 0;
					shootSound = Sounds.artillery;
					bullet = new MissileBulletType(8f, 400) {{
						lifetime = 60f;
						width = 14f;
						height = 20f;
						frontColor = Color.valueOf("ffffff");
						backColor = Color.valueOf("B0B0B0");
					}};
				}}
			);
		}};

		saloni = new RotorUnitType("saloni") {{
			health = 220;
			speed = 1.5f;
			range = 100f;
			flying = false;
			maxRange = range;
			constructor = LegsUnit::create;

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = y = 0f;
					s = 1f;
					drawJoint = false;
					drawShadow = false;
					bladeCount = 3;
					elevation = visualElevation;
				}}
			);

			abilities.add(new ReflectiveAbility(15, 80, 60, true, true, AbyssFx.terreniumExplosion));

			weapons.add(
				new Weapon("abyss-terrenium-mount") {{
					x = 1.5f;
					y = 1f;
					reload = 30f;
					recoil = 1f;
					flipSprite = true;
					bullet = new BasicBulletType(4f, 15) {{
						width = 7f;
						height = 9f;
						lifetime = 25f;
					}};
				}}
			);
		}};
		alerbite = new RotorUnitType("alerbite") {{
			health = 530;
			speed = 1.3f;
			range = 130f;
			maxRange = range;
			flying = false;
			constructor = LegsUnit::create;
			hitSize = 10f;

			legCount = 6;
			legGroupSize = 3;
			legLength = 12f;

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = y = 0f;
					s = 1f;
					drawJoint = false;
					drawShadow = false;
					bladeCount = 6;
					elevation = visualElevation;
				}}
			);

			abilities.add(new ReflectiveAbility(20, 80, 60, true, true, AbyssFx.terreniumExplosion));

			weapons.add(
				new Weapon("abyss-terrenium-mount") {{
					x = 3.25f;
					y = 3f;
					reload = 30f;
					recoil = 1f;
					flipSprite = true;
					bullet = new BasicBulletType(4f, 20) {{
						width = 7f;
						height = 9f;
						lifetime = 32.5f;
					}};
				}},
				new Weapon("abyss-terrenium-mount") {{
					x = 5f;
					y = -3f;
					reload = 30f;
					recoil = 2f;
					flipSprite = true;
					alternate = true;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(6f, 30) {{
						width = 7f;
						height = 9f;
						lifetime = 32f;
					}};
				}}
			);
		}};
		laminite = new RotorUnitType("laminite") {{
			health = 950;
			speed = 1f;
			range = 180f;
			maxRange = range;
			flying = false;
			constructor = LegsUnit::create;
			hitSize = 12.5f;

			legLength = 16f;

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = y = 0f;
					s = 1f;
					drawJoint = false;
					drawShadow = false;
					bladeCount = 8;
					elevation = visualElevation;
				}}
			);

			abilities.add(new ReflectiveAbility(30, 80, 60, true, true, AbyssFx.terreniumExplosion));

			weapons.add(
				new Weapon("abyss-terrenium-artillery") {{
					x = 7f;
					y = -3f;
					reload = 60f;
					recoil = 3f;
					shootSound = Sounds.artillery;
					bullet = new ArtilleryBulletType(2f, 50) {{
						width = height = 10f;
						lifetime = 90f;
						range = range;
						splashDamage = 50;
						splashDamageRadius = 32f;
					}};
				}},
				new Weapon("abyss-terrenium-mount") {{
					x = 5f;
					y = 6f;
					reload = 10f;
					recoil = 1f;
					bullet = new BasicBulletType(4f, 20) {{
						width = 7f;
						height = 9f;
						lifetime = 22.5f;
					}};
				}},
				new Weapon("abyss-terrenium-mount") {{
					x = 3f;
					y = -8.75f;
					reload = 30f;
					recoil = 2f;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(6f, 30) {{
						width = 7f;
						height = 9f;
						lifetime = 20f;
					}};
				}}
			);
		}};
		almone = new RotorUnitType("almone") {{
			health = 7000;
			speed = 0.7f;
			range = 240f;
			maxRange = range;
			flying = false;
			constructor = LegsUnit::create;
			hitSize = 22f;

			legCount = 8;
			legGroupSize = 4;
			legLength = 24f;

			abilities.add(new ReflectiveAbility(45, 80, 60, true, true, AbyssFx.terreniumExplosion));

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = y = 0f;
					s = 1f;
					drawJoint = false;
					drawShadow = false;
					bladeCount = 5;
					elevation = visualElevation;
				}}
			);

			weapons.add(
				new Weapon("abyss-terrenium-laser") {{
					x = 14f;
					y = 12f;
					reload = 120f;
					recoil = 3f;
					shootSound = Sounds.laser;
					bullet = new LaserBulletType(120) {{
						length = 240f;
						width = 8f;
					}};
				}},
				new Weapon("abyss-terrenium-artillery") {{
					x = 5f;
					y = 8.5f;
					reload = 15f;
					recoil = 3f;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(2f, 70) {{
						width = height = 10f;
						lifetime = 90f;
						splashDamage = 50;
						splashDamageRadius = 32f;
					}};
				}},
				new Weapon("abyss-terrenium-artillery") {{
					x = 11f;
					y = 0f;
					reload = 15f;
					recoil = 3f;
					alternate = true;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(2f, 70) {{
						width = height = 10f;
						lifetime = 90f;
						splashDamage = 50;
						splashDamageRadius = 32f;
					}};
				}},
				new Weapon("abyss-terrenium-artillery") {{
					x = 10f;
					y = -10f;
					reload = 30f;
					recoil = 3f;
					shootSound = Sounds.artillery;
					bullet = new ArtilleryBulletType(2f, 80) {{
						width = height = 10f;
						lifetime = 90f;
						range = range;
						splashDamage = 50;
						splashDamageRadius = 32f;
					}};
				}}
			);
		}};
		aracnophobia = new RotorUnitType("aracnophobia") {{
			health = 20000;
			speed = 0.5f;
			range = 300f;
			maxRange = range;
			flying = false;
			constructor = LegsUnit::create;
			hitSize = 32f;

			legCount = 10;
			legGroupSize = 5;
			legLength = 20f;

			abilities.add(new ReflectiveAbility(120, 80, 60, true, true, AbyssFx.terreniumExplosion));

			rotors.add(
				new DrawRotor(name + "-rotor") {{
					x = y = 0f;
					s = 1f;
					drawJoint = false;
					drawShadow = false;
					bladeCount = 7;
					elevation = visualElevation;
				}}
			);

			weapons.add(
				new Weapon("abyss-terrenium-artillery") {{
					x = 7f;
					y = 17f;
					reload = 30f;
					recoil = 1f;
					shootSound = Sounds.missile;
					bullet = new MissileBulletType(6f, 150) {{
						width = 8f;
						height = 10f;
						lifetime = 50f;
					}};
				}},
				new Weapon("abyss-terrenium-artillery") {{
					x = 2f;
					y = 9f;
					reload = 60f;
					recoil = 1f;
					alternate = true;
					shootSound = Sounds.artillery;
					bullet = new ArtilleryBulletType(4f, 200) {{
						width = 8f;
						height = 10f;
						lifetime = 75f;
						range = 300f;
						collides = true;
					}};
				}},
				new Weapon("abyss-terrenium-machinegun") {{
					x = 10f;
					y = 5f;
					reload = 10f;
					recoil = 1f;
					bullet = new BasicBulletType(4f, 70) {{
						width = 8f;
						height = 10f;
						lifetime = 75f;
					}};
				}},
				new Weapon("abyss-terrenium-machinegun") {{
					x = 10f;
					y = -10f;
					reload = 11f;
					recoil = 1f;
					alternate = true;
					bullet = new BasicBulletType(4f, 70) {{
						width = 8f;
						height = 10f;
						lifetime = 75f;
					}};
				}}
			);
		}};

		solenopsis = new UnitType("solenopsis") {{
			health = 250;
			speed = 1f;
			accel = 0.4f;
			drag = 0.14f;
			rotateSpeed = 5f;
			trailScl = 1.3f;
			rotateShooting = true;
			range = 150f;
			maxRange = range;
			hitSize = 8.75f;
			constructor = UnitWaterMove::create;
			weapons.add(
				new Weapon("abyss-solenopsis-mount") {{
					x = 4.25f;
					y = -2.75f;
					reload = 30f;
					recoil = 1f;
					rotate = false;
					bullet = new MissileBulletType(2.5f, 20) {{
						width = height = 6f;
						lifetime = 60f;
						frontColor = Pal.sapBullet;
						backColor = Pal.sapBulletBack;
					}};
				}},
				new Weapon("abyss-solenopsis-sap") {{
					x = 0f;
					y = 4f;
					reload = 30f;
					recoil = 0.5f;
					mirror = false;
					maxRange = 75f;
					rotate = true;
					shootSound = Sounds.sap;
					bullet = new SapBulletType() {{
						length = 75f;
						damage = 9;
						width = 0.6f;
						color = Pal.sap;
					}};
				}}
			);
		}};
		cricetiae = new UnitType("cricetiae") {{
			health = 580;
			speed = 0.83f;
			accel = 0.4f;
			drag = 0.14f;
			rotateSpeed = 4f;
			trailLength = 22;
			trailX = 5.5f;
			trailY = -4f;
			trailScl = 1.9f;
			range = 240f;
			maxRange = range;
			hitSize = 11f;
			constructor = UnitWaterMove::create;
			weapons.add(
				new Weapon("abyss-cricetiae-liquid") {{
					x = 3.5f;
					y = 7f;
					reload = 10f;
					recoil = 0.5f;
					maxRange = 160f;
					rotate = true;
					shootSound = Sounds.flame;
					bullet = new LiquidBulletType(Liquids.slag) {{
						speed = 2f;
						lifetime = 80f;
					}};
				}},
				new Weapon("abyss-cricetiae-artillery") {{
					x = 4.25f;
					y = 0.5f;
					reload = 30f;
					recoil = 1.5f;
					rotate = true;
					shootSound = Sounds.artillery;
					bullet = new ArtilleryBulletType(2f, 35) {{
						width = height = 9f;
						lifetime = 120f;
						frontColor = Pal.sapBullet;
						backColor = Pal.sapBulletBack;
					}};
				}},
				new Weapon("abyss-cricetiae-big") {{
					x = 0f;
					y = -7.25f;
					reload = 60f;
					recoil = 2f;
					rotate = true;
					mirror = false;
					shootSound = Sounds.shootBig;
					bullet = new BasicBulletType(1.5f, 50, "abyss-big-artillery") {{
						width = height = 14f;
						lifetime = 240f;
						fragBullets = 3;
						frontColor = Pal.sapBullet;
						backColor = Pal.sapBulletBack;
						fragBullet = new BasicBulletType(1.5f, 10, "abyss-big-artillery") {{
							width = height = 7f;
							lifetime = 26f;
							frontColor = Pal.sapBullet;
							backColor = Pal.sapBulletBack;
						}};
					}};
				}}
			);
		}};
		oryctolagus = new UnitType("oryctolagus") {{
			health = 900;
			speed = 0.80f;
			accel = 0.4f;
			drag = 0.14f;
			rotateSpeed = 2.5f;
			trailLength = 23;
			trailX = 9f;
			trailY = -9f;
			trailScl = 2f;
			range = 285f;
			maxRange = range;
			hitSize = 17.5f;
			constructor = UnitWaterMove::create;
			weapons.add(
				new Weapon("abyss-oryctolagus-big-mount") {{
					x = y = 0f;
					reload = 120f;
					recoil = 2f;
					rotate = true;
					mirror = false;
					shootSound = Sounds.shootBig;
					bullet = new BasicBulletType(4f, 60) {{
						width = height = 14f;
						lifetime = 71.25f;
						frontColor = Pal.sapBullet;
						backColor = Pal.sapBulletBack;
					}};
				}},
				new Weapon("abyss-oryctolagus-laser") {{
					x = 6f;
					y = 10f;
					reload = 60f;
					recoil = 1f;
					shots = 3;
					spacing = 15;
					rotate = true;
					alternate = true;
					shootSound = Sounds.shotgun;
					bullet = new ShrapnelBulletType() {{
						width = 8f;
						length = 80f;
						fromColor = Pal.sapBullet;
						toColor = Pal.sapBulletBack;
					}};
				}},
				new Weapon("abyss-oryctolagus-laser") {{
					x = 7f;
					y = -9f;
					reload = 60f;
					recoil = 1f;
					shots = 3;
					spacing = 15;
					rotate = true;
					shootSound = Sounds.shotgun;
					bullet = new ShrapnelBulletType() {{
						width = 8f;
						length = 80f;
						fromColor = Pal.sapBullet;
						toColor = Pal.sapBulletBack;
					}};
				}}
			);
		}};
		carcharodon = new UnitType("carcharodon") {{
			health = 11500;
			speed = 0.60f;
			accel = 0.4f;
			drag = 0.14f;
			rotateSpeed = 1.3f;
			trailLength = 50;
			trailX = 18f;
			trailY = -21f;
			trailScl = 3f;
			range = 320f;
			maxRange = range;
			constructor = UnitWaterMove::create;
			hitSize = 30f;
			abilities.add(
				new UnitSpawnAbility(katerni, 60f * 60f, 10f, -12f),
				new UnitSpawnAbility(katerni, 60f * 60f, -10f, -12f)
			);
			weapons.add(
				new Weapon("abyss-carcharodon-plasma-mount") {{
					x = y = 0f;
					reload = 600f;
					recoil = 5f;
					rotate = true;
					mirror = false;
					shootSound = Sounds.laserbig;
					bullet = new ContinuousLaserBulletType(50) {{
						width = 10f;
						length = 320f;
						lifetime = 192f;
						colors = new Color[]{Pal.sapBullet, Pal.sapBulletBack, Pal.sap};
					}};
				}},
				new Weapon("abyss-carcharodon-missile-mount") {{
					x = 16.75f;
					y = 0f;
					reload = 10f;
					recoil = 1f;
					rotate = true;
					maxRange = 160f;
					shootSound = Sounds.shootBig;
					bullet = new MissileBulletType(6f, 45) {{
						width = height = 10f;
						lifetime = 26f;
						frontColor = Pal.sapBullet;
						backColor = Pal.sapBulletBack;
					}};
				}}
			);
		}};
		orcinus = new UnitType("orcinus") {{
			health = 21000f;
			speed = 0.65f;
			drag = 0.17f;
			hitSize = 58f;
			armor = 16f;
			accel = 0.2f;
			rotateSpeed = 1.1f;
			rotateShooting = false;
			trailLength = 70;
			trailX = 23f;
			trailY = -32f;
			trailScl = 3.5f;
			range = 400f;
			maxRange = range;
			weapons.add(
				new CellWeapon("orcinus-foreshadow") {{
					x = y = 0f;
					reload = 600f;
					recoil = 8f;
					rotate = true;
					mirror = false;
					shootSound = Sounds.railgun;
					bullet = new PointBulletType(){{
						shootEffect = Fx.instShoot;
						hitEffect = Fx.instHit;
						smokeEffect = Fx.smokeCloud;
						trailEffect = Fx.instTrail;
						despawnEffect = Fx.instBomb;
						trailSpacing = 20f;
						damage = 1750;
						buildingDamageMultiplier = 0.25f;
						speed = range;
						hitShake = 6f;
						ammoMultiplier = 1f;
					}};
				}},
				new Weapon("orcinus-artillery") {{
					x = 16f;
					y = -36f;
					reload = 60f;
					alternate = true;
					rotate = true;
					maxRange = 200f;
					bullet = new ArtilleryBulletType(2f, 60) {{
						range = maxRange;
						lifetime = 100f;
						frontColor = Pal.sapBullet;
						backColor = Pal.sapBulletBack;
					}};
				}},
				new Weapon("orcinus-artillery") {{
					x = 14f;
					y = 20f;
					reload = 60f;
					alternate = false;
					rotate = true;
					maxRange = 200f;
					bullet = new ArtilleryBulletType(2f, 60) {{
						range = maxRange;
						lifetime = 100f;
						frontColor = Pal.sapBullet;
						backColor = Pal.sapBulletBack;
					}};
				}},
				new Weapon("orcinus-artillery") {{
					x = 24f;
					y = 0f;
					reload = 120f;
					rotate = true;
					maxRange = 300f;
					bullet = new ArtilleryBulletType(2f, 100) {{
						range = maxRange;
						lifetime = 150f;
						frontColor = Pal.sapBullet;
						backColor = Pal.sapBulletBack;
					}};
				}}
 			);
		}};
	}
}