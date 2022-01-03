package abyss.world.blocks.defense;

import arc.math.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.entities.bullet.*;
import mindustry.content.*;
import mindustry.world.Block;

public class ScatterSilo extends Block {
	public float reloadTime = 60f;
	public int bulletAmount = 10;
	public BulletType bullet = Bullets.standardCopper;

	public ScatterSilo(String name) {
		super(name);
		solid = destructible = update = configurable = true;
	}

	public class ScatterSiloBuild extends Building {
		float timer = 0f;
		@Override
		public void BuildConfiguration(Table table) {
			table.button(Icon.upload, () -> {
				if (timer <= 0f) {
					this.shoot();
				}
			});
		}

		public void shoot() {
			for (int i = 0; i < bulletAmount; i++) {
				bullet.create(this, this.team, x, y, Mathf.random() * 360f);
			}
		}

		@Override
		public void UpdateTile() {
			if (timer >= 0f) {
				timer -= Time.delta;
			}
		}
	}
}