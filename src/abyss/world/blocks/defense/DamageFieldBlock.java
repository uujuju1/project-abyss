package abyss.world.blocks.defense;

import arc.math.*;
import arc.util.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.graphics.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.entities.*;
import mindustry.world.Block;

public class DamageFieldBlock extends Block { 
	public float range = 80f;
	public int damage = 10;
	public @Nullable StatusEffect statusEffect;
	public float statusEffectDuration = 60f;

	public float reloadTime = 60f;
	public boolean targetsAir = true, targetsGround = true;

	public DamageFieldBlock(String name) {
		super(name);
		solid = destructible = sync = update = hasItems = hasLiquids = true;
	}

	@Override
	public void drawPlace(int x, int y, int rotation, boolean valid) {
		super.drawPlace(x, y, rotation, valid);
		Drawf.dashCircle(x * 8, y * 8, range, Pal.placing);
	}

	public class DamageFieldBlockBuild extends Building {
		float reload = 0f;
		@Override
		public void drawSelect() {
			Drawf.dashCircle(x, y, range, team.color);
		}

		@Override
		public void updateTile() {
			super.updateTile();
			if (cons.valid()) {
				DrawStatusEffect();
				if (reload >= reloadTime) {
					consume();
					Damage.damage(this.team, x, y, range, damage, targetsAir, targetsGround);
					if (statusEffect != null) {
						Damage.status(this.team, x, y, range, statusEffect, statusEffectDuration, targetsAir, targetsGround);
					}
					reload = 0f;
				}
				reload += Time.delta;
			}
		}

		public void DrawStatusEffect() {
			Draw.color(statusEffect.color);
			Draw.alpha(0.5f);
			Fill.circle(x, y, range + Mathf.absin(2f, 1f));
			Draw.alpha(1f);
			Draw.color(statusEffect.color.mul(0.5f));
			Lines.stroke(3f);
			Lines.circle(x, y, range + Mathf.absin(2f, 1f));
			Draw.reset();
		}
	}
}