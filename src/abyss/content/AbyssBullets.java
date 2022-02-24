package abyss.content;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.*;

import abyss.graphics.*;

public class AbyssBullets implements ContentList {
	public static BulletType
		voidBullet1, voidBullet2, voidBullet3, voidBullet4,

		electraBullet1, electraBullet2,

		singularityBullet1, singularityBullet2, singularityBullet3, singularityBullet4;

	@Override
	public void load() {
		voidBullet1 = new BasicBulletType(5f, 15) {{
			width = 7f;
			height = 9f;
			ammoMultiplier = 3;
			lifetime = 32f;
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};
		voidBullet2 = new BasicBulletType(6f, 30) {{
			width = 9f;
			height = 11f;
			ammoMultiplier = 3;
			lifetime = 40f;
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};
		voidBullet3 = new BasicBulletType(7f, 90) {{
			width = 11f;
			height = 13f;
			ammoMultiplier = 3;
			lifetime = 40f;
			fragBullets = 2;
			fragBullet = voidBullet1;
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};
		voidBullet4 = new BasicBulletType(8f, 150) {{
			width = 11f;
			height = 13f;
			ammoMultiplier = 3;
			lifetime = 45f;
			fragBullets = 5;
			fragBullet = voidBullet2;
			shootEffect = AbyssFx.abyssShootBig;
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};

		electraBullet1 = new LaserBulletType(30f) {{
			width = 4f;
			length = 160f;
			colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
		}};
		electraBullet2 = new PointBulletType() {{
			shootEffect = Fx.instShoot;
			hitEffect = Fx.instHit;
			smokeEffect = Fx.smokeCloud;
			trailEffect = Fx.instTrail;
			despawnEffect = Fx.instBomb;
			trailSpacing = 20f;
			damage = 200;
			buildingDamageMultiplier = 0.25f;
			speed = 160f;
			hitShake = 6f;
			ammoMultiplier = 1f;
		}};
		
		singularityBullet1 = new BasicBulletType(2.5f, 25) {{
			lifetime = 25.6f;
			width = height = 8f;
			splashDamage = 25;
			splashDamageRadius = 32f;
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};
		singularityBullet2 = new BasicBulletType(3f, 40) {{
			lifetime = 40f;
			width = height = 10f;
			splashDamage = 40;
			splashDamageRadius = 32f;
			ammoMultiplier = 4;
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};
		singularityBullet3 = new BasicBulletType(2f, 120) {{
			lifetime = 84f;
			width = height = 10f;
			splashDamage = 120;
			splashDamageRadius = 48f;
			ammoMultiplier = 2;
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};
	}
}