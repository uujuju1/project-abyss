package abyss.world.blocks.defense;

import arc.math.*;
import arc.graphics.*;
import mindustry.ui.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.defense.Wall;

public class RefractiveWall extends Wall {
	public Color barColor = Color.white;
	public Effect hitEffect = Fx.none;
	public float damage = 1f, radius = 8f, minDamage = 1f;
	public int multiply = 1;
	public boolean targetAir = true, targetGround = true;

	public RefractiveWall(String name) {
		super(name);
	}

	@Override
	public void setStats() {
		super.setStats();
		stats.add(Stat.damage, damage);
		stats.add(Stat.range, radius/8, StatUnit.blocks);
	}

	@Override
	public void setBars() {
		super.setBars();
		bars.add("damage", enity -> new Bar("damage", barColor, () -> ((RefractiveWallBuild) enity).dmgf()));
	}

	public class RefractiveWallBuild extends Wall.WallBuild {
		public float dmg = health;

		public float dmgf() {
			return dmg/minDamage;
		}

		@Override
		public void updateTile() {
			super.updateTile();
			if (dmg < health - minDamage) {
				Damage.damage(this.team, x, y, radius, damage, targetAir, targetGround);
				hitEffect.at(x, y);
				dmg = health;
			}
			dmg = Mathf.approachDelta(dmg, health, 0.07f);
		}
	}
}