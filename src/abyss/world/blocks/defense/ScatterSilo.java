package abyss.world.blocks.defense;

import arc.audio.*;
import arc.math.*;
import arc.util.*;
import arc.graphics.*;
import arc.scene.ui.layout.*;
import mindustry.gen.*;
import mindustry.graphics.*;
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
	public Sound shootSound = Sounds.shoot;

	public ScatterSilo(String name) {
		super(name);
		solid = destructible = update = configurable = true;
	}

	@Override
	public void setStats() {
		super.setStats();
		stats.add(Stat.reload, reloadTime, StatUnit.seconds);
		stats.add(Stat.range, range, StatUnit.blocks);
	}
	@Override
	public void drawPlace(int x, int y, int rotation, boolean valid){
		super.drawPlace(x, y, rotation, valid);
		Drawf.dashCircle(x * 8, y * 8, range, Pal.placing);
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

		@Override
		public void drawSelect() {
			Drawf.dashCircle(x, y, range, team.color);
		}

		public void shoot() {
			if (cons.valid()) {
				consume();
				for (int i = 0; i < shots; i++) {
					bullet.create(this, this.team, x, y, Mathf.random() * 360f);
				}
				shootSound.at(x, y, Mathf.random(0.9f, 1.1f));
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