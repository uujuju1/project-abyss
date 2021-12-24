package abyss.world.blocks.defense;

import mindustry.gen.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.world.blocks.defense.Wall;

public class UnstableWall extends Wall {
	public int damage = 69;
	public float damageRadius = 420f;
	public Effect explodeEffect = Fx.none;

	public UnstableWall(String name) {
		super(name);
	}

	public class UnstableWallBuild extends WallBuild {
		@Override
		public void onDestroyed() {
			Damage.damage(this.team, x, y, damageRadius, damage);
			explodeEffect.at(x, y);
		}
	}
}