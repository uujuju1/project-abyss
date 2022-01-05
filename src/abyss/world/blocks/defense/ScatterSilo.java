package abyss.world.blocks.defense;

import arc.math.*;
import arc.util.*;
import arc.scene.ui.layout.*;
import mindustry.gen.*;
import mindustry.entities.bullet.*;
import mindustry.content.*;
import mindustry.world.Block;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;

public class ScatterSilo extends Block {
	// time needed to shoot again
	public float reloadTime = 60f;
	// range for setStats 
	public float range = 80f;
	// amount of bullets that are created
	public int shots = 10;
	// bullet created when button pressed
	public BulletType bullet = Bullets.standardCopper;

	public ScatterSilo(String name) {
		super(name);
		solid = destructible = update = configurable = hasItems = true;
	}

	@Override
	public void setStats() {
		super.setStats();
		stats.add(Stat.reload, reloadTime, StatUnit.seconds);
		stats.add(Stat.range, range, StatUnit.blocks);
	}

	public class ScatterSiloBuild extends Building {
		float timer = 0f;
		@Override
		public void buildConfiguration(Table table) {
			table.button(Icon.upload, () -> {
				if (timer <= 0f) {
					this.shoot();
					timer = reloadTime;
				}
			});
		}

		public void shoot() {
			if (cons.valid()) {
				consume();
				for (int i = 0; i < shots; i++) {
					bullet.create(this, this.team, x, y, Mathf.random() * 360f);
				}
			}
		}

		@Override
		public void updateTile() {
			if (timer >= 0f) {
				timer -= Time.delta;
			}
		}
	}
}