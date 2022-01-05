package abyss.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.*;

public class AbyssBullets implements ContentList {
	public static BulletType
		voidBullet1, voidBullet2, voidBullet3, voidBullet4,

		elecraBullet1, elecraBullet2;

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
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};

		elecraBullet1 = new LaserBulletType(30f) {{
			width = 4f;
			height = 160f;
			colors = new Color[]{Color.valueOf("CFCFCF"), Color.valueOf("EBEBEB"), Color.white};
		}};
		elecraBullet2 = new PointBulletType() {{
			shootEffect = Fx.instShoot;
			hitEffect = Fx.instHit;
			smokeEffect = Fx.smokeCloud;
			trailEffect = Fx.instTrail;
			despawnEffect = Fx.instBomb;
			trailSpacing = 20f;
			damage = 200;
			buildingDamageMultiplier = 0.25f;
			speed = brange;
			hitShake = 6f;
			ammoMultiplier = 1f;
		}};
		
	}
}