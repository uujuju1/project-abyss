package abyss.world.blocks.defense;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.gen.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.entities.*;
import mindustry.world.blocks.defense.Wall;

public class UnstableWall extends Wall {
	public int damage = 69;
	public float damageRadius = 420f;
	public Effect explodeEffect = Fx.none;
	public Color topColor = Pal.turretHeat;

	public TextureRegion topRegion;

	public UnstableWall(String name) {
		super(name);
	}

	@Override
	public void load() {
		super.load();
		topRegion = Core.atlas.find(name + "-top");
	}

	public class UnstableWallBuild extends WallBuild {
		@Override
		public void onDestroyed() {
			Damage.damage(this.team, x, y, damageRadius, damage);
			explodeEffect.at(x, y);
		}

		@Override
		public void draw() {
			float alpha = health/this.health;
			super.draw();
			Draw.alpha(alpha);
			Draw.color(topColor);
			Draw.rect(topRegion, x, y, 0);
			Draw.reset();
		}
	}
}