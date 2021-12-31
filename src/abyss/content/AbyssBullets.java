package abyss.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.*;

public class AbyssBullets implements ContentList {
	public static BulletType
		voidBullet1, voidBullet2, voidBullet3, voidBullet4;

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
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};
		voidBullet4 = new BasicBulletType(8f, 150) {{
			width = 11f;
			height = 13f;
			ammoMultiplier = 3;
			frontColor = Color.valueOf("2E2E2E");
			backColor = Color.valueOf("1C1C1C");
		}};
	}
}